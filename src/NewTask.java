
public class NewTask {
    private int id;
    private String title;
    private String description;
    private int priority;
    private String deadline;
    private String status;

    private static int idCounter = 1;
    public NewTask(String title, String description, int priority, String deadline, String status){
        this.id = idCounter++;
        this.id=id;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.deadline=deadline;
        this.status=status;

    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {

            this.priority = priority;

    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    @Override
    public String toString(){
        return "Task Id:" +id +"\nTitle: "+ title + "\nDescription: " + description + "\nPriority: "+priority +"\nDeadline: "+deadline+ "\nStatus: " + status+"\n";
    }

}
