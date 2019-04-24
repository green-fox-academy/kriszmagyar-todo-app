package todoapp.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import todoapp.Task;

class FileHandler {

  private static final String ROOT = "assets/";
  private static final String EXTENSION = ".csv";

  private Path path;

  FileHandler(String fileName) {
    this.path = Paths.get(ROOT + fileName + EXTENSION);
  }

  List<Task> initTasks() {
    return processRawData();
  }

  private List<Task> processRawData() {
    List<String> rawData = getRawData();
    List<Task> tasks = new LinkedList<>();

    for (String s : rawData) {
      String[] row = s.split(";");
      String name = getName(row);
      boolean isCompleted = getCompleted(row);
      int importanceLevel = getImportanceLevel(row);
      tasks.add(new Task(name, isCompleted, importanceLevel));
    }

    return tasks;
  }

  private String getName(String[] row) {
    return row[0];
  }

  private boolean getCompleted(String[] row) {
    return Boolean.getBoolean(row[1]);
  }

  private int getImportanceLevel(String[] row) {
    return Integer.parseInt(row[2]);
  }

  private List<String> getRawData() {
    try {
      return Files.readAllLines(this.path);
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }
}
