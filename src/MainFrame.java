import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu1 menuWindow1;
    public static AddUser addWindow;
    public static Login loginWindow;
    public static MainMenu2 menuWindow2;
    public static CellCar CellCarWindow;
    public static UserInfo UserInfoWindow;
    public static BuyCar BuyCarWindow;
    

    public MainFrame()
    {
        setSize(700, 700);
        setTitle("SELL CAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuWindow1 = new MainMenu1();
        setLocation(450, 90 );
        add(menuWindow1);


        addWindow = new AddUser();
        setLocation(450, 90 );
        addWindow.setVisible(false);
        add(addWindow);


        loginWindow = new Login();
        setLocation(450, 90 );
        loginWindow.setVisible(false);
        add(loginWindow);

        menuWindow2 = new MainMenu2();
        setLocation(450, 90 );
        menuWindow2.setVisible(false);
        add(menuWindow2);

        CellCarWindow = new CellCar();
        setLocation(450, 90 );
        CellCarWindow.setVisible(false);
        add(CellCarWindow);



        BuyCarWindow = new BuyCar() ;
        setLocation(450, 90 );
        BuyCarWindow.setVisible(false);
        add(BuyCarWindow);


    }


}
