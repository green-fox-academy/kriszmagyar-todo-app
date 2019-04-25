package todoapp.model;

import java.util.List;
import todoapp.Task;

interface DataHandler {
  List<Task> getTasks();
  void write(List<Task> tasks);
}
