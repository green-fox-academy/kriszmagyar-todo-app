package todoapp;

class Task {

  private String name;
  private boolean isCompleted;

  Task(String name) {
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

  void setCompleted(boolean completed) {
    this.isCompleted = completed;
  }
}
