package com.example.swagger.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @author lenny
 * @since 2020/4/23 7:49 PM
 */
@ApiModel
public class User {
    private String name;
    private Integer age;
    private Company company;

    public User(String name, Integer age, Company company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
