package com.restful.project.controller;

import com.restful.project.model.RpnRequest;
import com.restful.project.model.RpnResponse;
import com.restful.project.service.RpnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpnController {
    
    @Autowired
    private RpnService rpnService;
    
    @PostMapping("/calculate")
    public RpnResponse calculate(@RequestBody RpnRequest request) {
        double result = rpnService.calculate(request.getExpression());
        RpnResponse response = new RpnResponse();
        response.setResult(result);
        return response;
    }
}
