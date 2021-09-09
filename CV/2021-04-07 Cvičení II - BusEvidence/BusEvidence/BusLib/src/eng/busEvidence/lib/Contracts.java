package eng.busEvidence.lib;

public class Contracts {
  public static void isArgumentStringNonEmpty(String value, String argumentName) {
    if (value == null || value.length() == 0)
      throw new IllegalArgumentException(argumentName);
  }

  public static void isArgumentConditionTrue(boolean condition, String argumentName) {
    if (condition == false)
      throw new IllegalArgumentException(argumentName);
  }
}
