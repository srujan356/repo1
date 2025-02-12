package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPersonalDetails extends JFrame implements ActionListener {

    JTextField nameField, emailField; // Add more fields as needed
    JButton saveButton, cancelButton;

    AddPersonalDetails(String username) {
        setTitle("Add Personal Details");
        setLayout(null);
        setBounds(400, 150, 600, 400);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 100, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 100, 200, 30);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 150, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 150, 200, 30);
        add(emailField);

        saveButton = new JButton("Save");
        saveButton.setBounds(100, 220, 100, 30);
        saveButton.addActionListener(this);
        add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 220, 100, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Close on exit
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == saveButton) {
            // Logic to save personal details
            JOptionPane.showMessageDialog(this, "Details saved!");
            this.setVisible(false); // Close the window
        } else if (ae.getSource() == cancelButton) {
            this.setVisible(false); // Close the window
        }
    }
}
