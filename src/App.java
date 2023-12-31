import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("------ Car Rental System ------");

        // CarRental carRental = new CarRental();
        // carRental.add("abc123");
        // carRental.add("def456");
        // System.out.println();

        // carRental.display();

        // carRental.rent("123");
        // carRental.rent("abc123");
        // System.out.println();

        // carRental.returnCar("123");
        // carRental.returnCar("def456");
        // System.out.println();

        // carRental.display();
        // carRental.returnCar("abc123");
        // System.out.println();

        CarRental carRental = new CarRental();

        int option;

        do {

            System.out.println("1: Add user");
            System.out.println("2: Update user");
            System.out.println("3: Delete user");
            System.out.println("4: Add car");
            System.out.println("5: Update car");
            System.out.println("6: Delete car");
            System.out.println("7: Rent car");
            System.out.println("8: Return car");
            System.out.println("9: Display users");
            System.out.println("10: Display cars");
            System.out.println("11: Display cars by availability");
            System.out.println("12: Display all rentals");
            System.out.println("13: Display rentals by username");
            System.out.println("14: Display rentals by car");
            System.out.println("0: Exit");

            option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("ADD USER");
                    carRental.addUser(getInput("Enter name: "), getInput("Enter contact number: "));
                    System.out.println();
                    break;

                case 2:
                    System.out.println("UPDATE USER");
                    carRental.updateUser(getInput("Enter name of user to be updated: "),
                            getInput("Enter new contact number: "));
                    System.out.println();
                    break;

                case 3:
                    System.out.println("DELETE USER");
                    carRental.deleteUser(getInput("Enter username to be deleted"));
                    System.out.println();
                    break;

                case 4:
                    System.out.println("ADD CAR");
                    carRental.addCar(getInput("Enter car registration number: "), getInput("Enter car model: "),
                            getInput("Enter car color: "));
                    System.out.println();
                    break;

                case 5:
                    System.out.println("UPDATE CAR");
                    carRental.updateCar(getInput("Enter car registation number: "), getInput("Enter car model: "),
                            getInput("Enter car color: "));
                    System.out.println();
                    break;

                case 6:
                    System.out.println("DELETE CAR");
                    carRental.deleteCar(getInput("Enter car registration number to be deleted"));
                    System.out.println();
                    break;

                case 7:
                    System.out.println("RENT CAR");
                    carRental.rentCar(getInput("Enter username: "), getInput("Enter car registration number: "));
                    System.out.println();
                    break;

                case 8:
                    System.out.println("RETURN CAR");
                    carRental.returnCar(getInput("Enter username: "), getInput("Enter car registration number: "));
                    System.out.println();
                    break;

                case 9:
                    System.out.println("DISPLAY USERS");
                    carRental.displayUsers();
                    System.out.println();
                    break;

                case 10:
                    System.out.println("DISPLAY CARS");
                    carRental.displayCars();
                    System.out.println();
                    break;

                case 11:
                    System.out.println("DISPLAY AVAILABLE CARS");
                    carRental.displayAvailableCars();
                    System.out.println();
                    break;

                case 12:
                    System.out.println("DISPLAY RENTALS");
                    carRental.displayRentals();
                    System.out.println();
                    break;

                case 13:
                    System.out.println("DISPLAY RENTALS BY USERNAME");
                    carRental.displayRentalsByUser(getInput("Enter username: "));
                    System.out.println();
                    break;

                case 14:
                    System.out.println("DISPLAY RENTALS BY CAR REGISTRATION NUMBER");
                    carRental.displayRentalsByCar(getInput("Enter car registration number: "));
                    System.out.println();
                    break;

                default:
                    option = 0;
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
}
