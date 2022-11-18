package minimart.basya.service.meta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.extern.slf4j.Slf4j;
import minimart.basya.model.constant.Gender;
import minimart.basya.model.constant.ItemCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MetaServiceImpl implements MetaService {
    @Override
    public ResponseEntity Gender() {
        ArrayList<Object> result = new ArrayList<>();
        for (Gender gender : Gender.values()) {
            HashMap<String, Object> mapGender = new HashMap<>();
            mapGender.put("name", gender.getNama());
            mapGender.put("code", gender.getCode());
            result.add(mapGender);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity itemCategory() {
        ArrayList<Object> result = new ArrayList<>();
        for (ItemCategory itemCategory : ItemCategory.values()) {
            HashMap<String, Object> mapItemCategory = new HashMap<>();
            mapItemCategory.put("name", itemCategory.getName());
            result.add(mapItemCategory);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity province() throws UnknownError, JsonProcessingException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://www.emsifa.com/api-wilayah-indonesia/api/provinces.json";
            URI uri = new URI(url);
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            log.info("respon status" + response.getStatusCode());

            if (!response.getStatusCode().equals("200")) {
                return new ResponseEntity("error get province", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }


    }

    @Override
    public ResponseEntity city(String provinceId) throws UnknownError, JsonProcessingException {
        log.info("service city");
        try {
            RestTemplate restTemplate = new RestTemplate();


            URI uri = new URI("https://www.emsifa.com/api-wilayah-indonesia/api/regencies/" + provinceId + ".json");

            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            log.info("respon status" + response.getStatusCode());


            return new ResponseEntity(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public ResponseEntity district(String cityId) throws UnknownError {
        log.info("service district");
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://emsifa.github.io/api-wilayah-indonesia/api/districts/" + cityId + ".json");
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            log.info("respons status " + response.getStatusCode());
            return new ResponseEntity(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public ResponseEntity village(String districtId) throws UnknownError {
        log.info("service village");
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://emsifa.github.io/api-wilayah-indonesia/api/villages/" + districtId + ".json");
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            log.info("respons status " + response.getStatusCode());
            return new ResponseEntity(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    @Override
    public ResponseEntity bank() throws UnknownError, FileNotFoundException, JsonProcessingException {
        log.info("service bank");
        List<Map<String, Object>> bankFromResource = getBankFromResource();
        return new ResponseEntity(bankFromResource, HttpStatus.OK);
    }


    @Override
    public ResponseEntity bankCode(String bankCode) throws UnknownError {
        log.info("service bank code");
        try {
            //filter data from getBankFromResource() berdasarkan bankcode
            List<Map<String, Object>> bankList = getBankFromResource()
                    .stream().filter(s -> s.get("bank_code").toString().equals(bankCode)).collect(Collectors.toList());

            if (bankList.isEmpty()) {
                return new ResponseEntity("INVALID_BANK_CODE", HttpStatus.OK);
            }

            //mengmbil data index ke 0 dari list
            Object bank = bankList.get(0);

            return new ResponseEntity(bank, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }


    public List<Map<String, Object>> getBankFromResource() throws FileNotFoundException, JsonProcessingException {

        File file = new File("./src/main/resources/bank.json");
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();


        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(sb.toString(), List.class);

    }
}
