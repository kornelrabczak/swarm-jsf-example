package com.thecookiezen.jsf.control;

import com.thecookiezen.jsf.entity.User;

import javax.ejb.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Singleton
public class Repository {

    private final Map<Long, User> users = new HashMap<>();

    public void addNewUser(User user) {
        if (user.getId() == 0L) {
            user.setId(new Random().nextLong());
        }
        users.put(user.getId(), user);
    }

    public User getUser(Long userId) {
        return users.get(userId);
    }

    public Collection<User> getUsers() {
        return users.values().stream().collect(Collectors.toList());
    }
}
