package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.FileInfo;

public class AggregationFilter extends Filter {
  private final AggregationOperator operator;
  private final Filter[] filters;

  public AggregationFilter(AggregationOperator operator, Filter... filters) {
    this.operator = operator;
    this.filters = filters;
  }

  @Override
  public boolean accepts(FileInfo fileInfo) {
    switch (operator) {
      case AND:
        return acceptsViaAnd(fileInfo);
      case OR:
        return acceptsViaOr(fileInfo);
      default:
        throw new UnsupportedOperationException();
    }
  }

  private boolean acceptsViaOr(FileInfo fileInfo) {
    for (Filter filter : filters) {
      if (filter.accepts(fileInfo) == true)
        return true;
    }
    return false;
  }

  private boolean acceptsViaAnd(FileInfo fileInfo) {
    for (Filter filter : filters) {
      if (filter.accepts(fileInfo) == false)
        return false;
    }
    return true;
  }
}
