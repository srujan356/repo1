package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    // Components for the signup page
    private JTextField tfUsername, tfPassword, tfEmail;
    private JButton btnSignup, btnBack;

    // Constructor
    public Signup() {
        setTitle("Signup Page");
        setSize(500, 600); // Increased height to accommodate the image
        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout for easier component management

        // Create a custom panel for the background
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null); // Using null layout for absolute positioning
        add(backgroundPanel, BorderLayout.CENTER);

        // Creating Labels
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 240, 150, 30);
        backgroundPanel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 290, 150, 30);
        backgroundPanel.add(lblPassword);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 340, 150, 30);
        backgroundPanel.add(lblEmail);

        // Creating TextFields
        tfUsername = new JTextField();
        tfUsername.setBounds(200, 240, 200, 30);
        backgroundPanel.add(tfUsername);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(200, 290, 200, 30);
        backgroundPanel.add(tfPassword);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 340, 200, 30);
        backgroundPanel.add(tfEmail);

        // Creating Buttons
        btnSignup = new JButton("Signup");
        btnSignup.setBounds(100, 400, 100, 30);
        btnSignup.addActionListener(this);
        backgroundPanel.add(btnSignup);

        btnBack = new JButton("Back");
        btnBack.setBounds(250, 400, 100, 30);
        btnBack.addActionListener(this);
        backgroundPanel.add(btnBack);

        // Make the frame visible
        setVisible(true);
    }

    // Handling button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignup) {
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            String email = tfEmail.getText();

            // Basic validation
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Logic for signing up the user (e.g., saving to the database)
                JOptionPane.showMessageDialog(this, "Signup successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Optionally, clear fields after signup
                tfUsername.setText("");
                tfPassword.setText("");
                tfEmail.setText("");
            }
        } else if (e.getSource() == btnBack) {
            // Logic to go back (e.g., back to the login page)
            this.setVisible(false);
            // new Login(); // Uncomment this line if you have a Login class to go back to
        }
    }

    // Custom JPanel to draw the background image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            // Load the background image
            backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/holiday.jpg")).getImage();
            // Check if the image loaded successfully
            if (backgroundImage == null) {
                JOptionPane.showMessageDialog(this, "Image not found!", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1); // Exit if the image is not found
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
