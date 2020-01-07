package com.rizky92.latihanviewmodelmade.models;

public class Weathers {
    private int id;
    private String name, curWeather, desc, temp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurWeather() {
        return curWeather;
    }

    public void setCurWeather(String curWeather) {
        this.curWeather = curWeather;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
