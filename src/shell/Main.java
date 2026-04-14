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
        //implementation of echo builtin inside REPL.
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
            else if(name.startsWith("echo"))
            {
                System.out.println(name.substring(5));
            }

            else if(name.startsWith("type "))
            {
                if(name.substring(5).equals("echo") || name.substring(5).equals("exit"))
                {
                    System.out.println( name.substring(5) + " is a shell builtin");
                }
                else
                {
                    System.out.println(name.substring(5) + " : not found ");
                }
            }

            //if command is not found & would be inside the REPL loop...
            else
            {
                System.out.println(name + " : command not found");
            }

        }
    }
}
