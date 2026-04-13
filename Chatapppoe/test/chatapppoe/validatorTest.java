/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chatapppoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class validatorTest {
    
    public validatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidUsername method, of class validator.
     */
    @Test
    public void testIsValidUsername() {
    
        String username = "kana_";
        
        boolean result = validator.isValidUsername(username);
        
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isValidPassword method, of class validator.
     */
    @Test
    public void testIsValidPassword() {
        validator validator = new validator();
        String password = "Yakboa1!_";
        
        boolean result = validator.isValidPassword(password);
        
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isValidSouthAfricanNumber method, of class validator.
     */
    @Test
    public void testIsValidSouthAfricanNumber() {
        validator validator = new validator();
        String number = " +2712345678";
        boolean result = validator.isValidSouthAfricanNumber(number);
        
        assertTrue(result);
        
    }
    
}
