package eng.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class PeopleSet extends HashSet<Person> {

  private String lastName;
  private Set<Person> lastNameSet;

  public Set<Person> get(String name) { // Set<Person>
    if (lastName != null && lastName.equals(name))
      return new HashSet<>(lastNameSet);

    Set<Person> ret = new HashSet<>();

    for (Person person : this) {
      if (person.getName().equals(name)) {
        ret.add(person);
      }
    }

    lastName = name;
    lastNameSet = new HashSet<>(ret);

    return ret;
  }

  private void resetCache(){
    lastName = null;
    lastNameSet = null;
  }

  @Override
  public void clear() {
    resetCache();
    super.clear();
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    resetCache();
    return super.removeAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends Person> c) {
    resetCache();
    return super.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    resetCache();
    return super.retainAll(c);
  }

  @Override
  public boolean removeIf(Predicate<? super Person> filter) {
    resetCache();
    return super.removeIf(filter);
  }

  @Override
  public boolean add(Person person) {
    resetCache();
    return super.add(person);
  }

  @Override
  public boolean remove(Object o) {
    resetCache();
    return super.remove(o);
  }
}
