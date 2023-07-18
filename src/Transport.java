public abstract class  Transport {
    String model;
    private String year;
    private String mileage;
    private double price;

    public Transport(String model, String year, String mileage, double price) {
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public Transport() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", mileage='" + mileage + '\'' +
                ", price=" + price +
                '}';
    }
}
