package com.bht.humanresource.dao;

import com.bht.humanresource.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@Repository
public class UserRepository {

    private static Set<User> users = new HashSet<>();

    static{
        users.add(new User(1, "a@gmail.com", new BCryptPasswordEncoder().encode("a@gmail.com"), "USER"));
        users.add(new User(2, "b@gmail.com", new BCryptPasswordEncoder().encode("b@gmail.com"), "ADMIN"));
    }

    public User getUserByEmail(String email){
        return users.stream().filter(u -> email.equalsIgnoreCase(u.getEmail())).findFirst().orElse(null);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        UserRepository.users = users;
    }

    public void saveUser(User u) {
        int maxId = users.stream().max(Comparator.comparing(User::getId)).get().getId();
        u.setId(maxId + 1);
        users.add(u);
    }
}
