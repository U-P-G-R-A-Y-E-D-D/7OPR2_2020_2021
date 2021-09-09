package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.Contracts;
import cz.ou.kip.oopr2.filtering.FileInfo;

public class MinimalSizeFilter extends Filter {
  public final long minimalSize;

  public MinimalSizeFilter(long minimalSize) {
    Contracts.isTrue(minimalSize >= 0, "Minimal size must be positive integer.");

    this.minimalSize = minimalSize;
  }

  @Override
  public boolean accepts(FileInfo fileInfo) {
    return fileInfo.getSizeInB() >= this.minimalSize;
  }
}
