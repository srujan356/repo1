package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackages, deletePersonalDetails;
    JButton logout, calculator, about, payment, destinations, viewBookedHotels, bookHotels, viewHotels, viewPackages;
    String username;

    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fit to screen
        setLayout(null);

        // Top panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1400, 65);
        add(p1);

        JLabel heading = new JLabel("Dashboard");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 40));
        heading.setBounds(70, 5, 500, 50);
        p1.add(heading);

        // Side panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        // Add buttons to the side panel
        addPersonalDetails = createButton("Add Personal Details", 0);
        updatePersonalDetails = createButton("Update Personal Details", 50);
        viewPersonalDetails = createButton("View Personal Details", 100);
        deletePersonalDetails = createButton("Delete Personal Details", 150);
        checkPackages = createButton("Check Packages", 200);
        bookPackages = createButton("Book Packages", 250);
        viewPackages = createButton("View Booked Package", 300);
        viewHotels = createButton("View Hotels", 350);
        bookHotels = createButton("Booked Hotels", 400);
        viewBookedHotels = createButton("View Booked Hotels", 450);
        destinations = createButton("Destinations", 500);
        payment = createButton("Payments", 550);
        calculator = createButton("Calculator", 600);
        about = createButton("About", 650);

        p2.add(addPersonalDetails);
        p2.add(updatePersonalDetails);
        p2.add(viewPersonalDetails);
        p2.add(deletePersonalDetails);
        p2.add(checkPackages);
        p2.add(bookPackages);
        p2.add(viewPackages);
        p2.add(viewHotels);
        p2.add(bookHotels);
        p2.add(viewBookedHotels);
        p2.add(destinations);
        p2.add(payment);
        p2.add(calculator);
        p2.add(about);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel newLabel = new JLabel(i3);
        newLabel.setBounds(250, 50, 1150, 700);
        add(newLabel);

        // Welcome message
        JLabel showname = new JLabel("Welcome " + username);
        showname.setBounds(600, 15, 500, 35);
        showname.setForeground(Color.white);
        showname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 35));
        p1.add(showname);

        // Logout button
        logout = new JButton("Logout");
        logout.setForeground(Color.ORANGE);
        logout.setBackground(new Color(0, 0, 102));
        logout.setBounds(1000, 15, 200, 45);
        logout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
        logout.addActionListener(this);
        p1.add(logout);

        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setForeground(new Color(162, 48, 124));
        l1.setFont(new Font("Tahoma", Font.PLAIN, 45));
        l1.setBounds(150, 50, 1000, 55);
        newLabel.add(l1);

        setVisible(true);
    }

    // Create a button method to avoid redundancy
    private JButton createButton(String text, int yPosition) {
        JButton button = new JButton(text);
        button.setBounds(0, yPosition, 300, 50);
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setMargin(new Insets(0, 0, 0, 70));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new Login(""); // Ensure the class name is correct
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username).setVisible(true);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username).setVisible(true);
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage().setVisible(true);
        } else if (ae.getSource() == bookPackages) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackages) {
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotels) {
            new CheckHotels();
        } else if (ae.getSource() == destinations) {
            new Destination();
        } else if (ae.getSource() == bookHotels) {
            new BookHotels(username);
        } else if (ae.getSource() == viewBookedHotels) {
            new ViewBookHotels(username);
        } else if (ae.getSource() == payment) {
            new Payment(); // Ensure the class has no parameters
            openExternalApplications(); // Open calculator and notepad
        } else if (ae.getSource() == about) {
            new About();
        } else if (ae.getSource() == deletePersonalDetails) {
            new DeleteCustomerDetails(username);
        }
    }

    // Method to open external applications
    private void openExternalApplications() {
        try {
            Runtime.getRuntime().exec("calc.exe"); // Open Calculator
            Runtime.getRuntime().exec("notepad.exe"); // Open Notepad
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
