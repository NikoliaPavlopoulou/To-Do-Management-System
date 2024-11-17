import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        TaskManager task= new TaskManager();
        Scanner scanner = new Scanner(System.in);


        task.addTask("t3", "project1", 5, LocalDate.of(2024,11, 15 ));
        task.addTask( "t1", "project1", 6, LocalDate.of(2024, 11, 15));
        task.addTask( "t2", "project1", 6, LocalDate.of(2024, 11, 16));
        task.addTask( "t5", "project1", 2, LocalDate.of(2024, 12, 05));
        task.addTask( "t6", "project1", 1, LocalDate.of(2024, 11, 15));
        task.addTask( "t0", "project1", 9, LocalDate.of(2024, 11, 25));

        //Gson Lib
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        writeToJsonFile(task, gson);

        while (true){
            System.out.println("\nChoose one of the following options (1,2 or 3): ");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task Status");
            System.out.println("3. View Tasks");
            int option= scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1: {

                    String title = "";
                    while(true){
                        System.out.print("Add Title: ");
                        title = scanner.nextLine();
                        if(title.matches("[0-9]+")){
                            System.out.println("Title must contain at least one letter. Please enter a valid title.");
                        } else {
                            break;
                        }


                    }

                    String description = "";
                    while(true){
                        System.out.print("Add Description: ");
                        description= scanner.nextLine();
                        if(description.matches("[0-9]+")){
                            System.out.println("Description must contain at least one letter. Please enter valid description.");
                        } else {
                            break;
                        }
                    }


                    int priority=0;
                    while(true){
                        System.out.print("Add priority(1-10): ");
                        try {
                            priority = scanner.nextInt();
                            if (priority >= 1 && priority <= 10) {
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println("Priority must be between 1 and 10. Please enter the correct priority: ");
                            }
                        }catch (Exception e){
                            System.out.println("Priority must be a number between 1 and 10. Please enter correct priority: ");
                            scanner.nextLine();
                        }
                    }

                    LocalDate deadline = null;
                    while (deadline == null) {
                        System.out.print("Add deadline (YYYY-MM-DD): ");
                        String deadlineInput = scanner.nextLine();
                        try {
                            deadline = LocalDate.parse(deadlineInput);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD: ");
                        }
                    }

                    task.addTask(title, description, priority, deadline);
                    System.out.println("Task "+title+ " added!");

                    writeToJsonFile(task, gson);
                    break;
                }
                case 2: {
                    System.out.print("Enter task title to update: ");
                    String title = scanner.nextLine();

                    task.updateTaskStatus(title);
                    break;
                }
                case 3: {
                    task.viewTaskList();

                    writeToJsonFile(task, gson);
                    break;
                }

                default:{
                    System.out.println("Wrong selection");}
            }


        }

    }

    public static void writeToJsonFile(TaskManager taskManager, Gson gson) {
        try (FileWriter writer = new FileWriter("tasks.json")) {
            gson.toJson(taskManager, writer);
            System.out.println("Task data saved to tasks.json");
        } catch (IOException e) {
            System.out.println("Error saving to JSON file: " + e.getMessage());
        }
    }
}