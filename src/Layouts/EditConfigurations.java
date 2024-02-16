package Layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import Services.Run.SSHCommand;
import Start.App;

public class EditConfigurations extends JPanel {
    JLabel title = new JLabel("Изменить настройки");
    JTextField maxPlayers = new JTextField();
    JLabel maxPlayersLabel = new JLabel("Колличество игроков");

    JTextField permission = new JTextField();
    JLabel permisionLabel = new JLabel("Права");

    JTextField pvp = new JTextField();
    JLabel pvpLabel = new JLabel("Пвп");

    JTextField allowFlights = new JTextField();
    JLabel allowFlightsLabel = new JLabel("Полеты");

    JTextField difficulty = new JTextField();
    JLabel difficultyLabel = new JLabel("Сложность");

    JTextField enableStatus = new JTextField();
    JLabel enableStatusLabel = new JLabel("Статус активности");

    JTextField gameMode = new JTextField();
    JLabel gameModeLabel = new JLabel("Режим игры");

    JTextField motd = new JTextField();
    JLabel modtLabel = new JLabel("Описание");
    
    private JLabel passwordLabel = new JLabel("Пароль user os:");
    private JPasswordField password = new JPasswordField();
    
    private JTextField host = new JTextField();
    private JLabel hostLabel = new JLabel("IP сервера");
    
    private JTextField hostName = new JTextField();
    private JLabel hostNameLabel = new JLabel("Имя пользователя сервера");
    
    JButton submit = new JButton("Submit");

    public EditConfigurations() {
    	setSize(800, 1200);
    	setLayout(null);
    	
        title.setBounds(230, 50, 300, 30);

        maxPlayers.setBounds(230, 90, 150, 30);
        maxPlayersLabel.setBounds(390, 90, 200, 30);

        permission.setBounds(230, 130, 150, 30);
        permisionLabel.setBounds(390, 130, 140, 30);

        pvp.setBounds(230, 170, 150, 30);
        pvpLabel.setBounds(390, 170, 140, 30);

        allowFlights.setBounds(230, 210, 150, 30);
        allowFlightsLabel.setBounds(390, 210, 140, 30);

        difficulty.setBounds(230, 250, 150, 30);
        difficultyLabel.setBounds(390, 250, 140, 30);

        enableStatus.setBounds(230, 290, 150, 30);
        enableStatusLabel.setBounds(390, 290, 140, 30);

        gameMode.setBounds(230, 330, 150, 30);
        gameModeLabel.setBounds(390, 330, 140, 30);

        motd.setBounds(230, 370, 150, 30);
        modtLabel.setBounds(390, 370, 140, 30);
        
        submit.setBounds(230, 600, 150, 30);
        
        
        
        passwordLabel.setBounds(230, 420, 300, 30);
        password.setBounds(230, 445, 300, 30);
        
        hostLabel.setBounds(230, 475, 300, 30);
        host.setBounds(230, 505, 300, 30);
        
        hostNameLabel.setBounds(230, 535, 300, 30);
        hostName.setBounds(230, 560, 300, 30);
        
        add(title);
        add(maxPlayers);
        add(maxPlayersLabel);
        
        add(permission);
        add(permisionLabel);
        
        add(pvp);
        add(pvpLabel);
        
        add(allowFlights);
        add(allowFlightsLabel);
        
        add(difficulty);
        add(difficultyLabel);
        
        add(enableStatus);
        add(enableStatusLabel);
        
        add(gameMode);
        add(gameModeLabel);
        
        add(motd);
        add(modtLabel);
        
        add(submit);
        
        add(passwordLabel);
        add(password);
        
        add(hostLabel);
        add(host);
        
        add(hostNameLabel);
        add(hostName);
        
        
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
			    String command1 = "sudo awk -i inplace '{gsub(/max-players=.*/, \"max-players=" + maxPlayers.getText() + "\");} 1' /root/server.properties";
			    String command2 = "sudo awk -i inplace '{gsub(/function-permission-level=.*/, \"function-permission-level=" + permission.getText() + "\");} 1' /root/server.properties";
			    String command3 = "sudo awk -i inplace '{gsub(/pvp=.*/, \"pvp=" + pvp.getText() + "\");} 1' /root/server.properties";
			    String command4 = "sudo awk -i inplace '{gsub(/allow-flight=.*/, \"allow-flight=" + allowFlights.getText() + "\");} 1' /root/server.properties";
			    String command5 = "sudo awk -i inplace '{gsub(/difficulty=.*/, \"difficulty=" + difficulty.getText() + "\");} 1' /root/server.properties";
			    String command6 = "sudo awk -i inplace '{gsub(/enable-status=.*/, \"enable-status=" + enableStatus.getText() + "\");} 1' /root/server.properties";
			    String command7 = "sudo awk -i inplace '{gsub(/gamemode=.*/, \"gamemode=" + gameMode.getText() + "\");} 1' /root/server.properties";
			    String command8 = "sudo awk -i inplace '{gsub(/motd=.*/, \"motd=" + motd.getText() + "\");} 1' /root/server.properties";
			    try {
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command1);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command2);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command3);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command4);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command5);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command6);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command7);
					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), command8);
				} catch (JSchException | SftpException | InterruptedException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
}
