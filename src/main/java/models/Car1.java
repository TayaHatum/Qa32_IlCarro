package models;

public class Car1 {
    String address;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;
    String doors;
    String seats;
    String clasS;
    String fuelConsumption;
    String carRegNumber;
    String price;
    String distanceIncluded;
    String features;
    String about;

    public Car1 withAddress(String address) {
        this.address = address;
        return this;
    }

    public Car1 withMake(String make) {
        this.make = make;
        return this;
    }

    public Car1 withModel(String model) {
        this.model = model;
        return this;
    }

    public Car1 withYear(String year) {
        this.year = year;
        return this;
    }

    public Car1 withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car1 withFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car1 withGear(String gear) {
        this.gear = gear;
        return this;
    }

    public Car1 withwD(String wD) {
        this.wD = wD;
        return this;
    }

    public Car1 withDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car1 withSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car1 withClasS(String clasS) {
        this.clasS = clasS;
        return this;
    }

    public Car1 withFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car1 withCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
        return this;
    }

    public Car1 withPrice(String price) {
        this.price = price;
        return this;
    }

    public Car1 withDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public Car1 withFeatures(String features) {
        this.features = features;
        return this;
    }

    public Car1 withAbout(String about) {
        this.about = about;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel() {
        return fuel;
    }

    public String getGear() {
        return gear;
    }

    public String getwD() {
        return wD;
    }

    public String getDoors() {
        return doors;
    }

    public String getSeats() {
        return seats;
    }

    public String getClasS() {
        return clasS;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getDistanceIncluded() {
        return distanceIncluded;
    }

    public String getFeatures() {
        return features;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "address='" + address + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", engine='" + engine + '\'' +
                ", fuel='" + fuel + '\'' +
                ", gear='" + gear + '\'' +
                ", wD='" + wD + '\'' +
                ", doors='" + doors + '\'' +
                ", seats='" + seats + '\'' +
                ", clasS='" + clasS + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                ", carRegNumber='" + carRegNumber + '\'' +
                ", price='" + price + '\'' +
                ", distanceIncluded='" + distanceIncluded + '\'' +
                ", features='" + features + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
