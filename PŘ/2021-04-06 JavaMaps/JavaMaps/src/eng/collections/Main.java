package eng.collections;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public enum PhoneNumberType {
    HOME,
    OFFICE,
    OTHER
  }

  // wildcards

  private static void printMovies(Set<? extends Movie> movies){
    for (Movie movie : movies) {
      System.out.println(movie.getTitle());
    }
  }

  private static void xa(Set<? super Movie> movies){
  }

  public static void main(String[] args) {

    Set<Movie> movies = new HashSet<>();

    movies.add(new Movie("Matrix"));
    movies.add(new Movie("Alien"));
    movies.add(new Movie("Terminator"));

    printMovies(movies);

    Set<PublishedMovie> publishedMovies = new HashSet<>();
    movies.add(new PublishedMovie("Matrix II", 2000));
    movies.add(new PublishedMovie("Alien II", 1989));
    movies.add(new PublishedMovie("Terminator II", 1987));

    printMovies(publishedMovies);

//    // jméno osoby - doma/práce/venkov - ... telefonní čísla
//
//    Map<String, Map<PhoneNumberType, Set<String>>> phoneNumbers = new HashMap<>();
//
//    if (phoneNumbers.containsKey("Vajgl")== false)
//      phoneNumbers.put("Vajgl", new HashMap<>());
//    if (phoneNumbers.get("Vajgl").containsKey(PhoneNumberType.HOME)== false)
//      phoneNumbers.get("Vajgl").put(PhoneNumberType.HOME, new HashSet<>());
//    phoneNumbers.get("Vajgl").get(PhoneNumberType.HOME).add("+420292392928");
//
//
//    PhoneNumberDataset phd = new PhoneNumberDataset();
//    phd.add("Vajgl", PhoneNumberType.HOME, "+420027402402");
//
//
//    Map<String, Set<String>> peopleMails = new HashMap<>();
//
//    peopleMails.put("Vajgl", new HashSet<>());
//    peopleMails.get("Vajgl").add("marek.vajgl@osu.cz");
//    peopleMails.get("Vajgl").add("marek@seznam.cz");
//
////    peopleMails.put("Vajgl", "marek.vajgl@osu.cz");
////    peopleMails.put("Smolka", "pavel.smolka@osu.cz");
//
//    Set<String> previousEmails = loadPreviousEmailsFromFile();
//    peopleMails.put("Vajgl", previousEmails);
//
//    if (peopleMails.containsKey("Vajgl") == false)
//      peopleMails.put("Vajgl", new HashSet<>());
//    peopleMails.get("Vajgl").add("vajgl@osu.cz");
//
//
//    if (peopleMails.containsKey("Vajgl") == false)
//      peopleMails.put("Vajgl", new HashSet<>());
//    peopleMails.get("Vajgl").add("vajgl@osu.cz");
//
//
//    if (peopleMails.containsKey("Vajgl") == false)
//      peopleMails.put("Vajgl", new HashSet<>());
//    peopleMails.get("Vajgl").add("vajgl@osu.cz");
//
//
//    if (peopleMails.containsKey("Vajgl") == false)
//      peopleMails.put("Vajgl", new HashSet<>());
//    peopleMails.get("Vajgl").add("vajgl@osu.cz");
//
//
//    peopleMails.get("Vajgl").add("vajgl@osu.cz");
//
//
//    for (String key : peopleMails.keySet()) {
//      System.out.println("Osoba " + key + " má e-mail " + peopleMails.get(key));
//    }
//

//    Map<String, Movie> movies = new HashMap<>();
//
//    movies.put("Matrix", new Movie("Matrix"));
//    movies.put("Se7en", new Movie("Se7en"));
//
//    if (movies.containsKey("Matrix")) {
//      Movie m = movies.get("Matrix");
//    }
//
//    Set<String> keys = movies.keySet();
//    for (String key : keys) {
//      Movie value = movies.get(key);
//      System.out.println("Key " + key + ", value " + value);
//    }
//
//    for (Map.Entry<String, Movie> entry : movies.entrySet()) {
//      String key = entry.getKey();
//      Movie value = entry.getValue();
//      System.out.println("Key " + key + ", value " + value);
//    }
//
//    for (Movie value : movies.values()) {
//      System.out.println("Value " + value);
//    }
  }
}


/*

   public Movie getByTitle(String title){

     for(Movie m : this){
       if (title.equals(m.getTitle())
         return m;
     }

   }

 */
