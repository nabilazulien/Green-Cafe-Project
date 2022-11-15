package minimart.basya.controller;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meta/paymentType")
@Slf4j
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;
    @GetMapping
    public List getPaymentType() {
        try {
            log.info("start controller");
            List list = paymentTypeService.getNewPaymentType();
            log.info("end controller");
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
