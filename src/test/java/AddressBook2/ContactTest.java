/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AddressBook2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saber
 */
public class ContactTest {
    
    public ContactTest() {
        
    }
    Contact yo = new Contact("Andre","Rodrigues","BLABLA","14151251","Rua do trabalho");
    @Test
     public void getFName(){ 
       assertEquals(yo.getFName(), "Andre");
     }
     
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
       //(String FName, String LName, String Email, String Phonumber, String Address
        Contact yo = new Contact("Andre","Rodrigues","BLABLA","14151251","Rua do trabalho");
        assertEquals(yo.getFName(), "Rodrigues");
    }

}
