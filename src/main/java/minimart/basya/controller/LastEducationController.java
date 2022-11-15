package minimart.basya.controller;

import lombok.extern.slf4j.Slf4j;
import minimart.basya.service.LastEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meta/lastEducation")
@Slf4j
public class LastEducationController {
    @Autowired
    private LastEducationService lastEducationService;
    @GetMapping
    public List getLastEducation(){
        try{
            log.info("start controller");
            List list = lastEducationService.getNewLastEducation();
            log.info("end controller");
            return list;
        }catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
