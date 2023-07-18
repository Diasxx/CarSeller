import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;;
import java.sql.SQLException;
import java.util.Date;

public class AddUser extends Container {

    private JLabel nameLabel, surnameLabel, ageLabel, loginLabel, passwordLabel, moneyLabel;
    private JTextField IdText,nameText, surnameText, ageText, loginText, passwordText, moneyText;
    private JButton addButton, backButton;

    Date date = new Date();

    public AddUser() {

        setSize(700, 700);
        setLayout(null);


        // Create name label and text field
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(getWidth() / 4, 150, 80, 30);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(getWidth() / 2, 150, 150, 30);
        add(nameText);

        // Create surname label and text field
        surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(getWidth() / 4, 200, 80, 30);
        add(surnameLabel);

        surnameText = new JTextField();
        surnameText.setBounds(getWidth() / 2, 200, 150, 30);
        add(surnameText);

        // Create age label and text field
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(getWidth() / 4, 250, 80, 30);
        add(ageLabel);

        ageText = new JTextField();
        ageText.setBounds(getWidth() / 2, 250, 150, 30);
        add(ageText);

        // Create login label and text field
        loginLabel = new JLabel("Login:");
        loginLabel.setBounds(getWidth() / 4, 300, 80, 30);
        add(loginLabel);

        loginText = new JTextField();
        loginText.setBounds(getWidth() / 2, 300, 150, 30);
        add(loginText);

        // Create password label and text field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(getWidth() / 4, 350, 80, 30);
        add(passwordLabel);

        passwordText = new JTextField();
        passwordText.setBounds(getWidth() / 2, 350, 150, 30);
        add(passwordText);

        // Create money label and text field
        moneyLabel = new JLabel("Money $:");
        moneyLabel.setBounds(getWidth() / 4, 400, 80, 30);
        add(moneyLabel);

        moneyText = new JTextField();
        moneyText.setBounds(getWidth() / 2, 400, 150, 30);
        add(moneyText);

        // Create add button
        addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String name = nameText.getText();
                String surname = surnameText.getText();
                String age = ageText.getText();
                String login = loginText.getText();
                String password = passwordText.getText();
                double money = Double.parseDouble(moneyText.getText());
                User newUser = new User( name, surname, age, login, password, money);
                UserInfo.user = (newUser);

                try {
                    DBManager.addUser1(newUser);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
                    writer.write(String.valueOf("Created user "+nameText.getText()+" "+surnameText.getText()+" at "+date+"\n"));
                    writer.close();

                }
                catch (Exception x)
                {
                    x.printStackTrace();
                }

                UserInfo.login=newUser.getLogin();
                UserInfo.password=newUser.getPassword();


                nameText.setText("");
                surnameText.setText("");
                ageText.setText("");
                loginText.setText("");
                passwordText.setText("");
                moneyText.setText("");

                Main.frame.addWindow.setVisible(false);
                Main.frame.menuWindow2.setVisible(true);
            }
        });
        addButton.setBounds(getWidth() / 4, 500, 120, 30);
        addButton.setBackground(new Color(51, 153, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.PLAIN, 18));
        add(addButton);

        // Create back button
        backButton = new JButton("BACK");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addWindow.setVisible(false);
                Main.frame.menuWindow1.setVisible(true);
            }
        });
        backButton.setBounds(getWidth() / 2, 500, 120, 30);
        backButton.setBackground(new Color(51, 153, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        add(backButton);
    }
}