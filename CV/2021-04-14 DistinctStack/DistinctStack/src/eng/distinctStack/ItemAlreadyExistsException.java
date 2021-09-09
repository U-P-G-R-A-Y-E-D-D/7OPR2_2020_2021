package eng.distinctStack;

public class ItemAlreadyExistsException extends RuntimeException {

  public ItemAlreadyExistsException(Object item) {
    super(String.format("Item '%s' already exists.", item));
  }

}
