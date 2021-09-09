package eng.duplicit;

import java.util.HashSet;
import java.util.Set;

public class DuplicitFile {
  private final String name;
  private final long size;
  private final Set<String> locations = new HashSet<>();

  public DuplicitFile(String name, long size) {
    this.name = name;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public long getSize() {
    return size;
  }

  public Set<String> getLocations() {
    return locations;
  }
}
