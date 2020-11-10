package com.company;

import java.util.Scanner;

public class UI {
    Scanner scan = new Scanner(System.in);

    public User createUser(){
        System.out.println("First Name: ");
        String firstName = scan.nextLine();

        System.out.println("Last Name: ");
        String lastName = scan.nextLine();

        System.out.println("Address: ");
        String address = scan.nextLine();

        System.out.println("City: ");
        String city = scan.nextLine();

        System.out.println("State: ");
        String state = scan.nextLine();

        System.out.println("Zipcode: ");
        String zipcode = scan.nextLine();

        System.out.println("Email: ");
        String email = scan.nextLine();

        System.out.println("Phone Number: ");
        String phoneNumber = scan.nextLine();

        System.out.println("Credit Card Number: ");
        String ccNumber = scan.nextLine();

        User user = new User(firstName, lastName, address, city, state, zipcode, email, phoneNumber, ccNumber);
        return user;
    }
}
