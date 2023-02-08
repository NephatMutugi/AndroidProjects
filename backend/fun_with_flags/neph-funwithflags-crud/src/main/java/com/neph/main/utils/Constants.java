package com.neph.main.utils;

/**
 * @ Author NMuchiri
 **/
public enum Constants {

    NAME("name"),
    ABBREVIATION("abbreviation");

    private final String name;
    Constants(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
