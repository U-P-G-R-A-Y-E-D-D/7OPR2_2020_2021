package eng.bigFolders;

import eng.eSystem.utilites.ExceptionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    String initialFolder = "R:\\";

    List<FolderSizeInfo> result;
    try {
      result = FolderAnalyzer.evaluateFolderSizes(initialFolder);
    } catch (IOException e) {
      System.out.println("V aplikaci nastala chyba. Je nám líto.");
      System.out.println(ExceptionUtils.toFullString(e, "\n"));
      return;
    }

    Collections.sort(result, new FolderSizeInfo.BySizeDescendingComparator());

    // vypsat prvních 10 výsledků
    for (int i = 0; i < Math.min(10, result.size()); i++) {
      FolderSizeInfo fsi = result.get(i);
      System.out.printf("%d.\t%s (%db)%n", i + 1, fsi.folder.toString(), fsi.size);
    }


//    int index = 1;
//    for (FolderSizeInfo folderSizeInfo : result) {
//      ....
//      index++;
//      if (index > 10) break;
//    }

  }
}

/**
 * 1. budu procházet všechny složky (rekurzivně)
 * 2. pro každou složku všechny soubory
 * 2a) pro tu složku sečíst velikost všech souborů
 * 3. dát to do nějaké kolekce všech složek s velikostmi
 * 4. seřadit a vrátit
 */
