package cz.arrayUtils;

public class ArrayUtils {

  public static int sum(int[] data){
    int ret = 0;
    for (int datum : data) {
      ret += datum;
    }
    return ret;
  }

  public static double mean(int[] data){
    if (data == null)
      throw new IllegalArgumentException("Data array is null.");
    if (data.length == 0)
      throw new IllegalArgumentException("Data array has zero length.");

    return ArrayUtils.sum(data) / data.length;
  }

}
