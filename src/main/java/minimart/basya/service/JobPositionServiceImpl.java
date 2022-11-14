package minimart.basya.service;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.dto.request.Respons.JobPositionRespons;
import minimart.basya.model.JobPosition;
import minimart.basya.repository.JobPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JobPositionServiceImpl implements JobPositionService {
    @Autowired
    private JobPositionRepository jobPositionRepository;
    @Override
    public List CreateNewJobPosition() {
        List<JobPosition> all = jobPositionRepository.findAll();

        JobPositionRespons jobPositionRespons =  new JobPositionRespons();

        for (JobPosition jobPosition : all) {
        jobPositionRespons.setTitle(jobPosition.getTitle());
        jobPositionRespons.setSalary(jobPosition.getSalary());
        }
       ArrayList<JobPositionRespons> objects = new ArrayList<>();
       objects.add(jobPositionRespons);
       return objects;
    }
}
