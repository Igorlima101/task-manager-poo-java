package services;

import model.User;
import util.Input;
import util.UserRole;

import java.util.ArrayList;

public class UserServices {

    public static void createUser(ArrayList<User>arrayUser){
        String name = Input.prompt("Enter a username");
        String description = Input.prompt("Enter a email");
        UserRole role = null;

        System.out.println("1 -- Dev");
        System.out.println("2 -- QA");
        System.out.println("3 -- PO");
        System.out.println("4 -- Scrum Master");
        System.out.println("5 -- Exit");
        int value = Input.promptInt("Choose an a option");

        switch(value){
            case 1 -> role = UserRole.DEV;
            case 2 -> role = UserRole.QA;
            case 3 -> role = UserRole.PO;
            case 4 -> role = UserRole.SCRUM_MASTER;
            case 5 -> System.exit(0);
            default -> System.out.println("Option is invalid");
        }

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
}

