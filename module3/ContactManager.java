import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactManager {

    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("James Adams", new Contact("James Adams", "+1 617 555 9191")); 
        contacts.put("Adam Smith", new Contact("Adam Smith", "+1 617 555 8181")); 
        contacts.put("James Shoemaker", new Contact("James Shoemaker", "+1 617 555 6161")); 
        contacts.put("Peter Coyle", new Contact("Peter Coyle", "+1 617 666 0121")); 


        String nonExistentContactName = "Adams Lovelace";

        Contact nonExistentContact  = contacts.get(nonExistentContactName);
        if(nonExistentContact == null){
            System.out.println("Contact Not Found: "+ nonExistentContactName);
        } else{ 
            System.out.println(nonExistentContact.toString());
        }

        String existingContactName = "Ada Lovelace";

        Contact existingContact  = contacts.get(existingContactName);
        if(existingContact == null){
            System.out.println("Contact Not Found: "+ existingContactName);
        } else{ 
            System.out.println(existingContact.toString());
        }

        List<Contact> sortedContacts = new ArrayList<>(contacts.values());
        sortedContacts.sort( (a,b) -> a.getName().compareTo(b.getName()));
        System.out.println(" === All Contacts === ");
        for(Contact contact : sortedContacts){
            System.out.println(contact);
        } 
    }

}