package eng.distinctQueue;

public class NullArgumentException extends IllegalArgumentException{

  public NullArgumentException(String argumentName) {
    super(String.format("Argument '%s' cannot be null.", argumentName));
  }
}
