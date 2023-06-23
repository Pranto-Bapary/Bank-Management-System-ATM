
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String pinNumber;
    
    Withdrawl(String pinNumber){
        
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel amountText = new JLabel("Enter the amount you want to Withdraw: ");
        amountText.setBounds(200,300,400,20);
        amountText.setForeground(Color.WHITE);
        amountText.setFont(new Font("System",Font.BOLD,15));
        image.add(amountText);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setMargin(new Insets(0, 12, 0, 0));
        amount.setBounds(180, 350, 320, 30);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
        back = new JButton("Go Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == withdraw){
            String withdrawAmount = amount.getText();
            Date date = new Date();
            if(withdrawAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Kindly Enter the amount you want to withdraw");
            }else{
                
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+withdrawAmount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Taka " + withdrawAmount + " Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }
        
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
