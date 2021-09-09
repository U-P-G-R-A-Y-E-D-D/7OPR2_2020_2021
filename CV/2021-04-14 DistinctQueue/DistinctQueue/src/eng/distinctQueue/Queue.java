package eng.distinctQueue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
  public enum QueueBehavior {
    EXCEPTION,
    IGNORE
  }

  private final List<T> inner = new ArrayList<>();
  private final QueueBehavior behavior;

  public Queue(QueueBehavior behavior) {
    this.behavior = behavior;
  }

  public void add(T item) {
    if (item == null)
      throw new NullArgumentException("item");

    if (this.contains(item)) {
      if (behavior == QueueBehavior.EXCEPTION) {
        throw new DuplicityItemException(item);
      } else if (behavior == QueueBehavior.IGNORE) {
        return;
      } else {
        throw new IllegalStateException(String.format("Cannot recognize behavior '%s'", behavior));
      }
    } else {
      this.inner.add(item);
    }
  }

  public boolean contains(T item) {
    for (T t : this.inner) {
      if (t.equals(item))
        return true;
    }
    return false;

    // return this.inner.contains(item);
  }

  public T peek() {
    if (this.inner.isEmpty())
      throw new QueueIsEmptyException();

    T ret = this.inner.get(0);
    return ret;
  }

  public T take() {
    if (this.inner.isEmpty())
      throw new QueueIsEmptyException();

    T ret = this.inner.remove(0);
    return ret;
  }
}
