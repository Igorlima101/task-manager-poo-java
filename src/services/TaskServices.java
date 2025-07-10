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
            System.out.println("Error, one or more fields are empty");
            return;
        }
        TaskMark taskMark = null;

        System.out.println("1 -- Completed");
        System.out.println("2 -- In progress");
        System.out.println("3 -- Pending");
        System.out.println("4 -- back to menu");
        int value = Input.promptInt("Choose an a option");

        switch(value){
            case 1 -> taskMark = TaskMark.COMPLETED;
            case 2 -> taskMark = TaskMark.IN_PROGRESS;
            case 3 -> taskMark = TaskMark.PENDING;
            case 4 -> UserServices.menu(arrayUser, arrayTask);
            default -> System.out.println("Option is invalid");
        }

        User user = UserServices.findUserByName(arrayUser);
        if(user == null){
            System.out.println("Error, user is null");
            return;
        }

        Task task = new Task(user, title, description, LocalDateTime.now(), taskMark);
        arrayTask.add(task);
    }

    public static void showAllTasks(ArrayList<Task> arrayTask){
        for(Task task: arrayTask){
            System.out.println(task);
        }
    }


}
