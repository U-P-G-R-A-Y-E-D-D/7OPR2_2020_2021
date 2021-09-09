package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.ContractException;
import cz.ou.kip.oopr2.filtering.FileInfo;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MinimalSizeFilterTest {

  @Test
  public void ctorIncorrect(){
    try {
      new MinimalSizeFilter(-100);
      fail();
    } catch (ContractException e) {
    }
  }


  @Test
  public void ctorCorrect(){
    final int minimalSize = 100;
    MinimalSizeFilter f = new MinimalSizeFilter(minimalSize);

    assertEquals(minimalSize, f.minimalSize);
  }

  @Test
  public void acceptsTrue(){
    FileInfo fi = new FileInfo(
            "dokument", "docx", "C:\\temp", 1000,
            LocalDateTime.of(2020,2,12,12,12,12),
            LocalDateTime.of(2020,3, 12, 23, 32, 15),
            false, false, false);
    MinimalSizeFilter filter = new MinimalSizeFilter(1000);
    boolean actual = filter.accepts(fi);

    assertTrue(actual);
  }

  @Test
  public void acceptsFalse(){
    FileInfo fi = new FileInfo(
            "dokument", "docx", "C:\\temp", 999,
            LocalDateTime.of(2020,4,12,12,12,12),
            LocalDateTime.of(2020,3, 12, 23, 32, 15),
            false, false, false);
    MinimalSizeFilter filter = new MinimalSizeFilter(1000);
    boolean actual = filter.accepts(fi);

    assertFalse(actual);
  }

}
