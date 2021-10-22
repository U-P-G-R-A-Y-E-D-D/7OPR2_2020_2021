package cz.osu.kip.oopr2.demoSimpleClasses;

public class NumberUtils {
  public static void ensureValueBetween(int minimum, int value, int maximum, String valueName) {
    if (!isValueBetween(minimum, value, maximum))
      throw new RuntimeException("Value '" + valueName + "' should be between " + minimum + " and " + maximum + ".");
  }

  public static boolean isValueBetween(int minimum, int value, int maximum) {
    boolean ret = (value >= minimum && value <= maximum);
    return ret;
  }
}
