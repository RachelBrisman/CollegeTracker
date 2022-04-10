package collegetracker;

public class Assignment extends Activity implements Gradeable{
    //fields unique to assignment
    private String details;
    private Integer grade;
    private Lecture lecture;
    private Boolean isFileUpload;
    private String fileLink;

    //constructors
    public Assignment(String name, String dueDate, Course course, String details, Lecture lecture){
        super(name, dueDate, course);
        setDetails(details);
        setLecture(lecture);
        setFileLink(null);
    }

    public Assignment(String name, String dueDate, Course course, String details, Lecture lecture, String fileLink){
        super(name, dueDate, course);
        setDetails(details);
        setLecture(lecture);
        setFileLink(fileLink);
    }

    public void setDetails(String details) {
        if(details != null) {
            this.details = details;
        }else{
            throw new InvalidDataException();
        }
    }

    //setters
    public void setGrade(Integer grade) {
        if(grade > 0 && grade < 11){
            this.grade = grade;
        }else{
            throw new InvalidDataException();
        }
    }

    public void setLecture(Lecture lecture) {
        if(lecture != null) {
            this.lecture = lecture;
        }else{
            throw new InvalidDataException();
        }
    }

    public void setFileLink(String fileLink) {
        if(fileLink != null) {
            this.fileLink = fileLink;
            this.isFileUpload = true;
        }else{
            this.isFileUpload = false;
        }
    }

    //getters
    public String getDetails() {
        return details;
    }

    public Integer getGrade() {
        return grade;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Boolean getFileUpload() {
        return isFileUpload;
    }

    public String getFileLink() {
        return fileLink;
    }

    //method that grades this assigment
    public Integer gradeActivity() {
        return this.getGrade();
    }

    //toString method
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Assignment \n");
        builder.append(super.toString());
        builder.append("Details: " + this.getDetails() + "\n");
        builder.append("Grade: " + this.getGrade() + "\n");
        builder.append("Lecture: " + this.getLecture() + "\n");
        if(this.getFileUpload()){
            builder.append("File Link: " + getFileLink() + "\n");
        }
        return builder.toString();
    }
}
