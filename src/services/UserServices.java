package services;

import model.Task;
import model.User;
import util.Input;
import util.UserRole;

import java.util.ArrayList;

public class UserServices {

    public static void createUser(ArrayList<User>arrayUser){
        String name = Input.prompt("Enter a username");
        String description = Input.prompt("Enter a email");
        if(name.isEmpty() || description.isEmpty()){
            System.out.println("Error: one or more fields are empty");
            return;
        }

        UserRole role = userRoleOption();
        User user = new User(name, description, role);
        arrayUser.add(user);
    }

    public static void showAllUsers(ArrayList<User> arrayUser){
        for(User user : arrayUser){
            System.out.println(user);
        }
    }

    public static User findUserByName(ArrayList<User>arrayUser){
        String name = Input.prompt("Enter a name to search");
        for(User user: arrayUser){
            if(name.equalsIgnoreCase(user.getName())){
                System.out.println("User found! {" + user.getName() + "}");
                return user;
            }
        }
        return null;
    }

    public static void menu(ArrayList<User>arrayUser, ArrayList<Task> arrayTask){
        while(true){
            System.out.println("1 -- create user");
            System.out.println("2 -- show all users");
            System.out.println("3 -- create task");
            System.out.println("4 -- show all task");
            System.out.println("5 -- change status of task");
            System.out.println("6 -- Exit");
            int input = Input.promptInt("choose an a option");

        switch (input){
            case 1 -> createUser(arrayUser);
            case 2 -> showAllUsers(arrayUser);
            case 3 -> TaskServices.createTask(arrayTask, arrayUser);
            case 4 -> TaskServices.showAllTasks(arrayTask);
            case 5 -> TaskServices.changeStatus(arrayTask);
            case 6 -> {
                System.out.println("Exiting...");
                return;
            }
            default -> System.out.println("Option is invalid");
        }
        }
    }

    public static UserRole userRoleOption(){
        UserRole role = null;
        while(role == null) {
            System.out.println("1 -- Dev");
            System.out.println("2 -- QA");
            System.out.println("3 -- PO");
            System.out.println("4 -- Scrum Master");
            System.out.println("5 -- Exit");
            int value = Input.promptInt("Choose an a option");

            switch (value) {
                case 1 -> {
                    return role = UserRole.DEV;
                }
                case 2 -> {
                    return role = UserRole.QA;
                }
                case 3 -> {
                    return role = UserRole.PO;
                }
                case 4 -> {
                    return role = UserRole.SCRUM_MASTER;
                }
                default -> System.out.println("Option is invalid");
            }
        }
        return null;
    }
}

