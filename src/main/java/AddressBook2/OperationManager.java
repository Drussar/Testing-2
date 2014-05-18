/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Saber
 */
public class OperationManager {

    private List<Contact> contacts = new ArrayList<Contact>();

    //Function that adds contacts
    public boolean addContact(String FName, String LName, String Email, String Phonumber, String Address) {
        Contact c = new Contact(FName, LName, Email, Phonumber, Address);
        return contacts.add(c);

    }

    //Function that removes contacts
    public boolean removeContact(Contact c) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact next = contacts.get(i);
            if (c == next) {
                contacts.remove(c);
                return true;
            }
        }
        return false;

    }

    // Index of current position
    public Contact get(int index) {
        return contacts.get(index);
    }

    //size of the list
    public int size() {
        return contacts.size();
    }

    // Sorts by a parameter in the Contact class like getFname, getLName
    public void sortBy(String s) throws ReflectiveOperationException {

        final Method m = Contact.class.getMethod(s);

        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                try {
                    return ((String) m.invoke(c1)).compareTo(((String) m.invoke(c2)));

                } catch (ReflectiveOperationException ex) {
                    return 0;
                }
            }
        });
    }

    // Saves the file using a Filechooser
    // Should be saved with the .txt ending
    public void saveContact(JFrame f) throws IOException {

        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(".txt files", "txt"));
        int returnVal = chooser.showSaveDialog(f);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));) {

                objectOut.writeObject(contacts);

            } catch (IOException ex) {
                System.err.println(ex);
            }

        }

    }

    //Loads an agenda file!
    public void loadContact(JFrame f) throws IOException, ClassNotFoundException {

        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(".txt files", "txt"));
        int returnVal = chooser.showOpenDialog(f);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try (ObjectInputStream objectin = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));) {

                contacts = (List<Contact>) objectin.readObject();

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

    }

}
