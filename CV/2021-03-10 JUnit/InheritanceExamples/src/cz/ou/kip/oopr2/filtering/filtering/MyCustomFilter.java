package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.FileInfo;

public class MyCustomFilter extends Filter {

  @Override
  public boolean accepts(FileInfo fileInfo) {
    return fileInfo.getExtension().equals("jpg") && fileInfo.getSizeInB() > 1000;
  }
}
