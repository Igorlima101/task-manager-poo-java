package services;

import model.Task;
import model.User;
import util.Input;
import util.TaskMark;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskServices {

    public static void createTask(ArrayList<Task> arrayTask, ArrayList<User> arrayUser){
        String title = Input.prompt("Enter a task title");
        String description = Input.prompt("Enter a task description");
        if(title.isEmpty() || description.isEmpty()){
            System.out.println("Error: one or more fields are empty");
            return;
        }

        TaskMark mark = menuStatusChoose();
        User user = UserServices.findUserByName(arrayUser);
        if(user == null){
            System.out.println("Error: user is null");
            return;
        }

        Task task = new Task(user, title, description, LocalDateTime.now(), mark);
        arrayTask.add(task);
    }

    public static void showAllTasks(ArrayList<Task> arrayTask){
        for(Task task: arrayTask){
            System.out.println(task);
        }
    }

    public static void changeStatus(ArrayList<Task> arrayTask){
        String title = Input.prompt("Enter a task to change status");
        for(Task task: arrayTask){
            if(title.equalsIgnoreCase(task.getTitle())){
                task.setTaskMark(menuStatusChoose());
                return;
            }
        }
        System.out.println("Error: Task not found");
    }

    public static TaskMark menuStatusChoose(){
        TaskMark taskMark = null;
        while(taskMark == null) {
            System.out.println("1 -- Completed");
            System.out.println("2 -- In progress");
            System.out.println("3 -- Pending");
            int value = Input.promptInt("Choose an a option");

            switch (value) {
                case 1 -> {
                    return taskMark = TaskMark.COMPLETED;
                }
                case 2 -> {
                    return taskMark = TaskMark.IN_PROGRESS;
                }
                case 3 -> {
                    return taskMark = TaskMark.PENDING;
                }
                default -> System.out.println("Option is invalid");
            }
        }
        return null;
    }


}
