package todoapp;

public class Task {

  private String name;
  private boolean isCompleted;

  public Task(String name) {
    this.name = name;
    this.isCompleted = false;
  }

  String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

  boolean isCompleted() {
    return this.isCompleted;
  }

  String getCompleted() {
    return isCompleted() ? "[X]" : "[ ]";
  }

  public void complete() {
    this.isCompleted = true;
  }

  @Override
  public String toString() {
    return String.format("%s %s", getCompleted(), getName());
  }
}
