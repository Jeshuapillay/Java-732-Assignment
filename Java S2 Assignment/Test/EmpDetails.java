package Test;

import java.awt.LayoutManager;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

class EmpDetails extends JApplet{

    JTextField fullName, jobTitle;
    JLabel Full_Name, displayTitle, errMessage;
    JButton submit;

    public void init(){

        Full_Name = new JLabel("Full Name:");
        Full_Name.setBounds(10, 10, 100, 20);


        fullName = new JTextField(15);
        fullName.setBounds(100, 10, 100, 20);

        displayTitle = new JLabel("Job Title:");
        displayTitle.setBounds(10, 50, 100, 20);

        jobTitle = new JTextField(20);
        jobTitle.setBounds(100, 50, 100, 20);

        errMessage = new JLabel();
        errMessage.setBounds(10, 90, 300, 20);

        submit = new JButton("submit");
        submit.setBounds(10, 130, 100, 20);

        add(fullName);
        add(jobTitle);
        add(Full_Name);
        add(Full_Name);
        add(displayTitle);
        add(errMessage);
        add(submit);

        String[] FName = {"Jeshua Pillay", "Shaiyur Dooken", "Adin Rikisahedew"};
        String[] JTitle = {"Software Developer", " Game Developer", "Body Builder"};

        submit.addActionListener(e ->{

            String name = fullName.getText();
            
            if(name.equals(FName[0])){
                jobTitle.setText(JTitle[0]);
                errMessage.setText(null);

            } else if(name.equals(FName[1])){
                jobTitle.setText(JTitle[1]);
                errMessage.setText(null);

            } else if(name.equals(FName[2])){
                jobTitle.setText(JTitle[2]);
                errMessage.setText(null);

            } else {
                errMessage.setText("Incorrect Employee Name!");
                jobTitle.setText(null);
            }

        });

        this.setVisible(true);

    }
}