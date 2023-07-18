public class User implements Identification {
    private int id;
    private String name;
    private String surname;
    private String age;
    private String login;
    private String password;
    private double money;

    public User(int id, String name, String surname, String age, String login, String password, double money) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.money = money;
    }

    public User(String name, String surname, String age, String login, String password, double money) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.money = money;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateofBirth() {
        return age;
    }

    public void setDateofBirth(String dateofBirth) {
        this.age = dateofBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }


    @Override
    public String toString() {
        return id+" "+name+" "+surname+" "+age+" "+login+" "+password+" "+money ;
    }

    @Override
    public void setId() {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }
}
