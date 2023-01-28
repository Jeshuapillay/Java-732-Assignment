import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgPass{

}

class Retrieve extends JFrame {

    JLabel icon, message, username, sec_question, sec_answer;
    JTextField txtUsername, txtSec_Answer;
    JComboBox JCSec_Question;
    JButton btnGetPass, btnExit;

    public Retrieve() {

        JFrame frame = new JFrame();
        frame.setTitle("Richfield Forgotten Password");

        Container c = frame.getContentPane();

        icon = new JLabel();
        icon.setIcon(new ImageIcon("C:/Users/Jesh/Pictures/richfield_logo.jpg"));
        icon.setBounds(20, 30, 450, 100);

        c.add(icon);

        message = new JLabel("Retrieve Password");
        message.setBounds(180, 150, 150, 20);

        username = new JLabel("Username:");
        username.setBounds(80, 200, 100, 20);

        txtUsername = new JTextField(30);
        txtUsername.setBounds(180, 200, 220, 20);

        sec_question = new JLabel("Security Question:");
        sec_question.setBounds(30, 240, 180, 20);

        String s1[] = {"What's your mother's middle name?", "Which primary school did you attend?", "Which year did you finish high school?", "What is your favourite colour?"};
        JCSec_Question = new JComboBox(s1);
        JCSec_Question.setBounds(180, 240, 220, 20);

        sec_answer = new JLabel("Security Answer:");
        sec_answer.setBounds(50, 280, 150, 20);

        txtSec_Answer = new JTextField(30);
        txtSec_Answer.setBounds(180, 280, 220, 20);

        btnGetPass = new JButton("Get Password");
        btnGetPass.setBounds(180, 320, 140, 20);

        btnGetPass.addActionListener(e -> {

            String username = txtUsername.getText();
            String sec_ques = JCSec_Question.toString();
            String sec_ans = txtSec_Answer.getText();

            try {

                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");

                PreparedStatement ps = myConn.prepareStatement("SELECT name FROM registration WHERE username=? AND SQuestion=? AND SAnswer=?");
                ps.setString(1, username);
                ps.setString(2, sec_ans);
                ps.setString(3, sec_ans);

                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(frame, "Your password is: " + rs.getString(6));
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect details entered!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch(Exception exc){
                exc.printStackTrace();
            }
        });

        btnExit = new JButton("Exit");
        btnExit.setBounds(380, 220, 100, 20);

        btnExit.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(message);
        frame.add(username);
        frame.add(sec_question);
        frame.add(sec_answer);

        frame.add(txtUsername);
        frame.add(txtSec_Answer);

        frame.add(JCSec_Question);

        frame.add(btnGetPass);
        frame.add(btnExit);

        frame.setVisible(true);
        frame.setSize(490, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

    }
}