package com.restful.project.model;

public class RpnResponse {
    private final double result;

    public RpnResponse(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }
}