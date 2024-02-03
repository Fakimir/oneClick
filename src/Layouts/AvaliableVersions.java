package Layouts;

import javax.swing.*;
import Services.Files.FilesList;
import Start.App;
import Services.Run.RunCommand;

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
    public AvaliableVersions() {

        int labelDefaultY = 150;
        int buttonDefaultY = 180;
        int step = 0;

        for (Map<String, String> version : versions) {
            JLabel label = new JLabel(version.get("name"));
            JButton button = new JButton("Add to server");

            button.addActionListener(e -> {
                try {
//                        RunCommand.run()
                    RunCommand.run("sudo scp " + version.get("path") + " root@", password.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });

            label.setBounds(250, labelDefaultY + step, 300, 30);
            button.setBounds(250, buttonDefaultY + step, 300, 30);

            step += 50;
        }

        title.setBounds(250, 100, 300, 30);
        title.append("Скачать ядро на сервер");
        title.setEditable(false);

        add(title);
        add(passwordLabel);
        add(password);
    }
}
