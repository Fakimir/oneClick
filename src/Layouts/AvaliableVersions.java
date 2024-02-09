package Layouts;

import javax.swing.*;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import Services.Files.FilesList;
import Start.App;
import Services.Run.RunCommand;
import Services.Run.SFTPUploader;
import Services.Run.SSHCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AvaliableVersions extends JPanel {
    private List<Map<String, String>> versions = FilesList.list();
    private JPasswordField password = new JPasswordField();
    private JLabel passwordLabel = new JLabel("Пароль user os:");
    private JTextArea title = new JTextArea();
    
    private JTextField host = new JTextField();
    private JLabel hostLabel = new JLabel("IP сервера");
    
    private JTextField hostName = new JTextField();
    private JLabel hostNameLabel = new JLabel("Имя пользователя сервера");
    
    public AvaliableVersions() {
        setSize(800, 900);
        setLayout(null);

        int labelDefaultY = 280;
        int buttonDefaultY = 305;
        int step = 0;
        

        for (final Map<String, String> version : versions) {
            JLabel label = new JLabel(version.get("name"));
            JButton button = new JButton("Add to server");

            button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				   try {
//					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), "cd /root && sudo mkdir server");
//					SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), "sudo scp " + version.get("path") + " " + hostName.getText() + "@" + host.getText() + ":/root/server");
					String localFilePath = version.get("path");
					System.out.println(localFilePath);
				    String remoteServerDirectory = "/root/server"; 
				    String remoteServerPath = "/root/server/" + version.get("name");
				    String combinedCommand = "sudo mkdir " + remoteServerDirectory;
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), combinedCommand);
				    
				    SFTPUploader.uploadFile(host.getText(), hostName.getText(), password.getText(), localFilePath, remoteServerPath);

//                    String removeLockCommand = "sudo kill -9 22510";
//                    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), removeLockCommand);
//                    
//                    String killApt = "sudo fuser -vkiy /var/lib/dpkg/lock";
//                    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), killApt);
				    String reloadServerCommand = "sudo service minecraft-server restart";
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), reloadServerCommand);
				    
				    String runJDKCommand = "sudo apt install -y openjdk-8-jdk";
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), runJDKCommand);
				    
				    String runCoreCommand = "java -jar \"$(readlink -f /root/server/" + version.get("name") + ")\"";
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), runCoreCommand);

                    String name = version.get("name");
                    String version = name.split("-")[1].replace("_", ".");
                    String finalName = "minecraft_server." + version;
                    
				    
				    String runServerCommand = "java -jar \"$(readlink -f /root/server/" + finalName + ")\"";
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), runServerCommand);
				    
				    String editEULACommand = "sudo sed -i 's/eula=false/eula=true/' /root/eula.txt";
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), editEULACommand);
				    
				    String editOnlineCommand = "sudo sed -i 's/online-mode=true/online-mode=false/' /root/server.properties";
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), editOnlineCommand);
				    
				    SSHCommand.executeSSHCommand(host.getText(), hostName.getText(), password.getText(), runServerCommand);
				    
					System.out.println("Succes");
				} catch (JSchException | SftpException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});

            label.setBounds(250, labelDefaultY + step, 300, 30);
            button.setBounds(250, buttonDefaultY + step, 300, 30);
            
            add(label);
            add(button);

            step += 50;
        }

        title.setBounds(250, 50, 300, 30);
        title.append("Скачать ядро на сервер");
        title.setEditable(false);
        
        passwordLabel.setBounds(250, 100, 300, 30);
        password.setBounds(250, 125, 300, 30);
        
        hostLabel.setBounds(250, 155, 300, 30);
        host.setBounds(250, 180, 300, 30);
        
        hostNameLabel.setBounds(250, 205, 300, 30);
        hostName.setBounds(250, 230, 300, 30);


        add(title);
        add(passwordLabel);
        add(password);
        
        add(host);
        add(hostLabel);
        
        add(hostName);
        add(hostNameLabel);
    }
}
