package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField NID, birth;
    JButton next;
    JRadioButton sYes, sNo, eYes, eNo;
    JComboBox religion, category, occupation, education, income;
    String formNo; 
    
    SignupTwo(String formNo){
        
        this.formNo = formNo;
        
        setTitle("New Account Application Form - Page 2");
        
        //Background color of the page
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        //Sub Headings
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(270, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name );
        
        String valReligion[] = {"Islam", "Hindu", "Christian", "Other"};
        religion = new JComboBox(valReligion);
     
        religion.setBounds(300, 140, 360, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel fathersName = new JLabel("Catagory: ");
        fathersName.setFont(new Font("Raleway", Font.BOLD, 20));
        fathersName.setBounds(100, 190, 200, 30);
        add(fathersName);
        
        String valCategory[] = {"General Account", "Student Account", "Sales Account", "Other"};
        category = new JComboBox(valCategory);
        
        
        category.setBounds(300, 190, 360, 30);
        category.setFont(new Font("Raleway", Font.BOLD, 16));
        category.setBackground(Color.white);
        add(category);
        
        JLabel mothersName = new JLabel("Income: ");
        mothersName.setFont(new Font("Raleway", Font.BOLD, 20));
        mothersName.setBounds(100, 240, 200, 30);
        add(mothersName);
        
        String incomeCategory[] = {"< 30,000", "< 50,000", "< 1,00,000", "Upto 5,000,00"};
        income = new JComboBox(incomeCategory);
        
        
        income.setBounds(300, 240, 360, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBackground(Color.white);
        add(income);
        
        JLabel dob = new JLabel("Educational: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 290, 200, 30);
        add(dob);
        
        String educationCategory[] = {"Undergraduate", "Graduate", "Post-Graduate", "Other"};
        education = new JComboBox(educationCategory);
        
        
        education.setBounds(300, 290, 360, 30);
        education.setFont(new Font("Raleway", Font.BOLD, 16));
        education.setBackground(Color.white);
        add(education);
        
        
        JLabel email = new JLabel("Occupation: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        String occupationCategory[] = {"Job Holder", "Self-Employed", "Business", "Student", "Retired"};
        occupation = new JComboBox(occupationCategory);
        
        occupation.setBounds(300, 340, 360, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 16));
        occupation.setBackground(Color.white);
        add(occupation);
        
        
        JLabel maritalStatus = new JLabel("NID: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);
        
        NID = new JTextField();
        NID.setBounds(300, 390, 360, 30);
        NID.setFont(new Font("Raleway", Font.BOLD, 16));
        NID.setMargin(new Insets(0, 12, 0, 0));
        add(NID);
        
        
        JLabel address = new JLabel("Birth Certificate No: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        birth = new JTextField();
        birth.setBounds(300, 440, 360, 30);
        birth.setFont(new Font("Raleway", Font.BOLD, 16));
        birth.setMargin(new Insets(0, 12, 0, 0));
        add(birth);
        
        
        JLabel city = new JLabel("Senior Citizen: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 490, 100, 30);
        sYes.setBackground(Color.white);
        sYes.setFont(new Font("Raleway", Font.BOLD, 16));
        add(sYes);
        
        sNo = new JRadioButton("No");
        sNo.setBounds(430, 490, 120, 30);
        sNo.setBackground(Color.white);
        sNo.setFont(new Font("Raleway", Font.BOLD, 16));
        add(sNo);
        
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(sYes);
        maritalGroup.add(sNo);

        
        
        JLabel state = new JLabel("Existing Account: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 540, 100, 30);
        eYes.setBackground(Color.white);
        eYes.setFont(new Font("Raleway", Font.BOLD, 16));
        add(eYes);
        
        eNo = new JRadioButton("No");
        eNo.setBounds(430, 540, 120, 30);
        eNo.setBackground(Color.white);
        eNo.setFont(new Font("Raleway", Font.BOLD, 16));
        add(eNo);
        
        
        maritalGroup = new ButtonGroup();
        maritalGroup.add(sYes);
        maritalGroup.add(sNo);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(580, 590, 80, 30);
        next.addActionListener(this);
        add(next);
        
        //Page Size and Location
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sReligion = (String) religion.getSelectedItem();
        String sCategory = (String) category.getSelectedItem();
        String sIncome = (String) income.getSelectedItem();
        String sEducation = (String) education.getSelectedItem();
        String sOccupation = (String) occupation.getSelectedItem();
        
        String sNid = NID.getText();
        String sBirth = birth.getText();
        
       
        String seniorCitizen = null;
        
        if(sYes.isSelected()){
            seniorCitizen = "Yes";
        } else if(sNo.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if(eYes.isSelected()){
            existingAccount = "Yes";
        } else if(eNo.isSelected()){
            existingAccount = "No";
        } 
        
        try{
     
                Conn c = new Conn();
                String query = "Insert into signuptwo values('"+formNo+"','"+sReligion+"', '"+sIncome+"', '"+sEducation+"', '"+sOccupation+"','"+sNid+"', '"+sBirth  +"', '"+seniorCitizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                //signup form three
                setVisible(false);
                new SignupThree(formNo).setVisible(true);
            }
            
        catch(Exception e){
            System.out.println(e);
        }
        
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

