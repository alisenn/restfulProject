package com.restful.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.project.model.MinesweeperRequest;
import com.restful.project.model.MinesweeperResponse;
import com.restful.project.service.MinesweeperService;

@RestController
public class MinesweeperController {

    private final MinesweeperService minesweeperService;

    public MinesweeperController(MinesweeperService minesweeperService) {
        this.minesweeperService = minesweeperService;
    }
    
    @PostMapping("/show-hints")
    public MinesweeperResponse showHints(@RequestBody MinesweeperRequest request) {
        String[] hints = minesweeperService.showHints(request.getSquare());
        return new MinesweeperResponse(hints);
    }
}