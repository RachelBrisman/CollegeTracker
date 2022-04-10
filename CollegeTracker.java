package collegetracker;

import java.util.ArrayList;

public class CollegeTracker {
    //fields:
    ArrayList<Course> courseList;
    ArrayList<Activity> activityList;

    //constructor
    public CollegeTracker(){
        this.courseList = new ArrayList<Course>();
        this.activityList = new ArrayList<Activity>();
    }

    //adds a course to the arraylist
    public void addCourse(String name, CourseCode code, String courseNum, String profName, String startMonth, String endMonth){
        Course c = new Course(name, code, courseNum, profName, startMonth, endMonth);
        courseList.add(c);
    }

    //adds a lecture to activity list
    public void addLecture(String name, String dueDate, Course course,String description){
        Lecture l = new Lecture(name, dueDate, course, description);
        activityList.add(l);
    }

    //adds an assignment to activity list
    public void addAssignment(String name, String dueDate, Course course, String details, Lecture lecture){
        Assignment a = new Assignment(name, dueDate, course, details, lecture);
        activityList.add(a);
    }

    //checks if a course exists, if it does, it removes it
    public void removeCourse(Course c){
        int courseExistIndex = -1;
        for(Course cur: this.courseList){
            if(cur.equals(c)){
                courseExistIndex = this.courseList.indexOf(cur);
            }
        }
        if(courseExistIndex == -1){
            throw new CourseNotFoundException();
        }else{
            this.courseList.remove(courseExistIndex);
        }
    }

    //checks if a lecture exists, if it does, removes it
    public void removeLecture(Lecture l){
        int lectureExistIndex = -1;
        for(Activity cur: this.activityList){
            if(cur instanceof Lecture){
                if(cur.equals(l)){
                    lectureExistIndex = this.activityList.indexOf(cur);
                }
            }
        }
        if(lectureExistIndex == -1){
            throw new ActivityNotFoundException();
        }else{
            this.activityList.remove(lectureExistIndex);
        }
    }

    //checks if an assignment exists, if it does removes it from the arraylist
    public void removeAssignment(Assignment a){
        int aExistIndex = -1;
        for(Activity cur: this.activityList){
            if(cur instanceof Assignment){
                if(cur.equals(a)){
                    aExistIndex = this.activityList.indexOf(cur);
                }
            }
        }
        if(aExistIndex == -1){
            throw new ActivityNotFoundException();
        }else{
            this.activityList.remove(aExistIndex);
        }
    }

    //prints all the courses
    public void printCourses(){
        if(courseList.isEmpty()){
            System.out.println("There are no courses in the college tracker yet!");
        }else {
            for (Course c : this.courseList) {
                System.out.println(c.toString());
            }
        }
    }

    //prints all of the activities
    public void printAllActivities(){
        if(activityList.isEmpty()){
            System.out.println("There are no activities in the college tracker yet!");
        }else {
            for (Activity a : this.activityList) {
                System.out.println(a.toString());
            }
        }
    }

    public void printAllActivitiesForCourse(Course c){
        if(activityList.isEmpty()){
            System.out.println("There are no activities in the college tracker yet!");
        }else {
            for (Activity a : this.activityList) {
                if(a.getCourse().equals(c)){
                    System.out.println(a.toString());
                }
            }
        }
    }

    //prints the incomplete activities
    public void printIncompleteActivities(){
        if(activityList.isEmpty()){
            System.out.println("There are no activities in the college tracker yet!");
        }else {
            for (Activity a : this.activityList) {
                if(!(a.getComplete())){
                    System.out.println(a.toString());
                }
            }
        }
    }

    //prints the complete activities
    public void printCompleteActivities(){
        if(activityList.isEmpty()){
            System.out.println("There are no activities in the college tracker yet!");
        }else {
            for (Activity a : this.activityList) {
                if(a.getComplete()){
                    System.out.println(a.toString());
                }
            }
        }
    }

    //completes an activity, switches the isComplete boolean
    public void completeActivity(Activity a){
        int aExistIndex = -1;
        for(Activity cur: this.activityList){
            if(cur instanceof Assignment){
                if(cur.equals(a)){
                    aExistIndex = this.activityList.indexOf(cur);
                }
            }
        }
        if(aExistIndex == -1){
            throw new ActivityNotFoundException();
        }else{
            this.activityList.get(aExistIndex).setComplete(true);
        }
    }

    //toString method
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Course c: courseList){
            builder.append(c.toString() + "\n");
        }
        for(Activity a: activityList){
            builder.append(a.toString() + "\n");
        }
        return builder.toString();
    }
}
