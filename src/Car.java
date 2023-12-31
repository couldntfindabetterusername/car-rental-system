import java.util.ArrayList;

public class Car {
    public String registrationNumber;
    public String model;
    public String color;
    public boolean isAvailable;
    public ArrayList<Rent> history;

    public Car(String registrationNumber, String model, String color) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.color = color;
        this.history = new ArrayList<Rent>();
        this.isAvailable = true;
    }

    public void display() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Availability: " + isAvailable);
    }

    public void addRent(Rent newRental) {
        this.isAvailable = false;
        this.history.add(newRental);
    }

    public void displayHistory() {
        if (history.size() == 0) {
            System.out.println("Car with registration number " + registrationNumber + " has not rented by any user");
            return;
        }

        int count = 1;
        for (Rent rental : history) {
            System.out.println("Rent " + count + ":");
            System.out.println("Username: " + rental.userName);
            rental.display();
            System.out.println();

            count++;
        }
    }
}
