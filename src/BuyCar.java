import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.ListSelectionListener;
public class BuyCar extends Container {

    public static  ArrayList<Car> cars = DBManager.getAllCars();

    private JTextArea carListTextArea;
    private JScrollPane carListScrollPane;
    private JButton listButton, buyButton, exitButton;
    private JComboBox<String> carComboBox;
    private int selectedCarIndex = -1;

    Date date = new Date();
    public BuyCar() {
        setSize(800, 600); // Reduce the height of the window
        setLayout(null);

        // Text area for displaying the car list
        carListTextArea = new JTextArea();
        carListScrollPane = new JScrollPane(carListTextArea);
        carListScrollPane.setBounds(50, 50, 600, 400); // Reduce the height of the scroll pane
        add(carListScrollPane);


        carComboBox = new JComboBox<>();
        carComboBox.setBounds(50, 480, 600, 30);
        carComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = carComboBox.getSelectedIndex();
                if (selectedIndex != -1) {
                    selectedCarIndex = selectedIndex;
                }
            }
        });
        add(carComboBox);


        // "List" button for displaying the car list
        listButton = new JButton("List");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCarList();
            }
        });
        listButton.setBounds(50, 540, 100, 60);
        listButton.setBackground(new Color(51, 153, 255));
        listButton.setForeground(Color.WHITE);
        add(listButton);


        // "Buy" button for purchasing a selected car
        buyButton = new JButton("Buy");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedCarIndex != -1 && UserInfo.user.getMoney()>cars.get(selectedCarIndex).getPrice()) {
                    DBManager.removeMoney(UserInfo.login,UserInfo.password,cars.get(selectedCarIndex).getPrice());
                    try {
                        DBManager.removeCar(cars.get(selectedCarIndex).getId());
                        cars.remove(selectedCarIndex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    try
                    {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
                        writer.write(String.valueOf(UserInfo.user.getName()+" "+ UserInfo.user.getSurname()+ " bought car "+cars.get(selectedCarIndex).getModel()+" "+cars.get(selectedCarIndex).getYear()+" at "+date+"\n"));
                        writer.close();
                    }
                    catch (Exception x)
                    {
                        x.printStackTrace();
                    }


                    updateCarList();
                    selectedCarIndex = -1;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Not enough money!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buyButton.setBounds(310, 540, 100, 60);
        buyButton.setBackground(new Color(51, 153, 255));
        buyButton.setForeground(Color.WHITE);
        add(buyButton);

        // "Exit" button for returning to the main menu
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow2.setVisible(true);
                Main.frame.BuyCarWindow.setVisible(false);
            }
        });
        exitButton.setBounds(550, 540, 100, 60);
        exitButton.setBackground(new Color(51, 153, 255));
        exitButton.setForeground(Color.WHITE);
        add(exitButton);
    }
    private void updateCarList() {
        carListTextArea.setText("");
        carComboBox.removeAllItems();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String carInfo = car.getId() + ". Model: " + car.getModel() + ", Year: " + car.getYear() + ", Mileage: " + car.getMileage() + ", Price: " + car.getPrice()+" $, Volume: "+ car.getVolume()+" , Transmission: "+ car.getTransmission()+", Drive: "+car.getDrive()+", Helm: "+car.getHelm()+", Color: "+car.getColor();
            carListTextArea.append(carInfo + "\n");
            carComboBox.addItem(carInfo);
        }
    }
}