package com.idcardgenerator.gui;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class IDCardGeneratorGUI extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField bloodGroupField;
    private JTextField registerNumberField;
    private JTextField departmentField;
    private JButton generateButton;
    private JButton saveButton;
    private JLabel idCardLabel;

    public IDCardGeneratorGUI() {
        setTitle("ID Card Generator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Blood Group:"));
        bloodGroupField = new JTextField();
        add(bloodGroupField);

        add(new JLabel("Register Number:"));
        registerNumberField = new JTextField();
        add(registerNumberField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);

        generateButton = new JButton("Generate ID Card");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateIDCard();
            }
        });
        add(generateButton);

        saveButton = new JButton("Save ID Card as Image");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveIDCardAsImage();
            }
        });
        add(saveButton);

        idCardLabel = new JLabel();
        add(idCardLabel);
    }

    private void generateIDCard() {
        String name = nameField.getText();
        String age = ageField.getText();
        String bloodGroup = bloodGroupField.getText();
        String registerNumber = registerNumberField.getText();
        String department = departmentField.getText();

        String idCardText = "<html>Name: " + name + "<br>Age: " + age + "<br>Blood Group: " + bloodGroup
                + "<br>Register Number: " + registerNumber + "<br>Department: " + department + "</html>";
        idCardLabel.setText(idCardText);
    }

    private void saveIDCardAsImage() {
        BufferedImage image = new BufferedImage(idCardLabel.getWidth(), idCardLabel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        idCardLabel.paint(g2d);
        g2d.dispose();

        try {
            File outputFile = new File("IDCard.png");
            ImageIO.write(image, "png", outputFile);
            JOptionPane.showMessageDialog(this, "ID Card saved as IDCard.png");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving ID Card image");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IDCardGeneratorGUI().setVisible(true);
            }
        });
    }
}
