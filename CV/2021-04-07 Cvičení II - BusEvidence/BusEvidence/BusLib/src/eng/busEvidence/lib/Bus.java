package eng.busEvidence.lib;

import java.util.Comparator;
import java.util.Objects;

public class Bus {

  public static class ByIdComparator implements Comparator<Bus>{
    @Override
    public int compare(Bus a, Bus b) {
      return Integer.compare(a.getId(), b.getId());
    }
  }

  public static class BySpzComparator implements Comparator<Bus>{
    @Override
    public int compare(Bus a, Bus b) {
      return a.getSpz().compareTo(b.getSpz());
    }
  }


  private int id;
  private String spz;
  private int year;

  public Bus(int id, String spz, int year) {
    this.setId(id);
    this.setSpz(spz);
    this.setYear(year);
  }

  public int getId() {
    return id;
  }

  public final void setId(int id) {
    Contracts.isArgumentConditionTrue(id > 0, "id");
    this.id = id;
  }

  public String getSpz() {
    return spz;
  }

  public final void setSpz(String spz) {
    Contracts.isArgumentStringNonEmpty(spz, "spz");
    this.spz = spz;
  }

  public int getYear() {
    return year;
  }

  public final void setYear(int year) {
    Contracts.isArgumentConditionTrue(year > 2000 && year < 2023, "year");
    this.year = year;
  }

  @Override
  public String toString() {
    return "Bus{" +
            "id=" + id +
            ", spz='" + spz + '\'' +
            ", year=" + year +
            '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bus bus = (Bus) o;
    return id == bus.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
