package org.example;

import java.io.*;

//create a class verify_email with reget expression and verify method
public class verify_email {
    public static boolean isValid(String email) {
        // suggest a regex to verify email with
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        return email.matches(regex);

    }

    // create unit test to test the email
    public static void main(String[] args) {
        String email = "sasdas@sda-sd.sadas";
        System.out.println("The email is " + email);
        System.out.println("Is email valid? " + isValid(email));
    }

}
