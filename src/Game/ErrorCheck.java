package Game;

import java.util.Scanner;

public class ErrorCheck {

    public static int getInt(Scanner sc) {
        while(!sc.hasNextInt()){
            System.out.print("Try again.");
            sc.next();
            sc.nextLine();
        }

        return sc.nextInt(); // add error checking here!
    }
}