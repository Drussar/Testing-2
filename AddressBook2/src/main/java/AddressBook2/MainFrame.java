/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AddressBook2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import javax.swing.WindowConstants;

/**
 *
 * @author Saber
 */
public class MainFrame {
    
    
    public MainFrame(){
        
        // Main Frame and main panel
        final JFrame frame = new JFrame("AddressBook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        
        // Subpanel added for adding 2 buttons on the south part of the layout
        JPanel subPane = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        
        //adding menu bar
        JMenuBar bar = new JMenuBar();
        panel.add(bar, BorderLayout.NORTH);
        
        // adding the menu bar items
        JMenu item1 = new JMenu("File");
        JMenu item2 = new JMenu("Sort");
        JMenu item3 = new JMenu("Edit");
        bar.add(item1);
        bar.add(item2);
        bar.add(item3);
        
        //Instancing the subitems of the menu bar
        JMenuItem menu1 = new JMenuItem("Save");
        JMenuItem menu2 = new JMenuItem("Load");
        JMenuItem menu3 = new JMenuItem("FName");
        JMenuItem menu4 = new JMenuItem("LName");
        JMenuItem menu5 = new JMenuItem("Email");
        JMenuItem menu6 = new JMenuItem("Phone");
        JMenuItem menu7 = new JMenuItem("Address");
        JMenuItem menu8 = new JMenuItem("FName");
        JMenuItem menu9 = new JMenuItem("LName");
        JMenuItem menu10 = new JMenuItem("Email");
        JMenuItem menu11 = new JMenuItem("Phone");
        JMenuItem menu12 = new JMenuItem("Address");
        
        // creation of the 2 contact manipulation buttons to the subpanel
        JButton button1 = new JButton("Add Contact");
        JButton button2 = new JButton("Remove Contact");
        subPane.add(button1);
        subPane.add(button2);
        
        //adding subpanel
        panel.add(subPane, BorderLayout.SOUTH);
        
        //adding the submenus to the item bar menus
        item1.add(menu1);
        item1.add(menu2);
        item2.add(menu3);
        item2.add(menu4);
        item2.add(menu5);
        item2.add(menu6);
        item2.add(menu7);
        item3.add(menu8);
        item3.add(menu9);
        item3.add(menu10);
        item3.add(menu11);
        item3.add(menu12);
        
        //creation of the list that will display the contacts
        final JList<Contact> list = new JList<>();
        list.setFont(new Font("Courier New", Font.PLAIN, 14));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final ContactListModel model = new ContactListModel();
        list.setModel(model);
        
        //Adds contacts!
         button1.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                     
                        //criaçao da 2º frame e do 2º painel
                      final JFrame frame2 = new JFrame("New Contact");
                      
                       frame2.setResizable(false);
		       frame2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
                       frame2.setSize(500, 200);
                       JPanel newContactPanel = new JPanel();
                       newContactPanel.setLayout(null);
                      

			JLabel insertFName = new JLabel("FName:");
			JLabel insertLName = new JLabel("LName:");
			JLabel insertEmail = new JLabel("Email:");
                        JLabel insertPhonumber = new JLabel("Phonumber");
                        JLabel insertAddress = new JLabel("Address");
                        
			insertFName.setBounds(10, 10, 300, 30);
			insertLName.setBounds(10, 50, 300, 30);
			insertEmail.setBounds(10, 90, 300, 30);
                        insertPhonumber.setBounds(10, 130, 300, 30);
                        insertAddress.setBounds(10, 170, 300, 30);

			final JTextField fname = new JTextField();
			final JTextField lname = new JTextField();
                        final JTextField email = new JTextField();
                        final JTextField phonumber = new JTextField();
                        final JTextField address = new JTextField();
                        
                       
                        
			
			fname.setBounds(80, 10, 200, 30);
			lname.setBounds(80, 50, 200, 30);
			email.setBounds(80, 90, 200, 30);
                        phonumber.setBounds(80,130 , 200, 30);
                        address.setBounds(80, 170, 300, 30);

			JButton ok = new JButton("OK");
			JButton cancel = new JButton("Cancel");
			ok.setBounds(120, 220, 80, 30);
			cancel.setBounds(220, 220, 80, 30);
                        
                        // gets the values of the textfields when "ok" is pressed
                        ok.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) {
                                    
                                    
                              String gfname =  fname.getText();
                              String glname = lname.getText();
                              String gemail = email.getText();
                              String gphonumber =  phonumber.getText();      
                              String gaddress = address.getText();
                                    
                                        model.addContact(gfname, glname ,gemail, gphonumber, gaddress);
					frame2.dispose();
				}
                        });

			
                                
			cancel.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) { 
					frame2.dispose();
				} 
                        
                        
                    });
        //adiçao dos varios componentes ao painel secundario                
        newContactPanel.add(insertFName);
        newContactPanel.add(insertLName);      
        newContactPanel.add(insertEmail);      
        newContactPanel.add(insertPhonumber);      
        newContactPanel.add(insertAddress);      
        newContactPanel.add(fname);      
        newContactPanel.add(lname);      
        newContactPanel.add(email);      
        newContactPanel.add(phonumber);
        newContactPanel.add(address);
        newContactPanel.add(ok);      
        newContactPanel.add(cancel);      
        frame2.add(newContactPanel);    
        frame2.setSize(570, 300);
        frame2.setVisible(true);
       
                }});
         
         //Removes element currently selected
         button2.addActionListener(
                 new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                        model.removeContact(list.getSelectedValue());
                     
                    }
                }
         );
         
         //saves the list
          menu1.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {
                         model.saveContact(frame);
                     } catch (IOException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
               
                    }
                }
       
         );
          
          //loads the list
           menu2.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {
                         model.loadContact(frame);
                     } catch (IOException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    }
                }
       
         );
         
         //sorting by First Name
         
         menu3.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {                 
                         model.sortBy("getFName");
                     } catch (ReflectiveOperationException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
                }
       
         );
         
         
            //sort by Last Name
          menu4.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {                 
                         model.sortBy("getLName");
                     } catch (ReflectiveOperationException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
                }
       
         );
               
          //sort by Email
           menu5.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {                 
                         model.sortBy("getEmail");
                     } catch (ReflectiveOperationException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
                }
       
         );
           
           
           //sort by Phonenumber
          menu6.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {                 
                         model.sortBy("getPhonumber");
                     } catch (ReflectiveOperationException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
                }
       
         );
              
          
          //sort by Address
        menu7.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                     try {                 
                         model.sortBy("getAddress");
                     } catch (ReflectiveOperationException ex) {
                         Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
                }
       
         );
        
        //Changes the first name of the highlighted line     
        
          menu8.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                        
                       String s = JOptionPane.showInputDialog("Qual o novo FName?");
                     model.setFName(list.getSelectedValue(),s);
          
                    }
                }
       
         );
          
         //Changes the last name of the highlighted line
           menu9.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                        
                       String s = JOptionPane.showInputDialog("Qual o novo LName?");
                     model.setLName(list.getSelectedValue(),s);
          
                    }
                }
       
         );
            
            //Changes the email of the highlighted line
            menu10.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                        
                       String s = JOptionPane.showInputDialog("Qual o novo Email?");
                     model.setEmail(list.getSelectedValue(),s);
          
                    }
                }
       
         );
              
              //Changes the phonenumber of the highlighted line
              menu11.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                        
                       String s = JOptionPane.showInputDialog("Qual o novo PhoneNumber?");
                     model.setPhonumber(list.getSelectedValue(),s);
          
                    }
                }
       
         );
                
                
                
                
            //Changes the address of the highlighted line    
             menu12.addActionListener(
              new ActionListener(){
                 @Override
                    public void actionPerformed(ActionEvent e){
                        
                       String s = JOptionPane.showInputDialog("Qual o novo Address?");
                     model.setAddress(list.getSelectedValue(),s);
          
                    }
                }
       
         );
         
         
         
        // Contacts Added for testing purposes
        model.addContact("Andre", "Rodrigues", "ddragon@titan.com", "12345667735","TitanVille");
        model.addContact("Ana", "Medeiros", "ana@titan.com", "12345628635","Aveiro");
        model.addContact("Eddy", "Pasterino", "jantarino@titan.com", "582595285","Lisboa");
        model.addContact("Alvaro", "Remos", "codegeass@titan.com", "66776236235","Britannia");
        
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(new JScrollPane(list, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        panel.repaint();
        frame.setSize(570, 300);
        frame.setVisible(true);
       
       
    }
}
