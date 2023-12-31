import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CarRental implements ICarRental {
    private Map<String, User> users;
    private Map<String, Car> cars;
    private ArrayList<Rent> rentals;
    private Set<Car> availableCars;

    public

    CarRental() {
        users = new HashMap<>();
        cars = new HashMap<>();
        rentals = new ArrayList<Rent>();
        availableCars = new HashSet<>();
    }

    public void addUser(String name, String contact) {
        users.put(name, new User(name, contact));
        System.out.println("User " + name + " has been added");
    }

    public void updateUser(String name, String contact) {
        if (!users.containsKey(name)) {
            System.out.println("User " + name + " does not exist");
            return;
        }

        User user = users.get(name);
        user.contact = contact;
        System.out.println(name + "'s information is updated successfully");
    }

    public void deleteUser(String name) {
        if (!users.containsKey(name)) {
            System.out.println("User " + name + " does not exist");
            return;
        }
        
        users.remove(name);
        System.out.println("User " + name + " has been deleted");
    }

    public void addCar(String registrationNumber, String model, String color) {
        if (cars.containsKey(registrationNumber)) {
            System.out.println("Car with registration number " + registrationNumber + " already exists");
            return;
        }

        cars.put(registrationNumber, new Car(registrationNumber, model, color));
        availableCars.add(cars.get(registrationNumber));

        System.out.println("Car with registration number " + registrationNumber + " has been added");
    }

    public void updateCar(String registrationNumber, String model, String color) {
        if (!cars.containsKey(registrationNumber)) {
            System.out.println("Car with registration number " + registrationNumber + " doesn't exists");
            return;
        }

        Car car = cars.get(registrationNumber);
        car.model = model;
        car.color = color;
        System.out.println(registrationNumber + "'s information is updated successfully");
    }

    public void deleteCar(String registrationNumber) {
        if (!cars.containsKey(registrationNumber)) {
            System.out.println("Car with registration number " + registrationNumber + " doesn't exists");
            return;
        }

        cars.remove(registrationNumber);
        System.out.println("Car with registration number " + registrationNumber + " has been deleted");
    }

    public void rentCar(String userName, String registrationNumber) {
        if (!users.containsKey(userName)) {
            System.out.println("User " + userName + " does not exist");
            return;
        }

        if (!cars.containsKey(registrationNumber)) {
            System.out.println("Car with registration number " + registrationNumber + " doesn't exists");
            return;
        }

        User user = users.get(userName);
        Car car = cars.get(registrationNumber);

        if (!car.isAvailable) {
            System.out.println("Car with registration number " + registrationNumber + " has already been rented");
            return;
        }

        Rent newRental = new Rent(new Date(), car.registrationNumber, user.name);

        user.addRent(newRental);
        car.addRent(newRental);

        availableCars.remove(car);
        rentals.add(newRental);

        System.out.println("Car with registration number " + registrationNumber + " is rented by " + userName);
    }

    public void returnCar(String userName, String registrationNumber) {
        if (!users.containsKey(userName)) {
            System.out.println("User " + userName + " does not exist");
            return;
        }

        if (!cars.containsKey(registrationNumber)) {
            System.out.println("Car with registration number " + registrationNumber + " doesn't exists");
            return;
        }

        Car car = cars.get(registrationNumber);

        if (car.isAvailable) {
            System.out.println("Car with registration number " + registrationNumber + " was never rented");
            return;
        }

        car.isAvailable = true;

        Rent lastRental = car.history.get(car.history.size() - 1);

        lastRental.returnDate = new Date();
        lastRental.setDuration();

        availableCars.add(car);

        System.out.println("Car with registration number " + registrationNumber + " is now returned by " + userName);
    }

    public void displayUsers() {
        System.out.println("------ User list ------");

        int count = 1;
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User user = entry.getValue();
            System.out.println("User " + count + ": ");
            user.display();
            System.out.println();

            count++;
        }
    }

    public void displayCars() {
        System.out.println("------ Car list ------");

        int count = 1;
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            Car car = entry.getValue();
            System.out.println("Car " + count + ": ");
            car.display();
            System.out.println();

            count++;
        }
    }

    public void displayAvailableCars() {
        System.out.println("------ Available car list ------");

        int count = 1;
        for (Car car : availableCars) {
            System.out.println("Car " + count + ": ");
            car.display();
            System.out.println();
        }
    }

    public void displayRentals() {
        System.out.println("------ Rental list ------");

        int count = 1;
        for (Rent rental : rentals) {
            System.out.println("Rental " + count + ": ");
            System.out.println("Username: " + rental.userName);
            System.out.println("Car: " + rental.carRegistrationNumber);
            rental.display();
            System.out.println();

            count++;
        }
    }

    public void displayRentalsByUser(String userName) {
        if (!users.containsKey(userName)) {
            System.out.println("User " + userName + " does not exist");
            return;
        }

        System.out.println("------ Rental list of " + userName + " ------");
        User user = users.get(userName);
        user.displayHistory();
    }

    public void displayRentalsByCar(String registrationNumber) {
        if (!cars.containsKey(registrationNumber)) {
            System.out.println("Car with registration number " + registrationNumber + " does not exist");
            return;
        }

        System.out.println("------ Rental list of car with registration number " + registrationNumber + " ------");
        Car car = cars.get(registrationNumber);
        car.displayHistory();
    }
}