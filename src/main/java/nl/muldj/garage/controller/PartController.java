package nl.muldj.garage.controller;

import nl.muldj.garage.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartController {

    @Autowired
    PartService partService;

    @GetMapping("/parts")
    public ResponseEntity<Object> getAllParts() { return new ResponseEntity<>(partService.getAllParts(), HttpStatus.OK); }


}
