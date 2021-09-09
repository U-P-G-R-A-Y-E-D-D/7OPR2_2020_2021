package eng.distinctStack;

import java.util.ArrayList;
import java.util.List;

public abstract class Stack<T> {

  private final List<T> data = new ArrayList<>();

  public abstract void put(T item);

  public boolean contains(T item) {
    return data.contains(item);
  }

  public T peek() {
    if (this.data.isEmpty())
      throw new IllegalStateException("Stack is empty.");

    T ret = data.get(data.size() - 1);
    return ret;
  }

  public T pop() {
    if (this.data.isEmpty())
      throw new IllegalStateException("Stack is empty.");

    T ret = data.remove(data.size() - 1);
    return ret;
  }

  protected final void internalPut(T item) {
    if (item == null)
      throw new IllegalArgumentException("Item cannot be null.");

    this.data.add(item);
  }
}
