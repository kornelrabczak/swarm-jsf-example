package com.thecookiezen.jsf.control;

import com.thecookiezen.jsf.entity.Docker;
import com.thecookiezen.jsf.entity.User;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import javax.ejb.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

    public List<Docker> getDocker(String searchQuery) {
        ResteasyProviderFactory resteasyProviderFactory = ResteasyProviderFactory.getInstance();
        ResteasyClient client = new ResteasyClientBuilder().providerFactory(resteasyProviderFactory).disableTrustManager().build();
        ResteasyWebTarget target = client.target("https://registry.hub.docker.com");
        SimpleClient proxy = target.proxy(SimpleClient.class);
        List<Docker> results = proxy.findDockerImages(searchQuery).getResults();
        System.out.println(results.size());
        return results;
    }
}
