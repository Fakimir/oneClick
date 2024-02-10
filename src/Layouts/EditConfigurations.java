package Layouts;

import javax.swing.*;

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

    public EditConfigurations() {
        title.setBounds(230, 50, 300, 30);

        maxPlayers.setBounds(230, 90, 150, 30);
        maxPlayersLabel.setBounds(390, 90, 140, 30);

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
    }
}
