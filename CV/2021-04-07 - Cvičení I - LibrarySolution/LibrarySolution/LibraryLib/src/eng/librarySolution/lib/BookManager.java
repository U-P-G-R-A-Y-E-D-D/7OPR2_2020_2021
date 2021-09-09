package eng.librarySolution.lib;

import java.util.*;

public class BookManager {
  private HashMap<String, Set<Book>> data;

  public boolean add(Book book) {
    if (!data.containsKey(book.getAuthor()))
      data.put(book.getAuthor(), new HashSet<>());
//    if (data.get(book.getAuthor()).contains(book))
//      return false;
//    else {
//      data.get(book.getAuthor()).add(book);
//      return true;
//    }
    return data.get(book.getAuthor()).add(book);
  }

  public List<Book> getBooksSortedByTitle(String author) {
    if (!data.containsKey(author)) return new ArrayList<>();

    Set<Book> authorsBooks = data.get(author);
    List<Book> ret = new ArrayList<>(authorsBooks);
    Collections.sort(ret, new Book.ByTitleComparator());
    return ret;
  }

  public List<Book> getBooksSortedByYear(String author) {
    if (!data.containsKey(author)) return new ArrayList<>();

    Set<Book> authorsBooks = data.get(author);
    List<Book> ret = new ArrayList<>(authorsBooks);
    Collections.sort(ret, new Book.ByYearComparator());
    return ret;
  }
}
