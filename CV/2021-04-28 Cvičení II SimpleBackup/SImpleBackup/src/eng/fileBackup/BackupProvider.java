package eng.fileBackup;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class BackupProvider {
  private static File[] listFileFiles(File file, FileFilter fileFilter) {
    File[] ret = file.listFiles(fileFilter);
    if (ret == null)
      throw new RuntimeException("Unable to read content of " + file);
    return ret;
  }

  public void doBackup(String src, String trg) {
    File srcFile = new File(src);
    if (!srcFile.exists() || !srcFile.isDirectory())
      throw new IllegalArgumentException("Path " + src + " does not exist.");

    File trgFile = new File(trg);
    if (trgFile.exists() && trgFile.isDirectory() == false)
      throw new IllegalArgumentException("Path " + src + " is not a folder.");

    backupFolderFiles(srcFile, trgFile);
    backupFolderFolders(srcFile, trgFile);
  }

  private void backupFolderFolders(File srcFile, File trgFile) {
    File[] srcFiles = listFileFiles(srcFile, f -> f.isDirectory());

    for (File srcSubFile : srcFiles) {
      Path sourceSubPath = srcSubFile.toPath();
      Path targetSubPath = trgFile.toPath().resolve(srcSubFile.getName());

      backupFolderFiles(sourceSubPath.toFile(), targetSubPath.toFile());
    }
  }

  private void backupFolderFiles(File srcFile, File trgFile) {
    if (!trgFile.exists())
      trgFile.mkdirs();

    File[] srcFiles = listFileFiles(srcFile, f -> f.isFile());
    File[] trgFiles = listFileFiles(trgFile, f -> f.isFile());

    for (int srcIndex = 0; srcIndex < srcFiles.length; srcIndex++) {
      System.out.print("Checking file " + srcFiles[srcIndex]);

      boolean isBackupNeeded = checkFileNeedsToBeBackedUp(srcFiles, trgFiles, srcIndex);

      System.out.println("\t" + (isBackupNeeded ? "will be backed-up." : "no backup necessary"));

      if (isBackupNeeded) {
        copyFile(trgFile, srcFiles[srcIndex]);
      }
    }

  }

  private void copyFile(File trgFile, File srcFile1) {
    Path srcFilePath = srcFile1.toPath();
    Path trgFilePath = trgFile.toPath().resolve(srcFilePath.getFileName()); //Paths.get(trg, srcFilePath.getFileName().toString());
    try {
      java.nio.file.Files.copy(srcFilePath, trgFilePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException(String.format("Failed to copy '%s' to '%s'.", srcFilePath, trgFilePath), e);
    }
  }

  private boolean checkFileNeedsToBeBackedUp(File[] srcFiles, File[] trgFiles, int srcIndex) {
    boolean isBackupNeeded;
    int trgIndex = tryGetTargetFileIndex(trgFiles, srcFiles[srcIndex]);
    isBackupNeeded = trgIndex < 0;
    if (!isBackupNeeded) {
      isBackupNeeded = srcFiles[srcIndex].length() != trgFiles[trgIndex].length();
      if (!isBackupNeeded) {
        isBackupNeeded = !hasBothFilesTheSameContent(srcFiles[srcIndex], trgFiles[trgIndex]);
      }
    }
    return isBackupNeeded;
  }

  private boolean hasBothFilesTheSameContent(File a, File b) {
    assert a.length() == b.length();
    Boolean ret = null;

    try (BufferedInputStream bisa = new BufferedInputStream(new FileInputStream(a));
         BufferedInputStream bisb = new BufferedInputStream(new FileInputStream(b))) {

      byte[] dataA = new byte[1024];
      byte[] dataB = new byte[1024];

      while (ret == null) {
        int dataLenA = bisa.read(dataA);
        int dataLenB = bisb.read(dataB);
        assert dataLenB == dataLenA;

        if (dataLenA < 0)
          ret = true;
        else if (Arrays.equals(dataA, 0, dataLenA, dataB, 0, dataLenA) == false) {
          ret = false;
        }
      }

    } catch (IOException ex) {
      throw new RuntimeException(String.format("Error comparing '%s' with '%s'.", a, b), ex);
    }

    assert ret != null;
    return ret;
  }

  private int tryGetTargetFileIndex(File[] trgFiles, File srcFile) {
    int ret = -1;

    String srcFileName = srcFile.getName();
    for (int i = 0; i < trgFiles.length; i++) {
      if (trgFiles[i].getName().equals(srcFileName)) {
        ret = i;
        break;
      }
    }

    return ret;
  }
}
