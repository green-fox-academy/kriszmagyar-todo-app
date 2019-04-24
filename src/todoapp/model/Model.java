package todoapp.model;

import java.util.List;
import todoapp.Task;

public class Model {

  private FileHandler fileHandler;
  private List<Task> tasks;

  public Model() {
    this.fileHandler = new FileHandler("sdf65sdh");
    this.tasks = this.fileHandler.getTasks();
  }

  public void add(String name) {
    this.tasks.add(new Task(name));
    this.fileHandler.write(this.tasks);
  }

  public void remove(String index) {
    this.tasks.remove(Integer.parseInt(index) - 1);
    this.fileHandler.write(this.tasks);
  }

  public void complete(String index) {
    for (int i = 0; i < this.tasks.size(); i++) {
      if (i + 1 == Integer.parseInt(index)) {
        tasks.get(i).complete();
      }
    }
    this.fileHandler.write(this.tasks);
  }

  public List<Task> getTasks() {
    return this.tasks;
  }
}
