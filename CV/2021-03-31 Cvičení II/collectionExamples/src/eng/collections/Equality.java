package eng.collections;

public interface Equality<T> {
  boolean areEqual(T a, T b);
}

/*

(T a, T b) -> boolean

(a, b) -> a.getName().equals(b.getName());

 */
