import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactTest {
    
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    } 
  
    @Test 
    public void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test 
    public void constructor_setsPhoneNumberCorrectly(){
        assertEquals("+1 617 555 0101", contact.getPhoneNumber());
    }

    @Test
    public void getName_returnsExactString_notTransformed() { 
        assertEquals("Ada Lovelace", contact.getName());
    } 
 
  @Test
    public void toString_containsName() { 
        assertTrue(contact.toString().contains("Ada Lovelace"));
    }
 
    @Test
    public void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    public void constructor_twoConstructorObjectsHaveThierOwnNameAndPhoneNumbers(){
        Contact differentContact = new Contact("Different Name", "+1 444 555 6666");
        assertEquals("Different Name", differentContact.getName());
        assertEquals("+1 444 555 6666", differentContact.getPhoneNumber());

        assertEquals("Ada Lovelace", contact.getName());
        assertEquals("+1 617 555 0101", contact.getPhoneNumber());
    }

}
