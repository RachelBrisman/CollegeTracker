package collegetracker;

public abstract class Activity {
    //all activities have the following fields
    private String name;
    private String dueDate;
    private Boolean complete;
    private Course course;

    //Constructor
    public Activity(String name, String dueDate, Course course){
        if(name != null){
            this.name = name;
        }else{
            throw new InvalidDataException();
        }
        if(course != null){
            this.course = course;
        }else{
            throw new InvalidDataException();
        }
        setDueDate(dueDate);
        setComplete(false);
    }

    //setters for what we are allowed to change
    public void setDueDate(String dueDate) {
        if(dueDate != null) {
            this.dueDate = dueDate;
        }else{
            throw new InvalidDataException();
        }
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Boolean getComplete() {
        return complete;
    }

    public Course getCourse() {
        return course;
    }

    //to string method
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + this.getName());
        builder.append("Due Date: " + this.getDueDate());
        builder.append("Course: " + this.getCourse());
        builder.append("Completed: " + this.getComplete());
        return builder.toString();
    }

    //this method tests whether two activities are the same
    public boolean equals(Object other){
        if(other instanceof Activity){
            Activity a = (Activity) other;
            //Now check if equal
            if(this.getName().equals(a.getName())){
                if(this.getDueDate().equals(a.getDueDate())){
                    return true;
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
