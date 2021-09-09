package eng.bigFolders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FolderAnalyzer {
  public static List<FolderSizeInfo> evaluateFolderSizes(String initialFolder) throws IOException {
    List<FolderSizeInfo> ret = new ArrayList<>();

    File folder = new File(initialFolder);
    try {
      processFolder(folder, ret);
    } catch (IOException e) {
      throw new IOException(
              "Failed to evaluate size of the folder '" + initialFolder + "'.",
              e);
    }

    return ret;
  }

  private static void processFolder(File folder, List<FolderSizeInfo> lst) throws IOException {
    File[] items = folder.listFiles(pathname -> pathname.isDirectory());
    checkFileListOk(folder, items);
    for (File item : items) {
      processFolder(item, lst);
    }

    items = folder.listFiles(q -> q.isFile());
    checkFileListOk(folder, items);
    long totalFilesSize = sumTotalFilesSize(items);
    lst.add(new FolderSizeInfo(folder, totalFilesSize));
  }

  private static void checkFileListOk(File folder, File[] items) throws IOException {
    if (items == null) throw new IOException("Failed to list items from " + folder + ".");
  }

  private static long getFileSize(File file) throws IOException {
    long ret = 0;

    try {
      ret = file.length();
      // todel
      throw new RuntimeException("Simulated error.");
    } catch (Exception e) {
      throw new IOException("Exception when accessing file " + file.toString() + ".", e);
    }

    //todel
    //return ret;
  }

  private static long sumTotalFilesSize(File[] files) throws IOException {
    long sum = 0;
    for (File file : files) {
      try {
        sum += file.length();
        // todel
        throw new RuntimeException("Simulated error.");
      } catch (Exception e) {
        throw new IOException("Exception when accessing file " + file.toString() + ".", e);
      }

    }
    return sum;
  }


//  private static void processFolder(File folder, List<FolderSizeInfo> lst) {
//    File[] subfolders = listFolderItems(folder, pathname -> pathname.isDirectory());
//    for (File subfolder : subfolders) {
//      processFolder(subfolder, lst);
//    }
//
//    File[] files = listFolderItems(folder, q -> q.isFile());
//    long size = evaluateSizeOfFiles(files);
//    lst.add(new FolderSizeInfo(folder, sum));
//  }
}


























