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
    List<String> data = getData();
    System.out.println(data);
    List<Task> tasks = new LinkedList<>();
    System.out.println("Getting the tasks!");
    return tasks;
  }

  private List<String> getData() {
    try {
      return Files.readAllLines(this.path);
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }
}
