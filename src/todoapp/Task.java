package todoapp;

class Task {

  private String name;
  private boolean isCompleted;

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  boolean isCompleted() {
    return isCompleted;
  }

  String getCompleted() {
    return isCompleted() ? "[X]" : "[ ]";
  }

  void setCompleted(boolean completed) {
    isCompleted = completed;
  }
}
