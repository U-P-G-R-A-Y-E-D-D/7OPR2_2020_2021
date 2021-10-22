package cz.arrayUtils;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationPlateTest {

  @Test
  public void ctorCreateEmpty() {
    try {
      RegistrationPlate plate = new RegistrationPlate("");
      fail();
    } catch (IllegalArgumentException ex) {
    }
  }

  @Test
  public void ctorCreateNull() {
    try {
      RegistrationPlate plate = new RegistrationPlate(null);
      fail();
    } catch (IllegalArgumentException ex) {
    }
  }

  @Test
  public void ctorSimple() {
    String expectedValue = "1T1 1111";
    RegistrationPlate plate = new RegistrationPlate(expectedValue);
    String actualValue = plate.getValue();

    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void equalsSimple(){
    RegistrationPlate a = new RegistrationPlate("1T1 1111");
    RegistrationPlate b = new RegistrationPlate("1T1 1111");

    assertFalse(a == b);
    assertTrue(a.equals(b));
  }

  @Test
  public void equalsOtherSimple(){
    String s = "1T1 1111";
    RegistrationPlate a = new RegistrationPlate(s);
    RegistrationPlate b = new RegistrationPlate(s);

    assertFalse(a == b);
    assertTrue(a.equals(b));
  }


}
