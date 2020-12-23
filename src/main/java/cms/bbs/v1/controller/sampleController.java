package cms.bbs.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

    @GetMapping("/hello")
    public String[] hello(){
        return new String[]{"hello", "world"};
    }

}
