import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Login{

    public static void main(String[] args){

        Log obj = new Log();
        Registration obj2 = new Registration();
        Retrieve obj3 = new Retrieve();

    }
}
class Log extends JFrame{

    JLabel icon, admin_login, username, password, forgot_pass, new_user_su;
    JTextField txtUsername, txtPassword;
    JButton btnLogin, btnExit;

    public Log(){

        JFrame frame = new JFrame();
        frame.setTitle("Richfield Login");

        Container c = frame.getContentPane();

        icon = new JLabel();
        icon.setIcon(new  ImageIcon("C:/Users/Jesh/Pictures/richfield_logo.jpg"));
        icon.setBounds(20, 30, 600, 200);

        c.add(icon);

        admin_login = new JLabel("Administrator Login");
        admin_login.setBounds(180, 220, 250, 20);

        username = new JLabel("Username:");
        username.setBounds(100, 260, 100, 20);

        txtUsername = new JTextField(30);
        txtUsername.setBounds(200, 260, 180, 20);

        password = new JLabel("Password:");
        password.setBounds(100, 290, 100, 20);

        txtPassword = new JTextField(30);
        txtPassword.setBounds(200, 290, 180, 20);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 320, 80, 20);

        btnLogin.addActionListener(e -> {

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            try {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");

                PreparedStatement ps = myConn.prepareStatement("SELECT name FROM registration WHERE  username =? AND pword=?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(frame, "Welcome " + rs.getString(1));
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect login details!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception exc){
                exc.printStackTrace();
            }

        });

        btnExit = new JButton("Exit");
        btnExit.setBounds(300, 320, 80, 20);

        btnExit.addActionListener(e -> {
            frame.dispose();
        });

        forgot_pass = new JLabel("Forgotten password");
        forgot_pass.setBounds(160, 360, 120, 20);

        forgot_pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new ForgPass();
            }
        });

        new_user_su = new JLabel("New user Signup");
        new_user_su.setBounds(320, 360, 100, 20);

        new_user_su.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Registration();
            }
        });

        frame.add(admin_login);
        frame.add(username);
        frame.add(password);
        frame.add(forgot_pass);
        frame.add(new_user_su);

        frame.add(txtUsername);
        frame.add(txtPassword);

        frame.add(btnLogin);
        frame.add(btnExit);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 200, 490, 450);
    }
}