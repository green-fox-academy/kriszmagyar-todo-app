package todoapp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import todoapp.Controller.Command;

public class ControllerTest {

  private Controller controller;

  @Before
  public void setup() {
    this.controller = new Controller();
  }

  @Test
  public void getCommandReturnsPrintUsageWhenNoParams() {
    assertEquals(Command.PRINT_USAGE, controller.getCommand(new String[]{}));
  }

  @Test
  public void getCommandReturnsListTasksWhenParamIsL() {
    assertEquals(Command.LIST_TASKS, controller.getCommand(new String[]{"-l"}));
  }

  @Test
  public void getCommandReturnsListTasksWhenParamIsList() {
    assertEquals(Command.LIST_TASKS, controller.getCommand(new String[]{"-list"}));
  }

  @Test
  public void getCommandReturnsAddTasksWhenParamIsA() {
    assertEquals(Command.ADD_TASK, controller.getCommand(new String[]{"-a"}));
  }

  @Test
  public void getCommandReturnsAddTasksWhenParamIsAdd() {
    assertEquals(Command.ADD_TASK, controller.getCommand(new String[]{"-add"}));
  }

  @Test
  public void getCommandReturnsRemoveTasksWhenParamIsR() {
    assertEquals(Command.REMOVE_TASK, controller.getCommand(new String[]{"-r"}));
  }

  @Test
  public void getCommandReturnsRemoveTasksWhenParamIsRemove() {
    assertEquals(Command.REMOVE_TASK, controller.getCommand(new String[]{"-remove"}));
  }

  @Test
  public void getCommandReturnsCompleteTasksWhenParamIsC() {
    assertEquals(Command.COMPLETE_TASK, controller.getCommand(new String[]{"-c"}));
  }

  @Test
  public void getCommandReturnsCompleteTasksWhenParamIsComplete() {
    assertEquals(Command.COMPLETE_TASK, controller.getCommand(new String[]{"-complete"}));
  }

  @Test
  public void getCommandReturnsInvalidCommandWhenParamDoesntStartWithLine() {
    assertEquals(Command.INVALID_COMMAND, controller.getCommand(new String[]{"list"}));
  }

  @Test
  public void getCommandReturnsInvalidCommandWhenParamIsInvalid() {
    assertEquals(Command.INVALID_COMMAND, controller.getCommand(new String[]{"-invalid"}));
  }

}