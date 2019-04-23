package todoapp;

class Controller {

  Command getCommand(String[] args) {
    try {
      return processCommand(args);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Command.INVALID_COMMAND;
    }
  }

  String getParam(String[] args, Command command) {
    return processParam(args, command);
  }

  private String processParam(String[] args, Command command) {
    switch (command) {
      case PRINT_USAGE:
      case LIST_TASKS:
      case INVALID_COMMAND:
        return "";
      case ADD_TASK:
        return getStringParam(args);
      case REMOVE_TASK:
      case COMPLETE_TASK:
        return getNumberParam(args);
    }
    return "";
  }

  private String getStringParam(String[] args) {
    StringBuilder param = new StringBuilder();
    for (int i = 1; i < args.length; i++) {
      param.append(args[i]).append(" ");
    }
    return param.deleteCharAt(param.length() - 1).toString();
  }

  private String getNumberParam(String[] args) {
    return "30";
  }

  private Command processCommand(String[] args) throws Exception {
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
