package eng.bigFolders;

import java.io.File;
import java.util.Comparator;

public class FolderSizeInfo {

  public static class BySizeDescendingComparator implements Comparator<FolderSizeInfo>{
    @Override
    public int compare(FolderSizeInfo a, FolderSizeInfo b) {
      return -Long.compare(a.size, b.size);
    }
  }

  public final File folder;
  public final long size;

  public FolderSizeInfo(File folder, long size) {
    this.folder = folder;
    this.size = size;
  }
}
