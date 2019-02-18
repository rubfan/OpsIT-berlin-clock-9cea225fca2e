package com.ubs.opsit.interviews;

public enum Lamp {
    OFF("O"),
    YELLOW("Y"),
    RED("R");

    private String color;

    Lamp(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
