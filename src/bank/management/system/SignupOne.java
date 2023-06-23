
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, mnameTextField, emailTextField, addressTextField, cityTextField, stateTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        //Background color of the page
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        //Generating Random Application Number
        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L) + 1000L);
        
        JLabel formNo = new JLabel("Application Form No. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);
        
        //Sub Headings
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(270, 80, 400, 30);
        add(personDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 360, 30);
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setMargin(new Insets(0, 12, 0, 0));
        add(nameTextField);
        
        JLabel fathersName = new JLabel("Father's Name: ");
        fathersName.setFont(new Font("Raleway", Font.BOLD, 20));
        fathersName.setBounds(100, 190, 200, 30);
        add(fathersName);
        
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 360, 30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameTextField.setMargin(new Insets(0, 12, 0, 0));
        add(fnameTextField);
        
        JLabel mothersName = new JLabel("Mother's Name: ");
        mothersName.setFont(new Font("Raleway", Font.BOLD, 20));
        mothersName.setBounds(100, 240, 200, 30);
        add(mothersName);
        
        mnameTextField = new JTextField();
        mnameTextField.setBounds(300, 240, 360, 30);
        mnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        mnameTextField.setMargin(new Insets(0, 12, 0, 0));
        add(mnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 290, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 290, 360, 30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 16));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 340, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 340, 60, 30);
        male.setBackground(Color.white);
        male.setFont(new Font("Raleway", Font.BOLD, 16));
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 340, 120, 30);
        female.setBackground(Color.white);
        female.setFont(new Font("Raleway", Font.BOLD, 16));
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 390, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 390, 360, 30);
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        emailTextField.setMargin(new Insets(0, 12, 0, 0));
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 440, 200, 30);
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 440, 100, 30);
        married.setBackground(Color.white);
        married.setFont(new Font("Raleway", Font.BOLD, 16));
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430, 440, 120, 30);
        unmarried.setBackground(Color.white);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 16));
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(590, 440, 120, 30);
        other.setBackground(Color.white);
        other.setFont(new Font("Raleway", Font.BOLD, 16));
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 490, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(300, 490, 360, 30);
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        addressTextField.setMargin(new Insets(0, 12, 0, 0));
        add(addressTextField);
        
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 540, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 540, 360, 30);
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        cityTextField.setMargin(new Insets(0, 12, 0, 0));
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 590, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 590, 360, 30);
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        stateTextField.setMargin(new Insets(0, 12, 0, 0));
        add(stateTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(580, 645, 80, 30);
        next.addActionListener(this);
        add(next);
        
        //Page Size and Location
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formNo = "" + random; //long
        String name = nameTextField.getText();
        
        String fName = fnameTextField.getText();
        String mName = mnameTextField.getText();
        
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        }
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        } else if(other.isSelected()){
            marital = "Other";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else if(fName.equals("")){
                JOptionPane.showMessageDialog(null, "Father's name is required");
            } else if(mName.equals("")){
                JOptionPane.showMessageDialog(null, "Mother's name is required");
            } else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your valid email address");
            } else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your valid address");
            } else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your current city");
            } else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your current state");
            } else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your date of birth");
            } else{
                Conn c = new Conn();
                String query = "Insert into signup values('"+formNo+"','"+name+"', '"+fName+"', '"+mName+"', '"+dob+"', '"+gender+"','"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }
}
