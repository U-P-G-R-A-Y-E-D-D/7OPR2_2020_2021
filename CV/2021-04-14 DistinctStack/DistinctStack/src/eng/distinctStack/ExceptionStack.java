package eng.distinctStack;

public class ExceptionStack<T> extends Stack<T> {

  /**
   *
   * @param item
   */
  @Override
  public void put(T item) {
    if (this.contains(item) == false)
      super.internalPut(item);
    else
      throw new ItemAlreadyExistsException(item);
  }
}
