package Layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Start.App;

public class Registration extends JPanel{

    private JTextField login = new JTextField();
    private JTextField ip = new JTextField();
    private JTextField hostName = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton signUp = new JButton("Register");
    private JButton signIn = new JButton("Login");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel ipLabel = new JLabel("Server ip:");
    private JLabel hostNameLabel = new JLabel("host name:");

    /**
     * 
     */
    public Registration() {
        setSize(800, 600);
        setLayout(null);

        loginLabel.setBounds(150, 100, 100, 30);  
        login.setBounds(250, 100, 300, 30);

        passwordLabel.setBounds(150, 150, 100, 30); 
        password.setBounds(250, 150, 300, 30);      

        signIn.setBounds(250, 200, 150, 30);
        signUp.setBounds(400, 200, 150, 30);

        ipLabel.setBounds(150, 250, 100, 30);
        ip.setBounds(250, 250, 300, 30);

        hostNameLabel.setBounds(150, 250, 100, 30);
        hostName.setBounds(250, 250, 300, 30);

        add(loginLabel);
        add(login);
        add(passwordLabel);
        add(password);
        add(signIn);
        add(signUp);
        add(ipLabel);
        add(ip);
        add(hostNameLabel);
        add(hostName);

         signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 try {
                     ResultSet res = App.statement.executeQuery("SELECT id FROM user WHERE email='" + login.getText() + "'");
                     if (!res.next()) {
                         App.statement.executeUpdate("INSERT INTO user (email, password) VALUES (\'" + login.getText() + "\', \'" + password.getText() + "\')");
                     } else {
                         JOptionPane.showMessageDialog(null, "This login is already exists");
                     }
                 } catch (SQLException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                 }
            }
        });

        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.Layout.show(App.mainPanel, "Login");
            }
        });
    }
}


