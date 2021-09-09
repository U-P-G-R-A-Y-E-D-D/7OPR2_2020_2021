package eng.collections;

public interface Equality<V> {
  boolean areEqual(V a, V b);
}

/*
a ,b -> boolean

(a, b) -> a.getTitle().equals(b.getTitle())
 */
