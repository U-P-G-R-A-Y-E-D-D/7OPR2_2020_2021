package eng.duplicit;

import java.io.IOException;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    String folderName = "R:\\";
    String fileExtension = ".java";

    Set<DuplicitFile> result;
    try {
      result = DuplicitFileProvider.findDuplicitFiles(folderName, fileExtension);
    } catch (IOException e) {
      System.out.println("nastala chyba");
      System.out.println(e.getMessage());
      System.out.println(e.getCause().getMessage());
      return;
    }

    for (DuplicitFile duplicitFile : result) {
      System.out.println(duplicitFile.getName() + " [" + duplicitFile.getSize() + "b]");
      for (String location : duplicitFile.getLocations()) {
        System.out.println("\t" + location);
      }
    }
  }
}
