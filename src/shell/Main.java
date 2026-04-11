package shell;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("$ ");

        //User Input...
        Scanner input = new Scanner(System.in);

        //REPL
        while(true)
        {
            String name = input.nextLine();
            System.out.println(name + " : command not found");
        }
    }
}
