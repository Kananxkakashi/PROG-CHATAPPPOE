package chatapppoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MessageServiceTest {

    @Test
    void testCreateHash() {

        String hash =
                MessageService.createHash(
                        "1234567890",
                        1,
                        "Hello World");

        assertEquals(
                "12:1:HELLOWORLD",
                hash);
    }

    @Test
    void testUsernameValidation() {

        assertEquals(
                true,
                validator.isValidUsername("ab_cd"));
    }

    @Test
    void testPasswordValidation() {

        assertEquals(
                true,
                validator.isValidPassword("Password1!"));
    }

    @Test
    void testPhoneValidation() {

        assertEquals(
                true,
                validator.isValidSouthAfricanNumber("0821234567"));
    }

    @Test
    void testMessageCreation() {

        Message msg =
                MessageService.createMessage(
                        "Test Message");

        assertEquals(
                "Test Message",
                msg.getMessage());
    }
}
