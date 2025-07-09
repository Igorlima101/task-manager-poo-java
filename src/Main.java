import model.Task;
import model.User;
import services.TaskServices;
import services.UserServices;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<User> arrayUser = new ArrayList<>();
        ArrayList<Task> arrayTask = new ArrayList<>();
        UserServices.menu(arrayUser, arrayTask);

    }
}