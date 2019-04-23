package todoapp;

class Display {

  static void printUsage() {
    System.out.println("Command Line Todo Application");
    System.out.println("=============================\n");
    System.out.println("Command line arguments:");
    System.out.println("-l, -list\t\t\t\t\t\t\t Lists all the tasks");
    System.out.println("-a, -add [task]\t\t\t   Add a new task");
    System.out.println("-r, -remove [index]\t\t Removes a task");
    System.out.println("-c, -complete [index]\t Completes a task");
  }

}
