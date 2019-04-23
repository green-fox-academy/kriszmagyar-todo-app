package todoapp;

import java.util.LinkedList;
import java.util.List;

class Model {

  private List<Task> tasks;

  Model() {
    this.tasks = new LinkedList<>();
    this.tasks.add(new Task("Walk the dog"));
  }

  public List<Task> getTasks() {
    return this.tasks;
  }
}
