package eng.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortedList<T extends Comparable<T>> extends ArrayList<T> {

  @Override
  public boolean add(T t) {
    boolean ret = super.add(t);
    Collections.sort(this);
    return ret;
  }
}
