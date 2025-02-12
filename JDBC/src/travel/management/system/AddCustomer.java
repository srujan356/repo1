package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    ButtonGroup genderGroup;
    JRadioButton male, female;
    JLabel lblUsername, lblName, gender, labelName, labelUsername;
    JTextField tfNumber, tfCountry, tfPhone, tfEmail;
    JComboBox<String> comboId;
    JButton back, add;

    String username;

    AddCustomer(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 850, 450);

        lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(50, 20, 300, 20);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelUsername.setBounds(200, 20, 200, 20);
        add(labelUsername);

        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(Color.BLACK);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblId.setBounds(50, 60, 300, 20);
        add(lblId);

        comboId = new JComboBox<>(new String[]{"Aadhar Card", "Passport", "Driving Licence", "Others"});
        comboId.setBounds(200, 60, 200, 20);
        comboId.setBackground(Color.white);
        add(comboId);

        JLabel lblNumber = new JLabel("ID Number:");
        lblNumber.setForeground(Color.BLACK);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNumber.setBounds(50, 100, 300, 20);
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200, 100, 200, 20);
        tfNumber.setBackground(Color.white);
        add(tfNumber);

        lblName = new JLabel("Name:");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(50, 140, 300, 20);
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(200, 140, 200, 20);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelName);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gender.setBounds(50, 180, 300, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.PLAIN, 18));
        male.setBounds(200, 180, 100, 20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.PLAIN, 18));
        female.setBounds(300, 180, 100, 20);
        female.setBackground(Color.white);
        add(female);

        // To select any one
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setForeground(Color.BLACK);
        lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCountry.setBounds(50, 220, 300, 20);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200, 220, 200, 20);
        tfCountry.setBackground(Color.white);
        add(tfCountry);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setForeground(Color.BLACK);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPhone.setBounds(50, 265, 300, 25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 265, 200, 20);
        tfPhone.setBackground(Color.white);
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(50, 310, 300, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 310, 200, 20);
        tfEmail.setBackground(Color.white);
        add(tfEmail);

        add = new JButton("Add");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(150, 350, 100, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(450, 350, 100, 30);
        back.addActionListener(this);
        add(back);

        // To show un-writable username and name
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'");
            if (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 450, 420);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelUsername.getText();
            String id = (String) comboId.getSelectedItem();
            String idNumber = tfNumber.getText();
            String name = labelName.getText();
            String number = tfPhone.getText();
            String email = tfEmail.getText();
            String country = tfCountry.getText();
            String gender = null;

            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else {
                JOptionPane.showMessageDialog(null, "Please select a gender.");
                return; // Exit the method if gender is not selected
            }

            // Validate input fields
            if (idNumber.isEmpty() || name.isEmpty() || country.isEmpty() || number.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "INSERT INTO customer VALUES('" + username + "', '" + id + "', '" + idNumber + "', '" + name + "', '" + gender + "', '" + country + "', '" + number + "', '" + email + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                // new Dashboard(username); // Uncomment this line if you have a Dashboard class
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                e.printStackTrace(); // Print the stack trace for debugging
            }
        } else {
            setVisible(false);
            // new Dashboard(username); // Uncomment this line if you have a Dashboard class
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
