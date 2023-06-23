package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pin, rePin;
    String pinNumber;

    PinChange(String pinNumber) {
        
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(275, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pinText = new JLabel("New Pin: ");
        pinText.setBounds(180, 350, 700, 35);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 15));
        image.add(pinText);

        JLabel rePinText = new JLabel("Re-Enter Pin: ");
        rePinText.setBounds(180, 390, 700, 35);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 15));
        image.add(rePinText);

        pin = new JPasswordField();
        pin.setBounds(310, 355, 180, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setMargin(new Insets(0, 12, 0, 0));
        add(pin);

        rePin = new JPasswordField();
        rePin.setBounds(310, 395, 180, 25);
        rePin.setFont(new Font("Raleway", Font.BOLD, 16));
        rePin.setMargin(new Insets(0, 12, 0, 0));
        add(rePin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Go Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String newPin = pin.getText();
                String reNewPin = rePin.getText();

                if (!newPin.equals(reNewPin)) {
                    JOptionPane.showMessageDialog(null, "Pin Doesn't Matched");
                    return;
                }
                
                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter your Pin");
                    return;
                }
                
                if (reNewPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter your Pin");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+reNewPin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pinNumber = '"+reNewPin+"' where pinNumber = '"+pinNumber+"'";
                String query3 = "update signupthree set pin = '"+reNewPin+"' where pin = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                
                setVisible(false);
                new Transactions(reNewPin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
