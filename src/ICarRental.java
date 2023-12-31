public interface ICarRental {
    public void addUser(String name, String contact);

    public void updateUser(String name, String contact);

    public void deleteUser(String name);

    public void addCar(String registrationNumber, String model, String color);

    public void updateCar(String registrationNumber, String model, String color);

    public void deleteCar(String registrationNumber);

    public void rentCar(String userName, String registrationNumber);

    public void returnCar(String userName, String registrationNumber);

    public void displayUsers();

    public void displayCars();

    public void displayAvailableCars();

    public void displayRentals();

    public void displayRentalsByUser(String userName);

    public void displayRentalsByCar(String registrationNumber);
}
