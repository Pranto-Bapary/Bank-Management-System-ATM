
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    //Global Variables
    JButton login, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    //Constructor
    Login(){
        
        //Title of the Page
        setTitle("Bank Management System");
        
        setLayout(null);
        
        //Setting the icons and resizing it
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //Headings of the page
        JLabel text = new JLabel("Welcome to PinkCity ATM");
        text.setBounds(180, 40, 600, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);
        
        //Input text field
        JLabel cardNo = new JLabel("Card No: ");
        cardNo.setBounds(120, 150, 150, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 345, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        cardTextField.setMargin(new Insets(0, 12, 0, 0));
        add(cardTextField);
        
        JLabel pinNo = new JLabel("Pin No: ");
        pinNo.setBounds(120, 215, 150, 30);
        pinNo.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pinNo);
        
        //Password text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 215, 345, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 16));
        pinTextField.setMargin(new Insets(0, 12, 0, 0));
        add(pinTextField);
        
        //SignIn Button
        login = new JButton("Sign In");
        login.setBounds(190, 280, 100, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //Clear Button
        clear = new JButton("Clear");
        clear.setBounds(470, 280, 100, 35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        //SignUp Button
        signUp = new JButton("Sign Up");
        signUp.setBounds(330, 280, 100, 35);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        //Page Background Color
        getContentPane().setBackground(Color.white);
        
        //Height and Width of the page
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText(null);
            pinTextField.setText(null);
            
        } else if(ae.getSource() == login){
            Conn conn = new Conn();
            
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"' ";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number of Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        } else if(ae.getSource() == signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
