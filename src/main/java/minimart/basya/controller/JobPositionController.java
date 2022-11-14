package minimart.basya.controller;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.model.JobPosition;
import minimart.basya.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meta/jobPosition")
@Slf4j
public class JobPositionController {
    @Autowired
    private JobPositionService jobPositionService;
    @GetMapping
    public List createJobPosition() {
        try {
            List list = jobPositionService.CreateNewJobPosition();
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
