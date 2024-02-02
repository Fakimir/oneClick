package Layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Start.App;


public class Download extends JPanel {
    private JLabel coreLabel = new JLabel("1.18");
    private JButton download = new JButton("Download");
    private JTextArea textArea = new JTextArea();

    public Download() {
        setSize(800, 600);
        setLayout(null);

        coreLabel.setBounds(250, 100, 50, 30);
        download.setBounds(320, 100, 230, 30);
        textArea.setBounds(250, 50, 300, 30);
        textArea.setEditable(false);
        textArea.append("Выберете нужную версию");
        
        add(textArea);
        add(coreLabel);
        add(download);
        
        download.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.mainPanel.add(new DownloadVersion("1.18", "https://maven.minecraftforge.net/net/minecraftforge/forge/1.18-38.0.17/forge-1.18-38.0.17-installer.jar"), "DownloadVersion");
                App.Layout.show(App.mainPanel, "DownloadVersion");
            }
        });
    }
}
