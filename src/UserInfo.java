import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserInfo extends Container {
    private JLabel IdLabel, nameLabel, surnameLabel, ageLabel, loginLabel, moneyLabel;
    private JButton backButton, addMoneyButton;
    private JTextField moneyText;

    public static String login;
    public static String password;
    public static User user;

    public UserInfo(User u) {
        user = DBManager.getUser(login,password);

        setSize(700, 700);
        setLayout(null);

        Font labelFont = new Font("Arial", Font.BOLD, 24);

            IdLabel = new JLabel("Id: " + u.getId(), SwingConstants.CENTER);
            IdLabel.setBounds(250, 0, 200, 50);
            IdLabel.setFont(labelFont);
            IdLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            add(IdLabel);


// Создать метки с новым шрифтом
            nameLabel = new JLabel("Name: " + u.getName(), SwingConstants.CENTER);
            nameLabel.setBounds(250, 50, 200, 50);
            nameLabel.setFont(labelFont);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            add(nameLabel);

            surnameLabel = new JLabel("Surname: " + u.getSurname(), SwingConstants.CENTER);
            surnameLabel.setBounds(250, 120, 200, 50);
            surnameLabel.setFont(labelFont);
            surnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            add(surnameLabel);

            ageLabel = new JLabel("Age: " + u.getAge(), SwingConstants.CENTER);
            ageLabel.setBounds(250, 190, 200, 50);
            ageLabel.setFont(labelFont);
            ageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            add(ageLabel);

            loginLabel = new JLabel("Login: " + u.getLogin(), SwingConstants.CENTER);
            loginLabel.setBounds(250, 260, 200, 50);
            loginLabel.setFont(labelFont);
            loginLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            add(loginLabel);

            moneyLabel = new JLabel("Money: " + u.getMoney() + " $", SwingConstants.CENTER);
            moneyLabel.setBounds(250, 330, 200, 50);
            moneyLabel.setFont(labelFont);
            moneyLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            add(moneyLabel);
            // Update the labels with user information


            moneyText = new JTextField();
            moneyText.setBounds(250, 400, 200, 40);
            add(moneyText);


            addMoneyButton = new JButton("ADD MONEY");
            addMoneyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DBManager.addMoney(login,password, Double.parseDouble(moneyText.getText()));
                    user=DBManager.getUser(login,password);
                    IdLabel.setText("Id: " + user.getId());
                    nameLabel.setText("Name: " + user.getName());
                    surnameLabel.setText("Surname: " + user.getSurname());
                    ageLabel.setText("Age: " +user.getAge());
                    loginLabel.setText("Login: " + user.getLogin());
                    moneyLabel.setText("Money: " + user.getMoney() + " $");
                    moneyText.setText("");
                }
            });
            addMoneyButton.setBounds(250, 470, 200, 40);
            addMoneyButton.setBackground(new Color(51, 153, 255));
            addMoneyButton.setForeground(Color.WHITE);
            addMoneyButton.setFont(new Font("Arial", Font.PLAIN, 18));
            add(addMoneyButton);

       }
}

