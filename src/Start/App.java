package Start;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Layouts.*;


public class App extends JFrame {

    public static Statement statement;
    public static CardLayout Layout = new CardLayout();
    public static JPanel mainPanel = new JPanel();


    private App() {
        super("One Click");
        setSize(800, 900);

        mainPanel.setLayout(Layout);
        mainPanel.add(new Login(), "Login");
        mainPanel.add(new Registration(), "Registration");
        mainPanel.add(new Download(), "Download");
        mainPanel.add(new Main(), "Main");
        mainPanel.add(new AvaliableVersions(), "AvaliableVersions");
        mainPanel.add(new EditConfigurations(), "Settings");

        add(mainPanel);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Layout.show(mainPanel, "Login");

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/oneClick", "egor", "oCPyT8mX");
            statement = connection.createStatement();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

    	// Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/oneClick", "egor", "oCPyT8mX");
    	
        // Statement statement = connection.createStatement();

        // ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

        // System.out.println(resultSet);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}