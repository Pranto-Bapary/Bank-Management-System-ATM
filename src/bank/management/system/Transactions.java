
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
   
    JButton deposit, withdrawl, fastcash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    Transactions(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transactions");
        text.setBounds(217,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        withdrawl = new JButton("Cash Wihtdrawl");
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        image.add(miniStatement);
        miniStatement.addActionListener(this);
        
        pinChange = new JButton("Change Pin");
        pinChange.setBounds(170,485,150,30);
        image.add(pinChange);
        pinChange.addActionListener(this);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        image.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        image.add(exit);
        exit.addActionListener(this);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
