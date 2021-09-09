package eng.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;

public class DistinctList<T> extends ArrayList<T> {

  private final Equality<T> equality;

  public DistinctList(Equality<T> equality) {
    this.equality = equality;
  }

  @Override
  public boolean add(T item) {
    if (isDuplicit(item))
      return false;
    else
      return super.add(item);
  }

  @Override
  public void add(int index, T item) {
    if (!isDuplicit(item)) {
      super.add(index, item);
    }
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    int previousSize = this.size();
    for (T item : c) {
      this.add(item);
    }
    return this.size() != previousSize;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    int previousSize = this.size();
    for (T item : c) {
      this.add(index++, item);
    }
    return this.size() != previousSize;
  }

  @Override
  public void replaceAll(UnaryOperator<T> operator) {
    List<T> tmp = new ArrayList<>(this);
    tmp.replaceAll(operator);
    this.clear();
    this.addAll(tmp);
  }

  @Override
  public T set(int index, T element) {
    return super.set(index, element);
  }

  private boolean isDuplicit(T item) {
    for (T t : this) {
      if (equality.areEqual(t, item))
        return true;
    }
    return false;
  }
}
