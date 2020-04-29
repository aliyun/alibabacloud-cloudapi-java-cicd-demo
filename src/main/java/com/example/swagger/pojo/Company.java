package com.example.swagger.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @author lenny
 * @since 2020/4/23 7:49 PM
 */
@ApiModel
public class Company {

    private String name;
    private String location;

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
