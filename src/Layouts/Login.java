package Layouts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Start.App;

public class Login extends JPanel{

    private JTextField login = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton signIn = new JButton("Login");
    private JButton reg = new JButton("Register");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");

    /**
     * 
     */
    public Login() {
        setSize(800, 600);
        setLayout(null);

        loginLabel.setBounds(150, 100, 100, 30);  
        login.setBounds(250, 100, 300, 30);       

        passwordLabel.setBounds(150, 150, 100, 30); 
        password.setBounds(250, 150, 300, 30);      

        signIn.setBounds(250, 200, 150, 30);
        reg.setBounds(400, 200, 150, 30);

        add(loginLabel);
        add(login);
        add(passwordLabel);
        add(password);
        add(signIn);
        add(reg);

        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet res = App.statement.executeQuery("SELECT id FROM user WHERE email='" + login.getText() + "' AND password='" + password.getText() + "'");
                    if (res.next()) {
                        App.Layout.show(App.mainPanel, "Main");
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.Layout.show(App.mainPanel, "Registration");
            }
        });
    }
}
