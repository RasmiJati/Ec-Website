/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserRole;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;

    public static void main(String[] args) {
        userRepository = new UserRepository();
        create();
    }

//static is used as only static variable and method can be used in other static method i.e main method    
    public static void create() {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        Long id = null;
        String name = null;
        String address = null;
        String email = null;
        String password = null;
        UserRole role = null;

        System.out.println("Enter id : ");
        id = sc.nextLong();

        System.out.println("Enter name : ");
        name = sc.next();

        System.out.println("Enter address : ");
        address = sc.next();

        System.out.println("Enter email : ");
        email = sc.next();

        System.out.println("Enter password : ");
        password = sc.next();

        System.out.println("Enter user type (ADMIN / USER) : ");
        String entered_role = sc.next().toUpperCase();
        role = UserRole.valueOf(entered_role);

        user = new User(id, name, address, email, password, role);
        userRepository.create(user);
        userRepository.findAll().stream().forEach(x -> System.out.println("Users : " + x));
    }
}
