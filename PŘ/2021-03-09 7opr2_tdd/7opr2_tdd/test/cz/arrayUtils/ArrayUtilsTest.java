package cz.arrayUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ArrayUtilsTest {

  @Test
  public void meanEmptyInput() {
    int[] data = {};
    try {
      ArrayUtils.mean(data);
      fail("This method should throw an exception.");
    } catch (IllegalArgumentException ex) {
    }
  }

  @Test
  public void meanNullInput() {
    int[] data = null;
    try {
      ArrayUtils.mean(data);
      fail("This method should throw an exception.");
    } catch (Exception ex) {
    }
  }

  @Test
  public void meanSimple() {
    int[] data = {1, 2, 3, 4, 5};
    double exp = 3;
    double act = ArrayUtils.mean(data); // 3.0000000000000000001

    assertEquals(exp, act, 0.00001);
  }

  @Test
  public void sumAnotherSimple() {
    int[] data = {1, 2, 3, 4, 5};
    int expectedResult = 15;
    int actualResult = ArrayUtils.sum(data);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void sumSimple() {
    int[] data = {5, 8, 7, 3, 4};
    int expectedResult = 27;
    int actualResult = ArrayUtils.sum(data);

    assertEquals(expectedResult, actualResult);
  }

}
