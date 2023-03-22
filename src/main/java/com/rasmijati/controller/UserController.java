/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserRole;

/**
 *
 * @author admin
 */
public class UserController {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setName("rasmi");
        user.setAddress("bkt");
        user.setEmail("rasmi@gmail.com");
        user.setPassword("rasi");
        user.setRole(UserRole.USER);
        System.out.println(" Users :" + user.toString());
        user = new User(2L, "jatui", "hfj", "ff@gfd.fg", "hsfdh", UserRole.ADMIN);
        System.out.println(" Users :" + user);
    }
}
