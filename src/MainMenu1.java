import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainMenu1 extends Container {
    private JButton addButton;
    private JButton listButton;
    private JButton exitButton;

    public MainMenu1(){
        // Устанавливаем размеры контейнера
        setSize(700, 700);
        // Устанавливаем менеджер компоновки
        setLayout(null);

        // Создаем кнопку "SIGN IN"
        addButton = new JButton("SIGN IN");
        // Вычисляем координаты и размер кнопки относительно размера контейнера
        addButton.setBounds(getWidth()/3, getHeight()/4-50, getWidth()/3, getHeight()/10);
        // Устанавливаем стиль кнопки
        addButton.setBackground(new Color(51, 153, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        // Добавляем обработчик событий для кнопки
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addWindow.setVisible(true);
                Main.frame.menuWindow1.setVisible(false);
            }
        });
        // Добавляем кнопку на контейнер
        add(addButton);

        // Создаем кнопку "LOGIN"
        listButton = new JButton("LOGIN");
        // Вычисляем координаты и размер кнопки относительно размера контейнера
        listButton.setBounds(getWidth()/3, getHeight()/3, getWidth()/3, getHeight()/10);
        // Устанавливаем стиль кнопки
        listButton.setBackground(new Color(51, 153, 255));
        listButton.setForeground(Color.WHITE);
        listButton.setFont(new Font("Arial", Font.PLAIN, 20));
        // Добавляем обработчик событий для кнопки
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.loginWindow.setVisible(true);
                Main.frame.menuWindow1.setVisible(false);
            }
        });
        // Добавляем кнопку на контейнер
        add(listButton);

        // Создаем кнопку "EXIT"
        exitButton = new JButton("EXIT");
        // Вычисляем координаты и размер кнопки относительно размера контейнера
        exitButton.setBounds(getWidth()/3, getHeight()/2, getWidth()/3, getHeight()/10);
        // Устанавливаем стиль кнопки
        exitButton.setBackground(new Color(51, 153, 255));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        // Добавляем обработчик событий для кнопки
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });
        // Добавляем кнопку на контейнер
        add(exitButton);
    }
}