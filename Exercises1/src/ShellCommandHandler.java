
import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {

        this.currentDirectory=new File(System.getProperty("user.dir"));


        // TODO: Initialize currentDirectory to the user's current working directory
        // Hint: Use System.getProperty("user.dir")
    }
    //------------------------------------
    public void printWorkingDirectory() {
        System.out.println(currentDirectory.getAbsolutePath());


        // TODO: Print the absolute path of the current directory
    }
    //------------------------------------

    public void listDirectory() {
        File[] files = currentDirectory.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (file.isDirectory() == true) {
                System.out.println("[DIR]   " + file.getName());
            } else if (file.isFile() == true) {
                System.out.println("[FILE]   " + file.getName());

            }else {
                System.out.println("No files her");
            }
        }



        // TODO: List all files and directories in the current directory
        // For directories, prefix with "[DIR] "
        // For files, prefix with "[FILE]"
    }
    //------------------------------------------------

    public void changeDirectory(String name) {

        if (name==null){
            System.out.println("Usage: cd [directory_name]");
            return;
        }
        if (name.equals("..")) {
            File main = currentDirectory.getParentFile();

            if (main != null) {
                currentDirectory = main;
            } else {
                System.out.println("error");
            }
            return;
        }

            File newDir = new File(currentDirectory, name);
            if (newDir.exists() && newDir.isDirectory()) {
                currentDirectory = newDir;
            } else {
                System.out.println("Directory not found: " + name);
            }



        // TODO: Implement the change directory command
        // If name is null, show usage message: "Usage: cd [directory_name]"
        // If name is "..", move to parent directory if possible
        // Otherwise, try to move to the specified directory
        // If directory doesn't exist, print error message: "Directory not found: [name]"


    }

    //---------------------------------------------

    public void makeDirectory(String name) {
        if (name==null){
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }

        File newDir = new File(currentDirectory, name);
        if (newDir.exists()) {
            System.out.println("Directory already exists.");
            return;
        }
        boolean created = newDir.mkdir();
        if (created==true) {
            System.out.println("Directory created: " + name);
        } else {
            System.out.println("Failed to create directory.");
        }







        // TODO: Implement the make directory command
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        // If directory already exists, print: "Directory already exists."
        // If directory creation is successful, print: "Directory created: [name]"
        // If directory creation fails, print: "Failed to create directory."
    }
    //------------------------------------------------------

    public void createFile(String name) {
        if (name == null) {
            System.out.println("Usage: touch [file_name]");
            return;
        }


        File newFile = new File(currentDirectory, name);



        if (newFile.exists()) {
            System.out.println("File already exists.");
            return;
        }

        try {


            boolean created = newFile.createNewFile();

            if (created) {
                System.out.println("File created: " + name);
            } else {
                System.out.println("Failed to create file: " + name);
            }
        }catch (IOException e){
            System.out.println("Error creating file: " + e.getMessage());
        }

    }




        // TODO: Implement the create file command
        // If name is null, show usage message: "Usage: touch [file_name]"
        // If file already exists, print: "File already exists."
        // If file creation is successful, print: "File created: [name]"
        // If file creation fails, print error message with exception details

    //---------------------------------------------------------------

    public void printHelp() {

        System.out.println("Available commands:");
        System.out.println("pwd            - Show current directory");
        System.out.println("ls             - List files and folders");
        System.out.println("cd [name]      - Change directory");
        System.out.println("mkdir [name]   - Create a new directory");
        System.out.println("create [name]  - Create a new file");
        System.out.println("help           - Show this help message");
        System.out.println("exit           - Exit the shell");


        // TODO: Implement help command to print information about all available commands
        // List all commands with their descriptions
    }

    //-----------------------------------------------------------------


    public File getCurrentDirectory() {

        return currentDirectory;

        // TODO: Return the current directory
       // return null; // Replace this with your implementation
    }

    //---------------------------------------


}
