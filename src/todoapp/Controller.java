package todoapp;

class Controller {

  Command getCommand(String[] args) {
    try {
      return process(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Command.INVALID_COMMMAND;
    }
  }

  private Command process(String[] args) throws Exception {
    if (args.length == 0) {
      return Command.PRINT_USAGE;
    }

    String command = args[0];
    if (command.charAt(0) != '-') {
      throw new Exception("Command " + command + " is not found!");
    }

    if (command.equals("-l") || command.equals("-list")) {
      return Command.LIST_TASKS;
    }

    return Command.INVALID_COMMMAND;
  }

  enum Command {
    PRINT_USAGE, LIST_TASKS, ADD_TASK, REMOVE_TASK, COMPLETE_TASK, INVALID_COMMMAND
  }

}
