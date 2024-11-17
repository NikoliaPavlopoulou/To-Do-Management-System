
import java.time.LocalDate;

import java.util.*;

public class TaskManager {
    private List<NewTask> tasks;



    public TaskManager(){
        this.tasks=new ArrayList<>();

    }

    public void addTask(String title, String description, int priority, LocalDate deadline){
        String deadlineStr = deadline.toString();
        NewTask task = new NewTask(title, description, priority, deadlineStr, "Pending");
        tasks.add(task);

    }


    public void updateTaskStatus(String title){

        for (NewTask task : tasks) {
            if (task.getTitle().equals(title)) {
                if ("Completed".equals(task.getStatus())) {
                    System.out.println("Task \"" + title + "\" is already completed. No update needed.");
                } else {
                    task.setStatus("Completed");
                    System.out.println("Task \"" + title + "\" status updated to 'Completed'.");
                }
                return;
            }
        }
        System.out.println("Task not found with title: " + title);

    }

    public void viewTaskList(){

        if(tasks.isEmpty()){
            System.out.println("No tasks imported");
        }
        else {
            for(int i =0; i<tasks.size();i++){
                for(int j=0;j<tasks.size()-1 -i; j++){
                    NewTask t1 = tasks.get(j);
                    NewTask t2 = tasks.get(j+1);
                    if(t1.getPriority()<t2.getPriority()){
                        tasks.set(j,t2);
                        tasks.set(j+1, t1);
                    }
                    else if(t1.getPriority()==t2.getPriority()){
                        if(t1.getDeadline().compareTo(t2.getDeadline())>0){
                            tasks.set(j,t2);
                            tasks.set(j+1, t1);
                        }
                    }

                }

            }
            for (NewTask task : tasks) {



                System.out.println(task);
           }
        }
    }
    public boolean getExistingTitle(String inputTitle) {
        boolean exists=false;
        for (NewTask task : tasks) {

            if(inputTitle.equals(task.getTitle())){
                exists=true;

            }
        }
        return exists;
    }


}
