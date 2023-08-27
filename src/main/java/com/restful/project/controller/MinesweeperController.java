package com.restful.project.controller;

import com.restful.project.model.MinesweeperRequest;
import com.restful.project.model.MinesweeperResponse;
import com.restful.project.service.MinesweeperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinesweeperController {

    @Autowired
    private MinesweeperService minesweeperService;
    
    @PostMapping("/show-hints")
    public MinesweeperResponse showHints(@RequestBody MinesweeperRequest request) {
        String[] hints = minesweeperService.showHints(request.getSquare());
        MinesweeperResponse response = new MinesweeperResponse();
        response.setHints(hints);
        return response;
    }
}
