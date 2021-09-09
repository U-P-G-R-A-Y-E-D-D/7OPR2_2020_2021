package eng.collections;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Task 2

    List<Person> people = new DistinctList<>((a, b) -> a.getName().equals(b.getName()));
    List<Person> people2 = new DistinctList<>(people, (a, b) -> a == b);
    List<Person> people3 = new DistinctList<>((a, b) -> a.getAge() == b.getAge());

    Person a = new Person("Vajgl", 28);
    people.add(a);

    Person b = new Person("Vajgl", 28);
    people.add(b);


    // Task 1
//    PeopleSet people = new PeopleSet();
//
//    Person a = new Person("Vajgl", 28);
//    people.add(a);
//    people.add(a);
//
//    Person b = new Person("Vajgl", 28);
//    people.add(b);
//
//    Set<Person> family = people.get("Vajgl");
//    family.add(new Person("Bílík", 78));

  }
}

class PersonByNameEquality implements Equality<Person> {

  @Override
  public boolean areEqual(Person a, Person b) {
    return a.getName().equals(b.getName());
  }
}
