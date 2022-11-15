package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaymentTypeServiceImpl implements PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    @Override
    public List getNewPaymentType() {
        return paymentTypeRepository.findAll();
    }
}
