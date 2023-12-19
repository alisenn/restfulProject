package com.restful.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.project.model.RpnRequest;
import com.restful.project.model.RpnResponse;
import com.restful.project.service.RpnService;

@RestController
public class RpnController {
    
    private final RpnService rpnService;

    public RpnController(RpnService rpnService) {
        this.rpnService = rpnService;
    }
    
    @PostMapping("/calculate")
    public RpnResponse calculate(@RequestBody RpnRequest request) {
        double result = rpnService.calculate(request.getExpression());
        return new RpnResponse(result);
    }
}