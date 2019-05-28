package tdd.step.by.step.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthzController {

    @GetMapping("/healthz")
    public String healthz(){
        return "All UP and Running";
    }
}
