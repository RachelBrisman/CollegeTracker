package collegetracker;

public class InvalidDataException extends RuntimeException{
    // exception thrown if invalid data entered
    public InvalidDataException(){
        super("Oops! You entered some invalid data. Let's try this again.");
    }
}
