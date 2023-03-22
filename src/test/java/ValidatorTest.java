
import com.rasmijati.util.Validator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class ValidatorTest {

    public ValidatorTest() {
    }
    

    /**
     * Test of isValidString method, of class Validator.
     */
    @Test
    public void testIsValidString() {
        System.out.println("isValidString");
//        String str = "";
//        boolean expResult = false;
//        boolean result = Validator.isValidString(str);
//        assertEquals(expResult, result);

        assertEquals(true, Validator.isValidString("rasmi"));
        assertEquals(true, Validator.isValidString("RASMI"));
        assertEquals(true, Validator.isValidString("rAsmI"));
        assertEquals(false, Validator.isValidString(" "));
        assertFalse(Validator.isValidString("a@smi!"));
        assertTrue(Validator.isValidString("Rasmi"));

    }

    /**
     * Test of isValidNumber method, of class Validator.
     */
    @Test
    public void testIsValidPhoneNumber() {
        System.out.println("isValidNumber");
        assertEquals(false, Validator.isValidPhoneNumber("985478"));
        assertEquals(true, Validator.isValidPhoneNumber("9841526378"));
        assertTrue(Validator.isValidPhoneNumber("9841526378"));
        assertFalse(Validator.isValidPhoneNumber("8596747894"));
    }

    /**
     * Test of isValidEmail method, of class Validator.
     */
    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        assertEquals(false, Validator.isValidEmail("rasm!@gmail.com"));
        assertEquals(true, Validator.isValidEmail("rasmi@gmail.com"));
        assertTrue(Validator.isValidEmail("rasmi01@gmail.com"));
        assertTrue(Validator.isValidEmail("rasmi.jati@gmail.com"));
        assertFalse(Validator.isValidEmail("rasmi01@gma!l.com"));
        assertFalse(Validator.isValidEmail("rasmi"));
    }
    
    
     /**
     * Test of isValidPasswprd method, of class Validator.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        assertEquals(false, Validator.isValidPassword("rasmi"));
        assertEquals(true, Validator.isValidPassword("R@smi1234"));
        assertTrue(Validator.isValidPassword("rasmi@J123"));
        assertTrue(Validator.isValidPassword("rasmi65J@ti"));
        assertFalse(Validator.isValidPassword("rasmijati"));
        assertFalse(Validator.isValidPassword("ras1234"));
    }
}
