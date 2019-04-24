package todoapp;

import todoapp.Controller.Command;

class TodoApp {

  private Model model;

  TodoApp(String[] args) {
    model = new Model();
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
        Display.listTasks(model.getTasks());
        break;
      case ADD_TASK:
        model.add(param);
        break;
      case REMOVE_TASK:
        model.remove(param);
        break;
      case COMPLETE_TASK:
        model.complete(param);
        break;
      case INVALID_COMMAND:
        break;
    }
  }

}
