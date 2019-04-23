package todoapp;

class Controller {

  Command getCommand(String[] args) {
    try {
      return process(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Command.INVALID_COMMAND;
    }
  }

  String getParam(String[] args) {
    return "param";
  }

  private Command process(String[] args) throws Exception {
    if (isNoCommands(args)) {
      return Command.PRINT_USAGE;
    }

    String command = args[0];
    if (isInvalidStart(command)) {
      throw new Exception("Commands must start with '-'!");
    }

    if (isListTasks(command)) {
      return Command.LIST_TASKS;
    }
    if (isAddTask(command)) {
      return Command.ADD_TASK;
    }
    if (isRemoveTask(command)) {
      return Command.REMOVE_TASK;
    }
    if (isCompleteTask(command)) {
      return Command.COMPLETE_TASK;
    }

    throw new Exception("Command '" + command + "' is invalid.");
  }

  private boolean isNoCommands(String[] args) {
    return args.length == 0;
  }

  private boolean isInvalidStart(String command) {
    return command.charAt(0) != '-';
  }

  private boolean isListTasks(String command) {
    return command.equals("-l") || command.equals("-list");
  }

  private boolean isAddTask(String command) {
    return command.equals("-a") || command.equals("-add");
  }

  private boolean isRemoveTask(String command) {
    return command.equals("-r") || command.equals("-remove");
  }

  private boolean isCompleteTask(String command) {
    return command.equals("-c") || command.equals("-complete");
  }

  enum Command {
    PRINT_USAGE, LIST_TASKS, ADD_TASK, REMOVE_TASK, COMPLETE_TASK, INVALID_COMMAND
  }

}
