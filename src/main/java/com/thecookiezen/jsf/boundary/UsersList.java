package com.thecookiezen.jsf.boundary;

import com.thecookiezen.jsf.control.Repository;
import com.thecookiezen.jsf.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean
@RequestScoped
public class UsersList {

    @Inject
    private Repository repository;

    @Getter @Setter
    private Collection<User> users;

    @PostConstruct
    public void init() {
        users = repository.getUsers();
    }
}
