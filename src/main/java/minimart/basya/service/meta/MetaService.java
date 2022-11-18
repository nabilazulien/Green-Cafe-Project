package minimart.basya.service.meta;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;

public interface MetaService {
    ResponseEntity Gender();

    ResponseEntity itemCategory();

    ResponseEntity province() throws UnknownError, JsonProcessingException;
    ResponseEntity city(String provinceId) throws UnknownError, JsonProcessingException;

    ResponseEntity district(String cityId) throws UnknownError;

    ResponseEntity village(String districtId) throws UnknownError;

    ResponseEntity bank() throws UnknownError, FileNotFoundException, JsonProcessingException;

    ResponseEntity bankCode(String bankCode) throws UnknownError;
}
