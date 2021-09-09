package eng.duplicit;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DuplicitFileProvider {

  public static Set<DuplicitFile> findDuplicitFiles(String initialFolder, String fileExtension) throws IOException {
    DuplicitFileProvider dfp = new DuplicitFileProvider();
    try {
      dfp.processFolder(new File(initialFolder), fileExtension.toLowerCase());
    } catch (IOException e) {
      throw new IOException("Failed to find duplicit files over " + initialFolder + " for files " + fileExtension + ".", e);
    }
    dfp.removeNonDuplicitItems();
    return dfp.inner;
  }
  private final Set<DuplicitFile> inner = new HashSet<>();

  private void removeNonDuplicitItems() {
    Set<DuplicitFile> toRem = new HashSet<>();
    for (DuplicitFile item : this.inner) {
      if (item.getLocations().size() == 1)
        toRem.add(item);
    }

    for (DuplicitFile item : toRem) {
      this.inner.remove(item);
    }

    // this.inner.removeIf(q->q.getLocations().size() == 1);
  }

  private void processFolder(File folder, String fileExtension) throws IOException {
    File[] items = folder.listFiles(q -> q.isDirectory());
    if (items == null) raiseIOException(folder);
    for (File item : items) {
      if (item.isDirectory()) processFolder(item, fileExtension);
    }

    items = folder.listFiles(q -> q.getName().toLowerCase().endsWith(fileExtension));
    if (items == null) raiseIOException(folder);
    for (File item : items) {
      processFile(item);
    }
  }

  private void raiseIOException(File folder) throws IOException {
    throw new IOException("Failed to process folder " + folder.toString());
  }

  private void processFile(File item) {
    Optional<DuplicitFile> existingRecord = getExistingRecordForItem(item);
    if (existingRecord.isPresent())
      existingRecord.get().getLocations().add(item.getParent());
    else {
      DuplicitFile df = new DuplicitFile(item.getName().toLowerCase(), item.length());
      df.getLocations().add(item.getParent());
      inner.add(df);
    }
  }

  private Optional<DuplicitFile> getExistingRecordForItem(File item) {
    Optional<DuplicitFile> ret = Optional.empty();

    for (DuplicitFile duplicitFile : inner) {
      if (duplicitFile.getName().equals(item.getName().toLowerCase()) && duplicitFile.getSize() == item.length()) {
        ret = Optional.of(duplicitFile);
        break;
      }
    }

    return ret;
  }
}
