package ui;

import javax.swing.*;
import java.awt.*;

import model.*;
import service.*;
import controller.ServiceController;

public class MainUI {

    private static ServiceRequest request;
    private static ServiceController controller = new ServiceController();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Vehicle Service Management");
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField input = new JTextField(20);
        JLabel output = new JLabel("Enter Service Type");

        JButton bookBtn = new JButton("Book");
        JButton assignBtn = new JButton("Assign");
        JButton completeBtn = new JButton("Complete");

        // Book
        bookBtn.addActionListener(e -> {
            ServiceBuilder builder = new ServiceBuilder();
            request = builder
                    .setType(input.getText())
                    .setStatus("Requested")
                    .build();

            ServicePrototype prototype = new ServicePrototype(request.getServiceType());
            ServicePrototype clone = prototype.clone();

            DBConnection db1 = DBConnection.getInstance();
            DBConnection db2 = DBConnection.getInstance();

            output.setText("Booked: " + request.getServiceType());
            System.out.println("Cloned: " + clone.getServiceType());
            System.out.println("Singleton: " + (db1 == db2));
        });

        // Assign
        assignBtn.addActionListener(e -> {
            if (request != null) {
                controller.updateStatus(request, "Assigned");
                output.setText("Assigned");
            }
        });

        // Complete
        completeBtn.addActionListener(e -> {
            if (request != null) {
                controller.updateStatus(request, "Completed");
                output.setText("Completed");
            }
        });

        frame.add(input);
        frame.add(bookBtn);
        frame.add(assignBtn);
        frame.add(completeBtn);
        frame.add(output);

        frame.setVisible(true);
    }
}