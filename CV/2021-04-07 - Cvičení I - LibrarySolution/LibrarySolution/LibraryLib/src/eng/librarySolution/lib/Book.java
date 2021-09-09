package eng.librarySolution.lib;

import java.util.Comparator;
import java.util.Objects;

public class Book {

  public static class ByTitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
      return a.getTitle().compareTo(b.getTitle());
    }
  }

  public static class ByYearComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
      return Integer.compare(a.getYear(), b.getYear());
    }
  }

  private String author;
  private String title;
  private int year;
  private String isbn;

  public Book(String author, String title, int year, String isbn) {
    this.setAuthor(author);
    this.setTitle(title);
    this.setYear(year);
    this.setIsbn(isbn);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return isbn.equals(book.isbn);
  }

  public String getAuthor() {
    return author;
  }

  public final void setAuthor(String author) {
    Contracts.ensureArgumentStringNotNullOrEmpty(author, "author");
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public final void setIsbn(String isbn) {
    Contracts.ensureArgumentStringNotNullOrEmpty(isbn, "isbn");
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public final void setTitle(String title) {
    Contracts.ensureArgumentStringNotNullOrEmpty(title, "title");
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public final void setYear(int year) {
    Contracts.ensureTrue(year > 1800 && year < 2025, "year");
    this.year = year;
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }

  @Override
  public String toString() {
    return "Book{" +
            "author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", year=" + year +
            ", isbn='" + isbn + '\'' +
            '}';
  }
}
