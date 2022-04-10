package collegetracker;

public class Lecture extends Activity{
    //fields for just the lecture class - the rest are in activity
    private String description;
    private String link;

    //constructors
    public Lecture(String name, String dueDate, Course course,String description){
        super(name, dueDate,course);
        setDescription(description);
        this.link = null;
    }

    public Lecture(String name, String dueDate, Course course,String description, String link){
        super(name, dueDate,course);
        setDescription(description);
        setLink(link);
    }

    //setters
    public void setDescription(String description) {
        if(description != null){
            this.description = description;
        }else{
            throw new InvalidDataException();
        }
    }

    public void setLink(String link) {
        if(link != null){
            this.link = link;
        }else{
            throw new InvalidDataException();
        }
    }

    //getters
    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    //tostring method that calls activity's tostring
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Lecture \n");
        builder.append(super.toString());
        builder.append("Description: " + this.getDescription() + "\n");
        if(!(this.getLink().equals(null))){
            builder.append("Link " + this.getLink() + "\n");
        }
        return builder.toString();
    }
}
