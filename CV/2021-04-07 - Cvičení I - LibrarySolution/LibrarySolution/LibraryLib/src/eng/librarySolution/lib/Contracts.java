package eng.librarySolution.lib;

public class Contracts {
  public static void ensureArgumentStringNotNullOrEmpty(String value, String argumentName){
    if (value == null || value.length() == 0)
      throw new IllegalArgumentException(argumentName);
  }

  public static void ensureTrue(boolean condition, String argumentName) {
    if (!condition)
      throw new IllegalArgumentException(argumentName);
  }
}
