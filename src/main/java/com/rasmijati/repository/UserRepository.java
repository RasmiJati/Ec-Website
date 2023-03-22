/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRepository {

    private List<User> user_list;

    public UserRepository() {
        this.user_list = new ArrayList<>();
    }

    public void create(User u) {
        this.user_list.add(u);
    }

    public List<User> findAll() {
        return this.user_list;
    }

    public User findById(Long id) {
        for (User u : this.user_list) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void delete(User u) {
        this.user_list.remove(u);
    }

    public void edit(User u) {
        this.user_list.stream()
                .filter(x->x.getId()
                .equals(u.getId()))
                .forEach(ulist -> {
                    ulist.setName(u.getEmail());
                    ulist.setAddress(u.getAddress());
                    ulist.setEmail(u.getEmail());
                    ulist.setPassword(u.getPassword());
                    ulist.setRole(u.getRole());
                });
    }
}
