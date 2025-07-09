package util;

import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);

    public static String prompt(String message){
        System.out.println(message);
        return scan.nextLine();
    }

    public static int promptInt(String message){
        System.out.println(message);
        int num = scan.nextInt();
        scan.nextLine();
        return num;
    }
}
