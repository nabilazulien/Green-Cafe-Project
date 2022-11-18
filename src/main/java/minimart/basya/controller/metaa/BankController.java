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
@RequestMapping("/api/meta")
@Slf4j
public class BankController {
    @Autowired
    private MetaService metaService;
    @GetMapping("/bank")
    public ResponseEntity<Object> getBank(){
        log.info("/api/meta/bank");
        try {
            return metaService.bank();
        }catch (Exception e){
            log.error("error = "+e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bank/code")
    public ResponseEntity<Object> getBankCode(@RequestParam String bankCode){
        log.info("/api/meta/bank");
        try {
            return metaService.bankCode(bankCode);
        }catch (Exception e){
            log.error("error = "+e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
