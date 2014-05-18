/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Contact class used
// it has First Name, Last Name, Email, PhoneNumber and Address
package AddressBook2;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Saber
 * 
 * 
 * 
 * 
 */
public class Contact implements Serializable{
    
    private static final long serialVersionUID = 267269276;
   
    private String fname;
    private String lname;
    private String email;
    private String phoneNumber;
    private String address;
    
    public Contact(String FName, String LName, String Email, String Phonumber, String Address){
        
        this.fname = FName;
        this.lname = LName;
        this.email = Email;
        this.phoneNumber = Phonumber;
        this.address = Address;
    }

    public String getFName() {
        return fname;
    }

    public String getLName() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setFName(String FName) {
        this.fname = FName;
    }

    public void setLName(String LName) {
        this.lname = LName;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setPhonumber(String Phonumber) {
        this.phoneNumber = Phonumber;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }
    
  
  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.fname);
        hash = 53 * hash + Objects.hashCode(this.lname);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.phoneNumber);
        hash = 53 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.lname, other.lname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
    @Override
public String toString() {
 return String.format("%-12s | %-12s | %-21s | %-12s | %-12s", fname, lname, email, phoneNumber, address);
}

   
}
