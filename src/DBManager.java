import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost:5432/CarSeller"; // input the name of your database
    public static final String user = "postgres";
    public static final String password = "1234";
    public static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to PostgreSQL server was successful");
        } catch (Exception e) {
            System.out.println("ERROR WITH CONNECTION");
            e.printStackTrace();
        }
    }
    public static void addUser1(User user1) throws SQLException
    {
        if (connection == null) {
            System.out.println("No active database connection");
            return; // or throw an exception
        }

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO public.\"User\"  (name, surname, age, login, password, money) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
        );
        statement.setString(1, user1.getName());
        statement.setString(2, user1.getSurname());
        statement.setString(3, user1.getAge());
        statement.setString(4, user1.getLogin());
        statement.setString(5, user1.getPassword());
        statement.setDouble(6, user1.getMoney());

        int rows = statement.executeUpdate();
        statement.close();
    }


    public static ArrayList<User> getAllUsers()
    {
        ArrayList<User> users = new ArrayList<>();

        try
        {
            PreparedStatement statement = connection.prepareStatement(""
                    + "SELECT * FROM public.\"User\"");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String age = resultSet.getString("age");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                double money = resultSet.getDouble("money");
                users.add(new User(id,name,surname,age,login,password,money));
            }
            statement.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }


    public static User getUser(String login, String password)
    {
     User user = null;
        try
        {
            PreparedStatement statement = connection.prepareStatement(""
                    + "SELECT * FROM public.\"User\" WHERE login = ? AND password = ?");

            statement.setString(1,login);
            statement.setString(2,password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String age = resultSet.getString("age");
                String login_ = resultSet.getString("login");
                String password_ = resultSet.getString("password");
                double money = resultSet.getDouble("money");
                user = new User(id,name,surname,age,login_,password_,money);
            }
            statement.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    public static void addMoney(String login, String password, double money) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE public.\"User\" SET money = money + ? WHERE login = ? AND password = ?"
            );
            statement.setDouble(1, money);
            statement.setString(2, login);
            statement.setString(3, password);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Failed to add money. Invalid login or password.");
            } else {
                System.out.println("Money added successfully.");
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeMoney(String login, String password, double money) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE public.\"User\" SET money = money - ? WHERE login = ? AND password = ?"
            );
            statement.setDouble(1, money);
            statement.setString(2, login);
            statement.setString(3, password);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Failed to add money. Invalid login or password.");
            } else {
                System.out.println("Money added successfully.");
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void addCar(Car car) throws SQLException {
        if (connection == null) {
            System.out.println("No active database connection");
            return; // or throw an exception
        }

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO public.\"Car\" ("model", year, mileage, price, volume, transmission, drive, helm, color) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        statement.setString(1, car.getModel());
        statement.setString(2, car.getYear());
        statement.setString(3, car.getMileage());
        statement.setDouble(4, car.getPrice());
        statement.setString(5, car.getVolume());
        statement.setString(6, car.getTransmission());
        statement.setString(7, car.getDrive());
        statement.setString(8, car.getHelm());
        statement.setString(9, car.getColor());

        int rows = statement.executeUpdate();
        statement.close();
    }



    public static ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM public.\"Car\""
            );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                String year = resultSet.getString("year");
                String mileage = resultSet.getString("mileage");
                double price = resultSet.getDouble("price");
                String volume = resultSet.getString("volume");
                String transmission = resultSet.getString("transmission");
                String drive = resultSet.getString("drive");
                String helm = resultSet.getString("helm");
                String color = resultSet.getString("color");

                Car car = new Car(id, model, year, mileage, price, volume, transmission, drive, helm, color);
                cars.add(car);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cars;
    }


    public static void removeCar(int carId) throws SQLException {
        if (connection == null) {
            System.out.println("No active database connection");
            return; // or throw an exception
        }

        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM public.\"Car\" WHERE id = ?"
        );
        statement.setInt(1, carId);

        int rows = statement.executeUpdate();
        statement.close();
    }

}