package todoapp.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import todoapp.Task;

class FileHandler implements DataHandler {

  private static final String ROOT = "assets/";
  private static final String EXTENSION = ".csv";
  private static final String DIVIDER = ";";

  private Path path;

  FileHandler(String fileName) {
    this.path = Paths.get(ROOT + fileName + EXTENSION);
  }

  public List<Task> getTasks() {
    return processRawData();
  }

  public void write(List<Task> tasks) {
    List<String> tasksAsString = format(tasks);
    writeToFile(tasksAsString);
  }

  private List<String> format(List<Task> tasks) {
    List<String> formattedTasks = new LinkedList<>();
    for (Task t : tasks) {
      formattedTasks.add(t.toString());
    }
    return formattedTasks;
  }

  private void writeToFile(List<String> tasks) {
    try {
      Files.write(this.path, tasks);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + this.path);
    }
  }

  private List<Task> processRawData() {
    List<String> rawData = getRawData();
    List<Task> tasks = new LinkedList<>();

    for (String s : rawData) {
      String[] row = s.split(DIVIDER);
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
    return Boolean.parseBoolean(row[1]);
  }

  private int getImportanceLevel(String[] row) {
    return Integer.parseInt(row[2]);
  }

  private List<String> getRawData() {
    try {
      return Files.readAllLines(this.path);
    } catch (IOException e) {
      System.out.println("File not found: " + this.path.toAbsolutePath());
      return new ArrayList<>();
    }
  }
}
