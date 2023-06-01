package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class verify_emailTest {

    @Test
    @DisplayName("Test verify_email possitive")
    public void verify_emailTest1() {
        verify_email verify_email = new verify_email();
        String emailtest = "sasdas@sdasd.com";
        System.out.println("The email is " + emailtest);
        System.out.println("Is email valid? " + verify_email.isValid(emailtest));
        /// add assertEquals to true
        assertEquals(true, verify_email.isValid(emailtest));

    }

    @Test
    @DisplayName("Test verify_email negative")
    public void verify_emailTest2() {
        verify_email verify_email = new verify_email();
        String emailtest = "sasdas@sd-asd.com";
        System.out.println("The email is " + emailtest);
        System.out.println("Is email valid? " + verify_email.isValid(emailtest));
        assertEquals(false, verify_email.isValid(emailtest));
    }

}
