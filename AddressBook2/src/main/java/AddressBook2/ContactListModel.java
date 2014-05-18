/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AddressBook2;


import java.io.IOException;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;

/**
 *
 * @author Saber
 */
public class ContactListModel extends AbstractListModel<Contact>{
    
    //private variable created for manipulation and connection between model and operationmanager
    private OperationManager aa;
    
    public ContactListModel(){
   
     aa = new OperationManager();
    
    }
    
    //repeated functions that act as a bridge!
public boolean addContact(String FName,String LName,String Email, String Phonumber, String Address){
        boolean returnValue = aa.addContact(FName,LName,Email,Phonumber,Address);
        fireIntervalAdded(this, getSize(), getSize());
        return returnValue;
        
    }

public boolean removeContact(Contact c) {
    boolean returnValue = aa.removeContact(c);
    fireIntervalAdded(this, getSize(), getSize());
    return returnValue;
    
}

public void sortBy(String s) throws ReflectiveOperationException {
    aa.sortBy(s);
    fireContentsChanged(aa, 0, aa.size());
}

 public void setFName(Contact c, String FName) {
        c.setFName(FName);
    }

    public void setLName(Contact c,String LName) {
       c.setLName(LName);
    }

    public void setEmail(Contact c, String Email) {
       c.setEmail(Email);
    }

    public void setPhonumber(Contact c, String Phonumber) {
       c.setPhonumber(Phonumber);
    }

    public void setAddress(Contact c, String Address) {
       c.setAddress(Address);
    }
    
    
    public void saveContact(JFrame f) throws IOException{
        aa.saveContact(f);
      
    }
    
    public void loadContact(JFrame f) throws IOException, ClassNotFoundException{
        aa.loadContact(f);
        fireContentsChanged(aa, 0, aa.size());
      
    }

@Override
public int getSize() {
  return aa.size();
}

    @Override
    public Contact getElementAt(int index) {
    return aa.get(index);
}
    
}
