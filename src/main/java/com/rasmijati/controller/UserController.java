/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserType;
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
        findAll();
        edit();
//        delete();
    }

//static is used as only static variable and method can be used in other static method i.e main method    
    public static void create() {
        Long id = null;
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String password = null;
        UserType role = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id : ");
        id = sc.nextLong();

        System.out.println("Enter name : ");
        name = sc.next();

        System.out.println("Enter address : ");
        address = sc.next();

        System.out.println("Enter phone number : ");
        phone = sc.next();

        System.out.println("Enter email : ");
        email = sc.next();

        System.out.println("Enter password : ");
        password = sc.next();

        System.out.println("Enter user type (ADMIN / USER) : ");
        String entered_role = sc.next().toUpperCase();
        role = UserType.valueOf(entered_role);

        User user = new User(id, name, address, phone, email, password, role);
        userRepository.create(user);
    }

    public static void findAll() {
        System.out.println("User List : ");
        userRepository.findAll().stream()
                .forEach(x -> System.out.println(x));
    }

    public static void delete() {
        System.out.println("Enter Id for delete operation : ");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        User user = userRepository.findById(id);
        userRepository.delete(user);
    }

    public static void edit() {
        Long id = null;
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String password = null;
        UserType role = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id for edit operation : ");
        id = sc.nextLong();
        User user = userRepository.findById(id);

        if (user == null) {
            System.out.println("User of id " + id + "not found");
        } else {

            System.out.println("Enter name : ");
            name = sc.next();

            System.out.println("Enter address : ");
            address = sc.next();

            System.out.println("Enter phone number : ");
            phone = sc.next();

            System.out.println("Enter email : ");
            email = sc.next();

            System.out.println("Enter password : ");
            password = sc.next();

            System.out.println("Enter user type (ADMIN / USER) : ");
            String entered_role = sc.next().toUpperCase();
            role = UserType.valueOf(entered_role);
        }
        user = new User(id, name, address, phone, email, password, role);
        userRepository.edit(user);
    }
}
