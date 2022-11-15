package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JobPositionServiceImpl implements JobPositionService {
    @Autowired
    private JobPositionRepository jobPositionRepository;
    @Override
    public List CreateNewJobPosition() {

        return jobPositionRepository.findAll();

    }
}
