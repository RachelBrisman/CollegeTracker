package collegetracker;

public class CourseNotFoundException extends RuntimeException{
    //exception thrown if the course isnt found
    public CourseNotFoundException(){
        super("Oops! This course is not in the college tracker.");
    }
}
