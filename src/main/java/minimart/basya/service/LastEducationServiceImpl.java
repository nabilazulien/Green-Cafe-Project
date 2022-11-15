package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.repository.LastEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LastEducationServiceImpl implements LastEducationService {
    @Autowired
    private LastEducationRepository lastEducationRepository;
    @Override
    public List getNewLastEducation() {
        return lastEducationRepository.findAll();
    }
}
