import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Date;

public class CellCar extends Container {

    private JLabel modelLabel, yearLabel, mileageLabel, priceLabel, volumeLabel, transmissionLabel, driveLabel, helmLabel, colorLabel;
    private JTextField modelText, yearText, mileageText, priceText, volumeText, transmissionText, driveText, helmText, colorText;
    private JButton sendButton, backButton;

    Date date = new Date();
    public CellCar() {
        setSize(700, 700);
        setLayout(null);


        // Метка и текстовое поле для модели машины
        modelLabel = new JLabel("Model:");
        modelLabel.setBounds(200, 50, 100, 30);
        add(modelLabel);
        modelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        modelText = new JTextField();
        modelText.setBounds(300, 50, 200, 30);
        add(modelText);

        // Метка и текстовое поле для года выпуска машины
        yearLabel = new JLabel("Year:");
        yearLabel.setBounds(200, 100, 100, 30);
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(yearLabel);
        yearText = new JTextField();
        yearText.setBounds(300, 100, 200, 30);
        add(yearText);

        // Метка и текстовое поле для пробега машины
        mileageLabel = new JLabel("Mileage:");
        mileageLabel.setBounds(200, 150, 100, 30);
        mileageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(mileageLabel);
        mileageText = new JTextField();
        mileageText.setBounds(300, 150, 200, 30);
        add(mileageText);

        // Метка и текстовое поле для цены машины
        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(200, 200, 100, 30);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(priceLabel);
        priceText = new JTextField();
        priceText.setBounds(300, 200, 200, 30);
        add(priceText);

        // Add new labels and text fields for volume, transmission, drive, helm, and color
        volumeLabel = new JLabel("Volume:");
        volumeLabel.setBounds(200, 250, 100, 30);
        volumeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(volumeLabel);
        volumeText = new JTextField();
        volumeText.setBounds(300, 250, 200, 30);
        add(volumeText);

        transmissionLabel = new JLabel("Transmission:");
        transmissionLabel.setBounds(200, 300, 100, 30);
        transmissionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(transmissionLabel);
        transmissionText = new JTextField();
        transmissionText.setBounds(300, 300, 200, 30);
        add(transmissionText);

        driveLabel = new JLabel("Drive:");
        driveLabel.setBounds(200, 350, 100, 30);
        driveLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(driveLabel);
        driveText = new JTextField();
        driveText.setBounds(300, 350, 200, 30);
        add(driveText);

        helmLabel = new JLabel("Helm:");
        helmLabel.setBounds(200, 400, 100, 30);
        helmLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(helmLabel);
        helmText = new JTextField();
        helmText.setBounds(300, 400, 200, 30);
        add(helmText);


        colorLabel = new JLabel("Color:");
        colorLabel.setBounds(200, 450, 100, 30);
        colorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(colorLabel);
        colorText = new JTextField();
        colorText.setBounds(300, 450, 200, 30);
        add(colorText);



        sendButton = new JButton("SEND");
        sendButton.setBounds(200, 500, 100, 30);
        sendButton.setBackground(new Color(51, 153, 255));
        sendButton.setForeground(Color.WHITE);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = modelText.getText();
                String year = yearText.getText();
                String mileage = mileageText.getText();
                double price = Double.parseDouble(priceText.getText());
                // Get new fields from text fields
                String volume = volumeText.getText();
                String transmission = transmissionText.getText();
                String drive = driveText.getText();
                String helm = helmText.getText();
                String color = colorText.getText();

                // Создание объекта Car с новыми полями
                Car car = new Car(model, year, mileage, price, volume, transmission, drive, helm, color);

                // Добавление объекта Car
                try {
                    DBManager.addCar(car);
                } catch (SQLException ex) {
                }


                try
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
                    writer.write(String.valueOf("Inserted car "+modelText.getText()+" "+yearText.getText()+" at "+date+"\n"));
                    writer.close();

                }
                catch (Exception x)
                {
                    x.printStackTrace();
                }


                // Очистка текстовых полей после добавления объекта Car
                modelText.setText("");
                yearText.setText("");
                mileageText.setText("");
                priceText.setText("");
                volumeText.setText("");
                transmissionText.setText("");
                driveText.setText("");
                helmText.setText("");
                colorText.setText("");
            }
        });
        add(sendButton);


        backButton = new JButton("BACK");
        backButton.setBounds(400, 500, 100, 30);
        backButton.setBackground(new Color(51, 153, 255));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow2.setVisible(true);
                Main.frame.CellCarWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}