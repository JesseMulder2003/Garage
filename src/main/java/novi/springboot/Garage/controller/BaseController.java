package novi.springboot.Garage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String sayhello(){return "Welkom bij de garage API!";}
}
