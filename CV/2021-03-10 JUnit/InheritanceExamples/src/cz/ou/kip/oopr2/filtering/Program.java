package cz.ou.kip.oopr2.filtering;

import cz.ou.kip.oopr2.filtering.filtering.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
  public static void main(String[] args) {

    List<FileInfo> files = new ArrayList<>();

    Filter subFilter1 = new AggregationFilter(
            AggregationOperator.AND,
            new ExtensionFilter("jpg"),
            new MinimalSizeFilter(2000));

    Filter subFilter2 = new AggregationFilter(
            AggregationOperator.AND,
            new ExtensionFilter("png"),
            new IsToArchiveFilter());

    Filter filter = new AggregationFilter(
            AggregationOperator.OR, subFilter1, subFilter2);

    List<FileInfo> filteredImages = FilterManager.filterList(files, filter);

  }


}


