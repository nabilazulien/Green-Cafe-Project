package minimart.basya.controller.metaa;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.service.meta.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meta/village")
@Slf4j
public class VillageController {
    @Autowired
    private MetaService metaService;
    @GetMapping
    public ResponseEntity<Object> getVillageId(@RequestParam String districtId){
        log.info("/api/meta/village");
        try {
            return metaService.city(districtId);
        }catch (Exception e){
            log.error("error = "+e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
