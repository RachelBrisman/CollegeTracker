package collegetracker;

public class Course {
    //variables that all course objects have
    private String name;
    private CourseCode code;
    private String courseNum;
    private String profName;
    private String startMonth;
    private String endMonth;
    private String location;
    private String schedule;

    //two constructors
    public Course(String name, CourseCode code, String courseNum, String profName, String startMonth, String endMonth) {
        if(name != null){
            this.name = name;
        }else{
            throw new InvalidDataException();
        }
        if(code != null){
            this.code = code;
        }else{
            throw new InvalidDataException();
        }
        if(courseNum != null){
            this.courseNum = courseNum;
        }else{
            throw new InvalidDataException();
        }
        setProfName(profName);
        if(startMonth != null){
            this.startMonth = startMonth;
        }else{
            throw new InvalidDataException();
        }
        if(endMonth != null) {
            this.endMonth = endMonth;
        }else{
            throw new InvalidDataException();
        }
    }

    public Course(String name, CourseCode code, String courseNum, String profName, String startMonth, String endMonth, String location, String schedule) {
        if(name != null){
            this.name = name;
        }else{
            throw new InvalidDataException();
        }
        if(code != null){
            this.code = code;
        }else{
            throw new InvalidDataException();
        }
        if(courseNum != null){
            this.courseNum = courseNum;
        }else{
            throw new InvalidDataException();
        }
        setProfName(profName);
        if(startMonth != null){
            this.startMonth = startMonth;
        }else{
            throw new InvalidDataException();
        }
        if(endMonth != null) {
            this.endMonth = endMonth;
        }else{
            throw new InvalidDataException();
        }
        setLocation(location);
        setSchedule(schedule);
    }

    //setters - only have for the ones that are allowed to change
    public void setProfName(String profName) {
        if(profName != null) {
            this.profName = profName;
        }else{
            throw new InvalidDataException();
        }
    }

    public void setSchedule(String schedule) {
        if(schedule != null) {
            this.schedule = schedule;
        }else{
            throw new InvalidDataException();
        }
    }

    public void setLocation(String location) {
        if(location != null){
            this.location = location;
        }else{
            throw new InvalidDataException();
        }
    }

    //getters for all fields
    public String getProfName() {
        return profName;
    }

    public String getLocation() {
        return location;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getName() {
        return name;
    }

    public CourseCode getCode() {
        return code;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    //to string method
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Course: \n");
        builder.append("Name: " + this.getName() +"\n");
        builder.append("Course Code: " + this.getCode() +"\n");
        builder.append("Course Number: " + this.getCourseNum() +"\n");
        builder.append("Professor: " + this.getProfName() +"\n");
        builder.append("Start Month: " + this.getStartMonth() +"\n");
        builder.append("End Month: " + this.getEndMonth() +"\n");
        builder.append("Location: " + this.getLocation() +"\n");
        builder.append("Schedule: " + this.getSchedule() +"\n");
        return builder.toString();
    }

    // method to see if two courses are the same
    public boolean equals(Object other){
        if(other instanceof Course){
            Course c = (Course) other;
            //Now check if equal
            if(this.getCode().equals(c.getCode())){
                if(this.getCourseNum().equals(c.getCourseNum())){
                    if(this.getStartMonth().equals(c.getStartMonth())){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } else{
            return false;
        }
    }
}
