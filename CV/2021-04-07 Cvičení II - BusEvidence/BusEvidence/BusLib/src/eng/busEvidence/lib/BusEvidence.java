package eng.busEvidence.lib;

import java.util.*;

public class BusEvidence {

  public enum OrderCriterion {
    SPZ,
    ID
  }

  private HashMap<String, Set<Bus>> data;

  public void addByDepartment(String department, Bus bus) {
    Contracts.isArgumentStringNonEmpty(department, "department");
    Contracts.isArgumentConditionTrue(bus != null, "bus");

    if (data.containsKey(department))
      data.put(department, new HashSet<>());
    data.get(department).add(bus);
  }

  public List<Bus> getAllByDepartment(String department, OrderCriterion criterion) {
    Contracts.isArgumentStringNonEmpty(department, "department");

    if (data.containsKey(department) == false)
      return new ArrayList<>();

    Set<Bus> departmentBuses = data.get(department);
    List<Bus> ret = new ArrayList<>(departmentBuses);
    Comparator<Bus> comparator;

    switch (criterion){
      case ID:
        comparator = new Bus.ByIdComparator();
        break;
      case SPZ:
        comparator = new Bus.BySpzComparator();
        break;
      default:
        throw new UnsupportedOperationException();
    }

    Collections.sort(ret, comparator);
    return ret;
  }

  /*

  BusEvidence be = new ....

  List<Bus> buses = be.getAllByDepartment("Poruba", q -> q.getSpz());
  List<Bus> buses = be.getAllByDepartment("Poruba", q -> q.getId());

   */


}
