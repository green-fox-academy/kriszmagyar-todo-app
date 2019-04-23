package todoapp;

import todoapp.Controller.Command;

class TodoApp {

  TodoApp(String[] args) {
    Controller controller = new Controller();
    Command command = controller.getCommand(args);
    String param = controller.getParam(args);
    handleCommand(command);
  }

  private void handleCommand(Command command) {
    switch (command) {
      case PRINT_USAGE:
        System.out.println("Print usage");
        break;
      case LIST_TASKS:
        System.out.println("List tasks");
        break;
      case ADD_TASK:
        System.out.println("Add task");
        break;
      case REMOVE_TASK:
        System.out.println("Remove task");
        break;
      case COMPLETE_TASK:
        System.out.println("Complete task");
        break;
      case INVALID_COMMAND:
        break;
    }
  }

}
