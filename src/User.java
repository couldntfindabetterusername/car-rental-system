import java.util.ArrayList;

public class User {
    public String name;
    public String contact;
    public ArrayList<Rent> history;

    User(String name, String contact) {
        this.name = name;
        this.contact = contact;
        this.history = new ArrayList<Rent>();
    }

    public void addRent(Rent rent) {
        this.history.add(rent);
    }

    public void returnCar(Rent rent) {
        for (Rent rentItem : history) {
            if (rentItem.carRegistrationNumber.equals(rent.carRegistrationNumber) && rentItem.returnDate == null) {
                rentItem.returnDate = rent.returnDate;
                rentItem.duration = rent.duration;
                return;
            }
        }
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
    }

    public void displayHistory() {
        if (history.size() == 0) {
            System.out.println(name + " has not rented any car");
            return;
        }

        int count = 1;
        for (Rent rental : history) {
            System.out.println("Rent " + count + ":");
            System.out.println("Car: " + rental.carRegistrationNumber);
            rental.display();
            System.out.println();

            count++;
        }
    }
}
