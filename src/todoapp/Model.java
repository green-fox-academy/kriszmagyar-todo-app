package todoapp;

import java.util.LinkedList;
import java.util.List;

class Model {

  private List<Task> tasks;

  Model() {
    this.tasks = new LinkedList<>();
    this.tasks.add(new Task("Walk the dog"));
  }

  List<Task> add(String name) {
    this.tasks.add(new Task(name));
    return getTasks();
  }

  List<Task> remove(String index) {
    this.tasks.remove(Integer.parseInt(index) - 1);
    return getTasks();
  }

  List<Task> complete(String index) {
    System.out.println("Complete: " + index);
    return getTasks();
  }

  List<Task> getTasks() {
    return this.tasks;
  }
}
