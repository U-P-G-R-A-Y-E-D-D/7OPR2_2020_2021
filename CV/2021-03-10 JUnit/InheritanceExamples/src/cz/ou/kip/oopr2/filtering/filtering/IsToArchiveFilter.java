package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.FileInfo;

public class IsToArchiveFilter extends Filter {
  @Override
  public boolean accepts(FileInfo fileInfo) {
    return fileInfo.isArchive();
  }
}
