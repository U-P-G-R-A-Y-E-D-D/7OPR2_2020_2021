package eng.collections;

import java.util.ArrayList;
import java.util.Collection;

public class DistinctList<T> extends ArrayList<T> {

  private final Equality<T> equality;

  public DistinctList(Collection<? extends T> c, Equality<T> equality) {
    super(c);
    this.equality = equality;
  }

  public DistinctList(Equality<T> equality) {
    this.equality = equality;
  }

  @Override
  public boolean add(T item) {
    if (existInList(item))
      return false;
    else {
      super.add(item);
      return true;
    }
  }

  @Override
  public void add(int index, T item) {
    if (!existInList(item)) {
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
  public T set(int index, T person) {
    if (existInList(person))
      return this.get(index);
    else
      return super.set(index, person);
  }

  private boolean existInList(T item) {
    for (T t : this) {
      if (this.equality.areEqual(t, item))
        return true;
    }
    return false;
  }
}


// t implementuje interface, který bude mít "getName()"
