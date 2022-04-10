package collegetracker;

public class ActivityNotFoundException extends RuntimeException{
    //exception thrown if the activity isnt found
    public ActivityNotFoundException(){
        super("Oops! This activity is not in the college tracker.");
    }
}
