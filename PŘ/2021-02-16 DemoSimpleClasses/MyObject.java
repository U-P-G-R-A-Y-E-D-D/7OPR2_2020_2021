package cz.osu.kip.oopr2.demoSimpleClasses;

public class MyObject {

  private static int nextId = 0;
  private final int id;

  public MyObject() {
    MyObject.nextId++;
    this.id = nextId;
  }

  public int getId() {
    return id;
  }
}
