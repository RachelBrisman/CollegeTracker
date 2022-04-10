package collegetracker;

import java.util.Scanner;

public class UseTracker {
    //creates tracker to work  with
    static CollegeTracker myTracker = new CollegeTracker();
    //creates scanner to work with
    static Scanner scan = new Scanner(System.in);

    //driver method
    public static void main(String[] args){
//calls the method to print the menu
        printMenu();
        //retrieves user's choice
        int userChoice = scan.nextInt();
        scan.next();
        //while loop that runs the menu and its methods while the user doesn't quit the program
        while(userChoice > 0 && userChoice < 17){

            //runs different methods that are found below depending on the user's choice
            switch (userChoice) {
                case 1 -> addCourse();
                case 2 -> addLecture();
                case 3 -> addAssignment();
                case 4 -> removeCourse();
                case 5 -> removeLecture();
                case 6 -> removeAssignment();
                case 7 -> changeProfName();
                case 8 -> changeCourseLoc();
                case 9 -> changeCourseSched();
                case 10 -> changeActivityDueDate();
                case 11 -> changeActivityComplete();
                case 12 -> myTracker.printAllActivities();
                case 13 -> printAllActivitiesForACourse();
                case 14 -> myTracker.printCompleteActivities();
                case 15 -> myTracker.printIncompleteActivities();
                case 16 -> myTracker.printCourses();
            }

            printMenu();
            userChoice = scan.nextInt();
            scan.next();
        }
        System.out.println("Thank you for using our college tracker!");
        /*System.out.println("What file should we send the information to?");
        String fileName = scan.nextLine();
        PrintWriter file = new PrintWriter(fileName);
        file.println();
        file.close();*/
        scan.close();
    }

    private static void printMenu(){
        System.out.println("""
                
                College Tracker Menu
                1.Add a Course
                2.Add a Lecture
                3.Add an Assignment
                4.Remove a Course
                5.Remove a Lecture
                6.Remove an Assignment
                7.Change a Course's Professor Name
                8.Change a Course's Location
                9.Change a Course's Schedule
                10.Change an Activity's Due Date
                11.Change an Activity's Completion Status
                12.Print All Activities
                13.Print All Activities for a Course
                14.Print Completed Activities
                15.Print Incomplete Activities
                16.Print All Courses
                17.Quit the Program

                Please enter the number of the menu item you would like to do:""");
    }

    public static void addCourse(){
        try {
            System.out.println("Please fill out the following about the course:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Course Code:");
            String cCode = scan.nextLine();
            System.out.println("Course Number:");
            String courseNum = scan.nextLine();
            System.out.println("Professor Name:");
            String prof = scan.nextLine();
            System.out.println("Start Month:");
            String sMonth = scan.nextLine();
            System.out.println("End Month:");
            String eMonth = scan.nextLine();
            myTracker.addCourse(name, CourseCode.valueOf(cCode.toUpperCase()), courseNum, prof, sMonth, eMonth);
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addLecture(){
        try{
            System.out.println("Please fill out the following about the lecture:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Due Date:");
            String dueDate = scan.nextLine();
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Number:");
            String courseNum = scan.nextLine();
            System.out.println("Description:");
            String desc = scan.nextLine();
            for(Course c: myTracker.courseList){
                if(c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))){
                    if(c.getCourseNum().equals(courseNum)){
                        myTracker.addLecture(name, dueDate, c ,desc);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void addAssignment(){
        try {
            System.out.println("Please fill out the following about the assignment:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Due Date:");
            String dueDate = scan.nextLine();
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Number:");
            String courseNum = scan.nextLine();
            System.out.println("Details:");
            String dets = scan.nextLine();
            System.out.println("Lecture Name:");
            String lec = scan.nextLine();
            for (Course c : myTracker.courseList) {
                if (c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))) {
                    if (c.getCourseNum().equals(courseNum)) {
                        for (Activity l : myTracker.activityList) {
                            if (l instanceof Lecture) {
                                Lecture lecture = (Lecture) l;
                                if (l.getName().equals(lec)) {
                                    myTracker.addAssignment(name, dueDate, c, dets, lecture);
                                }
                            }
                        }
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeCourse(){
        try {
            System.out.println("Please fill out the following about the course:");
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Num:");
            String courseNum = scan.nextLine();
            for (Course c : myTracker.courseList) {
                if (c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))) {
                    if (c.getCourseNum().equals(courseNum)) {
                        myTracker.courseList.remove(c);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeLecture(){
        try {
            System.out.println("Please fill out the following about the lecture:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Due date:");
            String dDate = scan.nextLine();
            for (Activity a : myTracker.activityList) {
                if (a instanceof Lecture) {
                    if (a.getName().equals(name)) {
                        if (a.getDueDate().equals(dDate)) {
                            myTracker.activityList.remove(a);
                        }
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeAssignment(){
        try {
            System.out.println("Please fill out the following about the assignment:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Due date:");
            String dDate = scan.nextLine();
            for (Activity a : myTracker.activityList) {
                if (a instanceof Assignment) {
                    if (a.getName().equals(name)) {
                        if (a.getDueDate().equals(dDate)) {
                            myTracker.activityList.remove(a);
                        }
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void changeProfName(){
        try {
            System.out.println("Please fill out the following about the course:");
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Num:");
            String courseNum = scan.nextLine();
            System.out.println("New Professor Name:");
            String pName = scan.nextLine();
            for (Course c : myTracker.courseList) {
                if (c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))) {
                    if (c.getCourseNum().equals(courseNum)) {
                        c.setProfName(pName);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void changeCourseLoc(){
        try {
            System.out.println("Please fill out the following about the course:");
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Num:");
            String courseNum = scan.nextLine();
            System.out.println("New Location:");
            String loc = scan.nextLine();
            for (Course c : myTracker.courseList) {
                if (c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))) {
                    if (c.getCourseNum().equals(courseNum)) {
                        c.setLocation(loc);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void changeCourseSched(){
        try {
            System.out.println("Please fill out the following about the course:");
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Num:");
            String courseNum = scan.nextLine();
            System.out.println("New Schedule:");
            String sched = scan.nextLine();
            for (Course c : myTracker.courseList) {
                if (c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))) {
                    if (c.getCourseNum().equals(courseNum)) {
                        c.setSchedule(sched);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void changeActivityDueDate(){
        try {
            System.out.println("Please fill out the following about the activity:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Due date:");
            String dDate = scan.nextLine();
            System.out.println("New Due date:");
            String ndDate = scan.nextLine();
            for (Activity a : myTracker.activityList) {
                if (a.getName().equals(name)) {
                    if (a.getDueDate().equals(dDate)) {
                        a.setDueDate(ndDate);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void changeActivityComplete(){
        try {
            System.out.println("Please fill out the following about the activity:");
            System.out.println("Name:");
            String name = scan.nextLine();
            System.out.println("Due date:");
            String dDate = scan.nextLine();
            for (Activity a : myTracker.activityList) {
                if (a.getName().equals(name)) {
                    if (a.getDueDate().equals(dDate)) {
                        a.setComplete(true);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    private static void printAllActivitiesForACourse(){
        try {
            System.out.println("Please fill out the following about the course:");
            System.out.println("Course Code:");
            String courseCode = scan.nextLine();
            System.out.println("Course Num:");
            String courseNum = scan.nextLine();
            for (Course c : myTracker.courseList) {
                if (c.getCode().equals(CourseCode.valueOf(courseCode.toUpperCase()))) {
                    if (c.getCourseNum().equals(courseNum)) {
                        myTracker.printAllActivitiesForCourse(c);
                    }
                }
            }
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }
}
