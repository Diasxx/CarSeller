import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
public class Login extends Container {
    private JLabel loginLabel, passwordLabel;
    private JTextField loginText, passwordText;
    private JButton buttonLIST;
    private JButton buttonBack;

    Date date = new Date();
    public Login()
    {
        setSize(700, 700);
        setLayout(null);


        // Создаем метку "Login"
        loginLabel = new JLabel("Login:");
        loginLabel.setBounds(getWidth()/3-80, getHeight()/4-50, getWidth()/3, getHeight()/10);
        loginLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(loginLabel);

        // Создаем поле ввода для логина
        loginText = new JTextField();
        loginText.setBounds(getWidth()/3, getHeight()/4-50, getWidth()/3, getHeight()/10);
        loginText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(loginText);

        // Создаем метку "Password"
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(getWidth()/3-80, getHeight()/3, getWidth()/3, getHeight()/10);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(passwordLabel);

        // Создаем поле ввода для пароля
        passwordText = new JPasswordField();
        passwordText.setBounds(getWidth()/3, getHeight()/3, getWidth()/3, getHeight()/10);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(passwordText);

        // Создаем кнопку "ENTER"
        buttonLIST = new JButton("ENTER");
        buttonLIST.setBounds(getWidth()/3-100, getHeight()/2, getWidth()/4, getHeight()/15);
        buttonLIST.setBackground(new Color(51, 153, 255));
        buttonLIST.setForeground(Color.WHITE);
        buttonLIST.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonLIST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBManager.getUser(loginText.getText(), passwordText.getText()) != null) {
                    UserInfo.login = loginText.getText();
                    UserInfo.password = passwordText.getText();

                    Main.frame.loginWindow.setVisible(false);
                    Main.frame.menuWindow2.setVisible(true);

                    UserInfo.user=(DBManager.getUser(loginText.getText(), passwordText.getText()));

                    try
                    {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
                        writer.write(String.valueOf("Loged user "+UserInfo.user.getName()+" "+UserInfo.user.getSurname()+" at "+date+"\n"));
                        writer.close();

                    }
                    catch (Exception x)
                    {
                        x.printStackTrace();
                    }

                    loginText.setText("");
                    passwordText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Authentication failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    loginText.setText("");
                    passwordText.setText("");
                }
            }
        });
        add(buttonLIST);



        // Создаем кнопку "BACK"
        buttonBack= new JButton("BACK");
        buttonBack.setBounds(getWidth()/3+100, getHeight()/2, getWidth()/4, getHeight()/15);
        buttonBack.setBackground(new Color(51, 153, 255));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.loginWindow.setVisible(false);
                Main.frame.menuWindow1.setVisible(true);
            }
        });
        add(buttonBack);
    }


    public static void checkUser( String log, String pass){
        System.out.println(log + " " + pass);
    }

    public static void checkUser(User user){
        System.out.println(user.toString());
    }

}