import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {

    public static void main(String[] args) throws SQLException  {
        try {
            Socket socket = new Socket("127.0.0.1",5000);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Input your name");
            String name = reader.readLine();


            for (int i = 0; i < 5; i++) {
                String massage= reader.readLine();
                Date date = new Date();
                outputStream.writeObject(name +" at "+date+": "+massage);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
