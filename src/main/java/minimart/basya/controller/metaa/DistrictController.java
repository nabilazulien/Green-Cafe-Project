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
@RequestMapping("/api/meta/district")
@Slf4j
public class DistrictController {
    @Autowired
    private MetaService metaService;
    @GetMapping
    public ResponseEntity<Object> getDistrict(@RequestParam String cityId){
        log.info("/api/meta/dsitrict");
        try {
            return metaService.city(cityId);
        }catch (Exception e){
            log.error("error = "+e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
