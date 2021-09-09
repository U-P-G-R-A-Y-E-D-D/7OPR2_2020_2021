package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.Contracts;
import cz.ou.kip.oopr2.filtering.FileInfo;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

public class FilterManager {

  public static List<FileInfo> filterList( List<FileInfo> items, Filter filter) {
  Contracts.isNotNull(items, "Argument 'items'");
  Contracts.isNotNull(filter, "Argument 'filter'");

//    if (items == null) throw new IllegalArgumentException("Items are null.");
//    if (filter == null) throw new IllegalArgumentException("Filter is null");

    List<FileInfo> ret = new ArrayList<>();
    for (FileInfo file : items) {
      if (filter.accepts(file))
        ret.add(file);
    }

    Contracts.isNotNull(ret);
    return ret;
  }
}
