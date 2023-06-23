
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
   
    JButton a1, a2, a3, a4, a5, a6, back;
    String pinNumber;
    
    FastCash(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(217,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
        a1 = new JButton("TK 100");
        a1.setBounds(170,415,150,30);
        image.add(a1);
        a1.addActionListener(this);
        
        a2 = new JButton("TK 200");
        a2.setBounds(355,415,150,30); 
        image.add(a2);
        a2.addActionListener(this);
        
        a3 = new JButton("TK 500");
        a3.setBounds(170,450,150,30);
        image.add(a3);
        a3.addActionListener(this);
        
        a4 = new JButton("TK 1000");
        a4.setBounds(355,450,150,30);
        image.add(a4);
        a4.addActionListener(this);
        
        a5 = new JButton("TK 5000");
        a5.setBounds(170,485,150,30);
        image.add(a5);
        a5.addActionListener(this);
        
        a6 = new JButton("TK 10000");
        a6.setBounds(355,485,150,30);
        image.add(a6);
        a6.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            
        }else{
            
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                //calculating balance
                ResultSet rs = c.s.executeQuery("select * from bank where '"+pinNumber+"'");
                int balance = 0;
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Taka " + amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
            }catch(Exception e ){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
