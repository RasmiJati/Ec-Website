/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.model.UserType;
import com.rasmijati.repository.UserRepository;
import static com.rasmijati.util.Validator.isValidEmail;
import static com.rasmijati.util.Validator.isValidPassword;
import static com.rasmijati.util.Validator.isValidPhoneNumber;
import static com.rasmijati.util.Validator.isValidString;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;

//    static is removed in this method as it won't be accessible by other class
    public void crudOption(UserRepository userRepository) {
        this.userRepository = userRepository;
        String choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Crud operation for user");
        do {
            System.out.println();
            System.out.println("Enter 1 to create : ");
            System.out.println("Enter 2 to list : ");
            System.out.println("Enter 3 to edit : ");
            System.out.println("Enter 4 to delete : ");
            System.out.println("Enter 5 to exit : ");
            System.out.println();

            choice = sc.next();

            switch (choice) {
                case "1":
                    create();
                    break;
                case "2":
                    findAll();
                    break;
                case "3":
                    edit();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        } while (!choice.equals("0"));
    }

//static is used as only static variable and method can be used in other static method i.e main method    
    public static void create() {
        Long id = null;
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String password = null;
        UserType utype = null;

        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter id : ");
            id = sc.nextLong();
        }
        while (name == null || name.isEmpty()) {
            System.out.println("Enter name : ");
            name = sc.next();
            if (!isValidString(name)) {
                System.err.println("Invalid name!!!");
                name = null;
            }
        }
        while (address == null || address.isEmpty()) {
            System.out.println("Enter address : ");
            address = sc.next();
            if (!isValidString(address)) {
                System.err.println("Invalid Address!!!");
                address = null;
            }
        }
        while (phone == null || phone.isEmpty()) {
            System.out.println("Enter phone number : ");
            phone = sc.next();
            if (!isValidPhoneNumber(phone)) {
                System.err.println("Invalid phone!!!");
                phone = null;
            }
        }
        while (email == null || email.isEmpty()) {
            System.out.println("Enter email : ");
            email = sc.next();
            if (!isValidEmail(email)) {
                System.err.println("Invalid Email!!!");
                email = null;
            }
        }

        while (password == null || password.isEmpty()) {
            System.out.println("Enter password : ");
            password = sc.next();
            if (!isValidPassword(password)) {
                System.err.println("Invalid Password!!!");
                password = null;
            }
        }
        while (utype == null) {
            System.out.println("Enter user type (ADMIN / USER) : ");
            String entered_role = sc.next().toUpperCase();
            utype = UserType.valueOf(entered_role);
            if (!isValidString(entered_role)) {
                System.err.println("Invalid Role!!!");
                utype = null;
            }
        }

        User user = new User(id, name, address, phone, email, password, utype);
        userRepository.create(user);
        System.out.println("Insertion Successful!!");
    }

    public static void findAll() {
        System.out.println("User List ");
        userRepository.findAll().stream()
                .forEach(x -> System.out.println(x));
    }

    public static void delete() {
        System.out.println("Enter Id for delete operation : ");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        User user = userRepository.findById(id);
        if (user == null) {
            System.err.println("User of Id " + id + " not found");
        } else {
            userRepository.delete(user);
            System.out.println("Deletion Successful!!");
        }
    }

    public static void edit() {
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String password = null;
        UserType utype = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id for edit operation : ");
        Long id = sc.nextLong();
        User user = userRepository.findById(id);

        if (user == null) {
            System.out.println("User of id " + id + "not found");
        } else {
            while (name == null || name.isEmpty()) {
                System.out.println("Enter name : ");
                name = sc.next();
                if (!isValidString(name)) {
                    System.err.println("Invalid name!!!");
                    name = null;
                }
            }
            while (address == null || address.isEmpty()) {
                System.out.println("Enter address : ");
                address = sc.next();
                if (!isValidString(address)) {
                    System.err.println("Invalid Address!!!");
                    address = null;
                }
            }
            while (phone == null || phone.isEmpty()) {
                System.out.println("Enter phone number : ");
                phone = sc.next();
                if (!isValidPhoneNumber(phone)) {
                    System.err.println("Invalid phone!!!");
                    phone = null;
                }
            }
            while (email == null || email.isEmpty()) {
                System.out.println("Enter email : ");
                email = sc.next();
                if (!isValidEmail(email)) {
                    System.err.println("Invalid Email!!!");
                    email = null;
                }
            }

            while (password == null || password.isEmpty()) {
                System.out.println("Enter password : ");
                password = sc.next();
                if (!isValidPassword(password)) {
                    System.err.println("Invalid Password!!!");
                    password = null;
                }
            }
            while (utype == null) {
                System.out.println("Enter user type (ADMIN / USER) : ");
                String entered_role = sc.next().toUpperCase();
                utype = UserType.valueOf(entered_role);
                if (!isValidString(entered_role)) {
                    System.err.println("Invalid User Type!!!");
                    utype = null;
                }
            }
            user = new User(id, name, address, phone, email, password, utype);
            userRepository.edit(user);
            System.out.println("Edition Successfull !!");
        }
    }
}
