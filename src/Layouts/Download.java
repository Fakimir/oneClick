package Layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Start.App;


public class Download extends JPanel {
    private JLabel coreLabel_1_12_2 = new JLabel("1.12.2");
    private JButton download_1_12_2 = new JButton("Download");

    private JLabel coreLabel_1_16_4 = new JLabel("1.16.4");
    private JButton download_1_16_4 = new JButton("Download");

    private JLabel coreLabel_1_16_5 = new JLabel("1.16.5");
    private JButton download_1_16_5 = new JButton("Download");

    private JLabel coreLabel_1_17 = new JLabel("1.17");
    private JButton download_1_17 = new JButton("Download");

    private JTextArea textArea = new JTextArea();

    private JButton toMainPanel = new JButton("На главную");

    public Download() {
        setSize(800, 900);
        setLayout(null);

        toMainPanel.setBounds(50, 50, 160, 30);

        coreLabel_1_12_2.setBounds(250, 100, 50, 30);
        download_1_12_2.setBounds(320, 100, 230, 30);

        coreLabel_1_16_4.setBounds(250, 150, 50, 30);
        download_1_16_4.setBounds(320, 150, 230, 30);

        coreLabel_1_16_5.setBounds(250, 200, 50, 30);
        download_1_16_5.setBounds(320, 200, 230, 30);

        coreLabel_1_17.setBounds(250, 200, 50, 30);
        download_1_17.setBounds(320, 200, 230, 30);

        textArea.setBounds(250, 50, 300, 30);
        textArea.setEditable(false);
        textArea.append("Выберете нужную версию");
        
        add(textArea);
        add(coreLabel_1_12_2);
        add(download_1_12_2);

        add(coreLabel_1_16_4);
        add(download_1_16_4);

        add(coreLabel_1_16_5);
        add(download_1_16_5);

        add(toMainPanel);

        download_1_12_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.mainPanel.add(new DownloadVersion("1.12.2", "https://repo.spongepowered.org/repository/maven-releases/org/spongepowered/spongevanilla/1.12.2-7.4.7/spongevanilla-1.12.2-7.4.7.jar"), "DownloadVersion");
                App.Layout.show(App.mainPanel, "DownloadVersion");
            }
        });

        download_1_16_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.mainPanel.add(new DownloadVersion("1.16.4", ""), "DownloadVersion");
                App.Layout.show(App.mainPanel, "DownloadVersion");
            }
        });

        download_1_16_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.mainPanel.add(new DownloadVersion("1.16.5", ""), "DownloadVersion");
                App.Layout.show(App.mainPanel, "DownloadVersion");
            }
        });

        download_1_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.mainPanel.add(new DownloadVersion("1.17", ""), "DownloadVersion");
                App.Layout.show(App.mainPanel, "DownloadVersion");
            }
        });
    }
}
