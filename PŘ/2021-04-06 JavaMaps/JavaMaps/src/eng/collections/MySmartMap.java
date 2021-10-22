package eng.collections;

import java.util.HashMap;

public class MySmartMap<T, V> extends HashMap<T, V> {

  public V get(T key, V defaultNewValue) {
    if (this.containsKey(key) == false){
      this.put(key, defaultNewValue);
    }
    return super.get(key);
  }
}
