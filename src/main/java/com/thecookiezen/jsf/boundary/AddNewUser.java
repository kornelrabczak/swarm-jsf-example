package com.thecookiezen.jsf.boundary;

import com.thecookiezen.jsf.control.Repository;
import com.thecookiezen.jsf.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ManagedBean
@RequestScoped
public class AddNewUser {
    private static final Logger log = Logger.getLogger(AddNewUser.class.getName());

    @Inject
    Repository repository;

    @Getter
    @Setter
    private User user = new User();

    public String createUser() {
        repository.addNewUser(user);
        return "index";
    }
}
