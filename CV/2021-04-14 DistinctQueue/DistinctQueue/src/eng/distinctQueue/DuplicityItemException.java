package eng.distinctQueue;

public class DuplicityItemException extends RuntimeException {
  public DuplicityItemException(Object item) {
    super(String.format("Object '%s' is duplicit.", item));
  }
}
