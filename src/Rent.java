import java.util.Date;

public class Rent {
    public Date rentalDate;
    public Date returnDate;
    public String carRegistrationNumber;
    public String userName;
    public String duration;

    Rent(Date rentalDate, String carRegistrationNumber, String userName) {
        this.rentalDate = rentalDate;
        this.returnDate = null;
        this.carRegistrationNumber = carRegistrationNumber;
        this.userName = userName;
        this.duration = "Still rented";
    }

    public void display() {
        System.out.println("Rental date: " + this.rentalDate.toString());
        if (returnDate == null)
            System.out.println("Return date: Not returned yet");
        else
            System.out.println("Return date: " + this.returnDate.toString());
        System.out.println("Duration: " + this.duration);
    }

    public void setDuration() {
        long difference_In_Time = returnDate.getTime() - rentalDate.getTime();

        long difference_In_Seconds = (difference_In_Time / 1000) % 60;

        long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

        long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

        this.duration = difference_In_Years + " years, " + difference_In_Days + " days, " + difference_In_Hours
                + " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds + " seconds";
    }
}
