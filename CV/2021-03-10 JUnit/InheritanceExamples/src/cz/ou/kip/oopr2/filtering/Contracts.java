package cz.ou.kip.oopr2.filtering;

public class Contracts {
  public static void isNotNull(Object obj, String message) {
    if (obj == null) {
      throw new ContractException(message);
    }
  }

  public static void isNotNull(Object obj) {
    Contracts.isNotNull(obj, "Object is null.");
  }

  public static void isTrue(boolean value, String message) {
    if (!value)
      throw new ContractException(message);
  }

  public static void isTrue(boolean value) {
    Contracts.isTrue(value, "Contract was not fulfilled.");
  }
}
