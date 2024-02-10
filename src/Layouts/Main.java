package Layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Start.App;

public class Main extends JPanel {
    private JLabel title = new JLabel("Выберете загружаемую версию\n ядра или посмотрите скачанные версии");
    private JButton downloads = new JButton("Downloads");
    private JButton avaliable = new JButton("Avaliable");

    public Main() {
        setSize(800, 600);
        setLayout(null);

        title.setBounds(240, 50, 320, 60);
        downloads.setBounds(250, 150, 300, 30);
        avaliable.setBounds(250, 200, 300, 30);

        add(title);
        add(downloads);
        add(avaliable);

        downloads.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.Layout.show(App.mainPanel, "Download");
            }
        });
        
        avaliable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.Layout.show(App.mainPanel, "AvaliableVersions");
            }
        });
    }
}