package shell;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        REPL(input);

    }

    public static void REPL(Scanner input)
    {
        //implementation the echo builtin inside REPL.
        while(true)
        {
            System.out.print("$ ");
            String name = input.nextLine();

            //would exit the REPL
            if(name.equals("exit"))
            {
                break;
            }

            //Used of echo build-in
            else if(name.contains("echo "))
            {
                System.out.println(name.substring(5));

            }

            //if command is not found & would be inside the REPL loop...
            else
            {
                System.out.println(name + " : command not found");
            }

        }
    }
}
