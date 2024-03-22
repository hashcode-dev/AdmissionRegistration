package com.schoolmate.admissionregistration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admission")
public class AdmissionRegistrationController {

    @GetMapping("/healthCheck")
    public String getHealthStatus(){
        return "Statis Ok";
    }
}
