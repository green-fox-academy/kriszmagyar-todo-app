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

}
