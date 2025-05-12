# MiniShell

## Project Overview
MiniShell is a Java-based command-line interface that simulates basic shell functionality. It provides a simplified implementation of common shell commands for file system navigation and manipulation.

## Features
The application offers the following commands:
- `pwd`: Print Working Directory - displays the current directory path
- `ls`: List - shows all files and directories in the current location
- `cd [directory_name]`: Change Directory - navigates to the specified directory
- `mkdir [directory_name]`: Make Directory - creates a new directory
- `touch/create [file_name]`: Create File - creates a new empty file
- `help`: Help - displays available commands and their descriptions
- `exit`: Exit - terminates the application

## Project Structure
The project consists of two main classes:
1. **MiniShell.java**: The main application entry point that handles user input and orchestrates command execution
2. **ShellCommandHandler.java**: A utility class that implements the actual functionality of each command

## Implementation Details

### ShellCommandHandler Class
This class manages the current working directory state and implements all command functionality:

- **Constructor**: Initializes the current directory to the user's working directory
- **printWorkingDirectory()**: Displays the absolute path of the current directory
- **listDirectory()**: Shows all files and directories in the current location with appropriate labels
- **changeDirectory(String name)**: Changes the current directory to the specified location
- **makeDirectory(String name)**: Creates a new directory in the current location
- **createFile(String name)**: Creates a new empty file in the current location
- **printHelp()**: Displays help information for all available commands
- **getCurrentDirectory()**: Returns the current directory as a File object

### MiniShell Class
The main class that:
1. Creates instances of Scanner for input and ShellCommandHandler for command execution
2. Displays a welcome message
3. Implements a command loop that:
   - Shows the command prompt with the current directory
   - Reads user input
   - Parses the command and its arguments
   - Calls the appropriate method from ShellCommandHandler
   - Terminates when the user types "exit"

## How to Run
1. Compile both Java files:
   ```
   javac ShellCommandHandler.java
   javac MiniShell.java
   ```
2. Run the MiniShell class:
   ```
   java MiniShell
   ```

## Sample Usage
```
Welcome to MiniShell! Type 'help' for a list of commands.
/home/user > help
Available commands:
pwd            - Show current directory
ls             - List files and folders
cd [name]      - Change directory
mkdir [name]   - Create a new directory
create [name]  - Create a new file
help           - Show this help message
exit           - Exit the shell
/home/user > pwd
/home/user
/home/user > mkdir test_folder
Directory created: test_folder
/home/user > ls
[DIR]   test_folder
[FILE]   MiniShell.java
[FILE]   ShellCommandHandler.java
/home/user > cd test_folder
/home/user/test_folder > touch new_file.txt
File created: new_file.txt
/home/user/test_folder > ls
[FILE]   new_file.txt
/home/user/test_folder > cd ..
/home/user > exit
Goodbye!
```

## Error Handling
The application includes basic error handling for common scenarios:
- Directory not found when using `cd`
- Directory already exists when using `mkdir`
- File already exists when using `touch/create`
- Invalid command syntax

## Limitations
- No support for advanced shell features like pipes, redirection, or environment variables
- Limited to basic file system operations
- No file content manipulation (only file creation)
- Limited error handling for complex edge cases

## Future Improvements
- Add file content reading and writing capabilities
- Implement command history navigation
- Add support for wildcards in file operations
- Implement tab completion for file and directory names
- Add more advanced file system commands (copy, move, delete)
