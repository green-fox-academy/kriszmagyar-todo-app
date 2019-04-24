package todoapp.model;

import java.util.LinkedList;
import java.util.List;
import todoapp.Task;

public class Model {

  private FileHandler fileHandler;
  private List<Task> tasks;

  public Model() {
    this.fileHandler = new FileHandler("sdf65sdh");
    this.tasks = this.fileHandler.initTasks();
  }

  public void add(String name) {
    this.tasks.add(new Task(name));
  }

  public void remove(String index) {
    this.tasks.remove(Integer.parseInt(index) - 1);
  }

  public void complete(String index) {
    for (int i = 0; i < this.tasks.size(); i++) {
      if (i + 1 == Integer.parseInt(index)) {
        tasks.get(i).complete();
      }
    }
  }

  public List<Task> getTasks() {
    return this.tasks;
  }
}
