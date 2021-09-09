package eng.distinctStack;

public class IgnoredStack<T> extends Stack<T> {
  @Override
  public void put(T item) {
    if (this.contains(item) == false)
      super.internalPut(item);
  }
}
