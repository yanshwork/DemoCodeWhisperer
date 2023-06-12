package org.example;

//create a class to check email reget to check if the email is valid or not
public class VerifyEmail {

    public static boolean isValid(String email) {
        // Regex to check valid email address
        String regex = "^[\\w-_.+]*[\\w-_.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    // create unit test to test the email
    public static void main(String[] args) {
        String email = "shteckel1@VerifyEmailClassMain.com";
        System.out.println("The email is " + email);
        System.out.println("Is email valid? " + isValid(email));
    }

}
