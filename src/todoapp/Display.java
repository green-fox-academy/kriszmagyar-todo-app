package todoapp;

import java.util.List;

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

  static void listTasks(List<Task> tasks) {
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + " - " + tasks.get(i).getCompleted() + " " + tasks.get(i).getName());
    }
  }

}
