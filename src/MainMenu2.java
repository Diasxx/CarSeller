import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu2 extends Container {
    private JButton userInfobutton;
    private JButton sellCarButton;
    private JButton buyCarButton;
    private JButton exitButton;

    public MainMenu2(){
        setSize(700, 700);
        setLayout(null);

        userInfobutton = new JButton("USER INFO");
        userInfobutton.setBounds(200, 80, 300, 50);
        userInfobutton.setFont(new Font("Arial", Font.PLAIN, 20));
        userInfobutton.setBackground(new Color(51, 153, 255));
        userInfobutton.setForeground(Color.WHITE);
        userInfobutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.frame.menuWindow2.setVisible(false);

                    UserInfo userInfo = new UserInfo(UserInfo.user);
                    // Создание отдельного JFrame
                    JFrame frame = new JFrame("User Info");
                    frame.setSize(700, 700);
                    frame.setLocation(450,90);
                    frame.setResizable(false);

                    // Добавление экземпляра UserInfo в JFrame
                    frame.getContentPane().add(userInfo);

                    // Отображение JFrame
                    frame.setVisible(true);

                Main.frame.menuWindow2.setVisible(true);

            }
        });
        add(userInfobutton);

        sellCarButton = new JButton("SELL CAR");
        sellCarButton.setBounds(200, 170, 300, 50);
        sellCarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        sellCarButton.setBackground(new Color(51, 153, 255));
        sellCarButton.setForeground(Color.WHITE);
        sellCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow2.setVisible(false);
                Main.frame.CellCarWindow.setVisible(true);
            }
        });
        add(sellCarButton);

        buyCarButton = new JButton("BUY CAR");
        buyCarButton.setBounds(200, 260, 300, 50);
        buyCarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        buyCarButton.setBackground(new Color(51, 153, 255));
        buyCarButton.setForeground(Color.WHITE);
        buyCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.BuyCarWindow.setVisible(true);
                Main.frame.menuWindow2.setVisible(false);
            }
        });
        add(buyCarButton);

        exitButton = new JButton("BACK");
        exitButton.setBounds(200, 350, 300, 50);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setBackground(new Color(51, 153, 255));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow2.setVisible(false);
                Main.frame.menuWindow1.setVisible(true);
            }
        });
        add(exitButton);
    }
}