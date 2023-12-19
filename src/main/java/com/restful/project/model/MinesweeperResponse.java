package com.restful.project.model;

public class MinesweeperResponse {
    private final String[] hints;

    public MinesweeperResponse(String[] hints) {
        this.hints = hints.clone();
    }

    public String[] getHints() {
        return hints.clone();
    }
}