package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.ContractException;
import cz.ou.kip.oopr2.filtering.FileInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilterManagerTest {
  @Test
  public void filterListForEmptyItems() {
    List<FileInfo> items = new ArrayList<>();
    List<FileInfo> actualResult;

    actualResult = FilterManager.filterList(items, new ExtensionFilter("jpg"));

    assertEquals(0, actualResult.size());
  }

  @Test
  public void filterListForNullFilter() {
    try {
      FilterManager.filterList(new ArrayList<>(), null);
      fail();
    } catch (ContractException e) {
    }
  }

  @Test
  public void filterListForNullItems() {
    try {
      FilterManager.filterList(null, new ExtensionFilter("jpg"));
      fail();
    } catch (ContractException e) {
    }
  }

}
