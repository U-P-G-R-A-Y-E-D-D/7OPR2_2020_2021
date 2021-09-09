package cz.ou.kip.oopr2.filtering.filtering;

import cz.ou.kip.oopr2.filtering.FileInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class Filter {
  public abstract boolean accepts(FileInfo fileInfo);
}
