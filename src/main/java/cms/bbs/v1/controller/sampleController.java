package cms.bbs.v1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/sample")
@Log4j2
public class sampleController {

    @GetMapping("/hello")
    public void hello(){
        log.info("##################################");
    }

}
