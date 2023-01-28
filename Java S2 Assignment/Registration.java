import javax.swing.*;
import java.awt.*;

import java.sql.*;

public class Registration{

}

class Register extends JFrame{

    JLabel icon, title, message, name, surname, DOB, gender, address, username, password, conf_pass, sec_question, sec_answer;
    JTextField txtName, txtSurname, txtDOB, txtUsername, txtPassword, txtConf_Pass, txtSec_Answer;
    JTextArea txtFAddress;
    JRadioButton male, female;
    JComboBox JCSec_Question;
    JButton btnSubmit, btnClear, btnExit;

    public Register(){

        JFrame frame = new JFrame();
        frame.setTitle("Richfield Sign-Up Form");

        Container c = frame.getContentPane();

        icon = new JLabel();
        icon.setIcon(new  ImageIcon("C:/Users/Jesh/Pictures/richfield_logo.jpg"));
        icon.setBounds(20, 30, 450, 100);

        c.add(icon);

        title = new JLabel("New Registration");
        title.setBounds(190, 150, 150, 20);

        message = new JLabel("Please fill in all fields using your own details.");
        message.setBounds(100, 170, 500, 20);

        name = new JLabel("Name:");
        name.setBounds(120, 210, 100, 20);

        txtName = new JTextField(30);
        txtName.setBounds(200, 210, 180, 20);

        surname = new JLabel("Surname:");
        surname.setBounds(100, 240, 100, 20);

        txtSurname = new JTextField(30);
        txtSurname.setBounds(200, 240, 180, 20);

        DOB = new JLabel("Date of Birth:");
        DOB.setBounds(80, 270, 180, 20);

        txtDOB = new JTextField(30);
        txtDOB.setBounds(200, 270, 180, 20);

        gender = new JLabel("Gender:");
        gender.setBounds(100, 300, 100, 20);

        male = new JRadioButton("Male");
        male.setBounds(200, 300, 100, 20);

        female = new JRadioButton("Female");
        female.setBounds(300, 300, 100, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        address = new JLabel("Address:");
        address.setBounds(100, 330, 100, 20);

        txtFAddress = new JTextArea(String.valueOf(100));
        txtFAddress.setBounds(200, 330, 100, 20);

        username = new JLabel("Username:");
        username.setBounds(100, 390, 100, 20);

        txtUsername = new JTextField(30);
        txtUsername.setBounds(200, 390, 180, 20);

        password = new JLabel("Password:");
        password.setBounds(100, 420, 100, 20);

        txtPassword = new JTextField(30);
        txtPassword.setBounds(200, 420, 180, 20);

        conf_pass = new JLabel("Confirm Password:");
        conf_pass.setBounds(50, 450, 150, 20);

        txtConf_Pass = new JTextField(30);
        txtConf_Pass.setBounds(200, 450, 180, 20);

        sec_question = new JLabel("Security Question:");
        sec_question.setBounds(50, 480, 150, 20);

        String s1[] = {"What's your mother's middle name?", "Which primary school did you attend?", "Which year did you finish high school?", "What is your favourite colour?"};
        JCSec_Question = new JComboBox(s1);
        JCSec_Question.setBounds(200, 480, 200, 20);

        sec_answer = new JLabel("Security Answer:");
        sec_answer.setBounds(50, 520, 150, 20);

        txtSec_Answer = new JTextField(30);
        txtSec_Answer.setBounds(200, 520, 180, 20);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(80, 560, 100, 20);

        btnSubmit.addActionListener(e ->{

            String txtname, txtsurname, txtdob, rdbgender, txtaddress, txtusername, txtpassword, txtconf_pass, txtsec_question, txtsec_ans;

            txtname = txtName.getText();
            txtsurname = txtSurname.getText();
            txtdob = txtDOB.getText();
            txtaddress = txtFAddress.getText();
            txtusername = txtUsername.getText();
            txtpassword = txtPassword.getText();
            txtconf_pass = txtConf_Pass.getText();
            txtsec_question = JCSec_Question.getSelectedItem().toString();
            txtsec_ans = txtSec_Answer.getText();

            if(male.isSelected()) {
                rdbgender = "Male";
            } else if(female.isSelected()){
                rdbgender = "Female";
            }

            if(txtname == null || txtsurname == null || txtdob == null || txtusername == null || txtpassword == null || txtconf_pass == null || txtsec_ans == null){
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(txtpassword != txtconf_pass){
                JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }

            try {
                //1.get connection,
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");

                // 2.create statement,
                Statement myStmt = myConn.createStatement();

                // 3.execute sql query,
                String sql = "INSERT INTO registration"
                        + "(name, surname, dob, address, username, pword, SQuestion, SAnswer)"
                        + " VALUES ('"+txtname+"', '"+txtsurname+"', '"+txtdob+"', '"+txtaddress+"', '"+txtusername+"', '"+txtpassword+"', '"+txtsec_question+"', '"+txtsec_ans+"')";
                myStmt.executeUpdate(sql);

            } catch (Exception exc){
                exc.printStackTrace();
            }
        });

        btnClear = new JButton("Clear");
        btnClear.setBounds(200, 560, 100, 20);

        btnClear.addActionListener(e -> {

            txtName.setText(null);
            txtSurname.setText(null);
            txtDOB.setText(null);

            male.setSelected(false);
            female.setSelected(false);

            txtFAddress.setText(null);
            txtUsername.setText(null);
            txtPassword.setText(null);
            txtConf_Pass.setText(null);
            txtSec_Answer.setText(null);
        });

        btnExit = new JButton("Exit");
        btnExit.setBounds(320, 560, 100, 20);

        btnExit.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(title);
        frame.add(message);

        frame.add(name);
        frame.add(txtName);

        frame.add(surname);
        frame.add(txtSurname);

        frame.add(DOB);
        frame.add(txtDOB);

        frame.add(gender);
        frame.add(male);
        frame.add(female);

        frame.add(address);
        frame.add(txtFAddress);

        frame.add(username);
        frame.add(txtUsername);

        frame.add(password);
        frame.add(txtPassword);

        frame.add(conf_pass);
        frame.add(txtConf_Pass);

        frame.add(sec_question);
        frame.add(JCSec_Question);

        frame.add(sec_answer);
        frame.add(txtSec_Answer);

        frame.add(btnSubmit);
        frame.add(btnClear);
        frame.add(btnExit);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 200, 490, 600);
    }
}