package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.FileInfo;

public class ExtensionFilter extends Filter {
  public final String extension;

  public ExtensionFilter(String extension) {
    this.extension = extension;
  }

  @Override
  public boolean accepts(FileInfo fileInfo) {
    return fileInfo.getExtension().equals(this.extension);
  }
}
