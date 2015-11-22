package com.thecookiezen.jsf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchResult implements Serializable {

    List<Docker> results;
}
