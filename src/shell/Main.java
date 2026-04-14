package shell;

import java.io.File;
import java.nio.file.Path;
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

            //Used of echo built-in
            else if(name.startsWith("echo"))
            {
                System.out.println(name.substring(5));
            }

            //Used of type built-in
            else if(name.startsWith("type "))
            {
                //get command after "type "
                String command = name.substring(5);

                if(command.equals("echo") || command.equals("exit") || command.equals("type"))
                {
                    System.out.println(command + " is a shell builtin");
                }

                //Step 2 : search Path
                else
                {
                    String path = System.getenv("PATH");
                    String[] directories = path.split(":");
                    boolean found = false;

                    //step 3: Loop through folders
                    for(String dir : directories)
                    {
                        //Step 4 : Build full path & check file
                        File file = new File(dir,command);

                        //Step 5 : exits AND executable ?
                        if(file.exists() && file.canExecute())
                        {
                            System.out.println(command + " is " + file.getAbsolutePath());
                            found = true;
                            break;
                        }
                    }

                    //Step 6: After loop
                    if(!found)
                    {
                        System.out.println(command + ": not found");
                    }
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
