package org.example;

//import junit.framework.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//create a class VerifyEmailTest to test email with assertEquals method
public class VerifyEmailTest {
    @Test
    public void testVerifyEmail() {
        assertEquals(true, VerifyEmail.isValid("shteckel@amazon.com"));
        assertEquals(false, VerifyEmail.isValid("shteckel@amazon"));
    }
}
