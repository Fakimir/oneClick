package Layouts;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Services.Http.DownloadCore;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class DownloadVersion extends JPanel {
    private JTextArea title = new JTextArea();
    private JButton download = new JButton("Download");
    private JPasswordField password = new JPasswordField();
    private JLabel passwordLabel = new JLabel("Пароль user os:");

    private JButton toMainPanel = new JButton("На главную");

    public DownloadVersion(String version, String url) {
        final String coreVersion = version;
        final String coreUrl = url;

        setSize(800, 600);
        setLayout(null);

        toMainPanel.setBounds(50, 50, 160, 30);

        download.setBounds(250, 150, 300, 30);
        title.setBounds(250, 100, 300, 30);

        passwordLabel.setBounds(250, 200, 300, 30); 
        password.setBounds(250, 250, 300, 30);

        title.append("Скачать ядро для версии " + version);
        title.setEditable(false);
        
        add(title);
        add(passwordLabel);
        add(password);
        add(download);
        add(toMainPanel);

        download.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					DownloadCore.download(password.getText(), coreVersion.replace('.', '_'), coreUrl);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
            }
        });
    }
}
