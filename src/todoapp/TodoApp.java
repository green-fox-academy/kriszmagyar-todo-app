package todoapp;

import todoapp.Controller.Command;

class TodoApp {

  TodoApp(String[] args) {
    Controller controller = new Controller();
    Command command = controller.getCommand(args);
    String param = controller.getParam(args, command);
    handleCommand(command, param);
  }

  private void handleCommand(Command command, String param) {
    switch (command) {
      case PRINT_USAGE:
        Display.printUsage();
        break;
      case LIST_TASKS:
        System.out.println("List tasks");
        break;
      case ADD_TASK:
        System.out.println("Add task: " + param);
        break;
      case REMOVE_TASK:
        System.out.println("Remove task: " + param);
        break;
      case COMPLETE_TASK:
        System.out.println("Complete task: " + param);
        break;
      case INVALID_COMMAND:
        break;
    }
  }

}
