package com.thecookiezen.jsf.boundary;

import com.thecookiezen.jsf.control.Repository;
import com.thecookiezen.jsf.entity.Docker;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "dockerList")
@RequestScoped
public class DockerList implements Serializable {

    @Getter
    @Setter
    private String query = "";

    @Getter @Setter
    private List<Docker> results = Collections.emptyList();

    @Inject
    private Repository repository;

    public void search() {
        results = repository.getDocker(query);
    }

}
