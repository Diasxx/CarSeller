import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static MainFrame frame;
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        DBManager.connect();
        frame = new MainFrame();
        frame.setVisible(true);
    }
}
