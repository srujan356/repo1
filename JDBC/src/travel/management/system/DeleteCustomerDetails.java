package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCustomerDetails extends JFrame implements ActionListener {

    JButton deleteButton, cancelButton;
    String username;

    DeleteCustomerDetails(String username) {
        this.username = username;

        setBounds(450, 200, 500, 300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblText = new JLabel("Delete Personal Details?");
        lblText.setBounds(50, 50, 400, 25);
        lblText.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblText);

        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBounds(100, 150, 120, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(250, 150, 120, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            // Delete personal details from the database
            try {
                Conn c = new Conn();
                String query = "DELETE FROM customer WHERE username = '" + username + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Personal Details Deleted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteCustomerDetails("");
    }
}
