package com.thecookiezen.jsf.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Docker implements Serializable {
    private String name;
    private String description;
}
