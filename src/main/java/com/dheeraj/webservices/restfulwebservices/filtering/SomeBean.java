package com.dheeraj.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"value3"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String value1;
    private String value2;
    //@JsonIgnore
    private String value3;
    public SomeBean() {
    }
    public SomeBean(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }


}
