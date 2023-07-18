public class Car extends Transport implements Identification {
    private int id;
    private String volume;
    private String transmission;

    private String drive;
    private String helm;
    private String color;

    public Car(int id,String model, String year, String mileage, double price, String volume, String transmission, String drive, String helm, String color) {
        super(model, year, mileage, price);
        this.id=id;
        this.volume = volume;
        this.transmission = transmission;
        this.drive = drive;
        this.helm = helm;
        this.color = color;
    }

    public Car(String model, String year, String mileage, double price, String volume, String transmission, String drive, String helm, String color) {
        super(model, year, mileage, price);
        this.volume = volume;
        this.transmission = transmission;
        this.drive = drive;
        this.helm = helm;
        this.color = color;
    }

    public Car(String volume, String transmission, String drive, String helm, String color) {
        this.volume = volume;
        this.transmission = transmission;
        this.drive = drive;
        this.helm = helm;
        this.color = color;
    }



    public Car() {
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getHelm() {
        return helm;
    }

    public void setHelm(String helm) {
        this.helm = helm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public void setId() {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String toString() {
        return "Car ID: " + id +
                "\nModel: " + model +
                "\nYear: " + getYear() +
                "\nMileage: " + getMileage() +
                "\nPrice: $" + getPrice() +
                "\nVolume: " + volume +
                "\nTransmission: " + transmission +
                "\nDrive: " + drive +
                "\nHelm: " + helm +
                "\nColor: " + color;
    }
}
