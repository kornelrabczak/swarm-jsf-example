package com.thecookiezen.jsf.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private long id;
    private String name;
    private int age;
    private String address;

}
