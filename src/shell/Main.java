package shell;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("$ ");

        //User Input...
        Scanner input = new Scanner(System.in);

        //Exit command inside REPL
        while(true)
        {
            String name = input.nextLine();
            if(name.equals("exit"))
            {
                break;
            }
            System.out.println(name + " : command not found");
        }
    }
}
