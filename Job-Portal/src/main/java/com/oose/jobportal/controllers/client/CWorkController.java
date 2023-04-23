package com.oose.jobportal.controllers.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/work")
@CrossOrigin("http://127.0.0.1:5501/")
public class CWorkController {


    public ResponseEntity<?> createWork(@RequestBody Json) {

        return ResponseEntity.ok();
    }
}
