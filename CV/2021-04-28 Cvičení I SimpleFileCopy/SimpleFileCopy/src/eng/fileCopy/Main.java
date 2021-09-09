package eng.fileCopy;

import java.io.*;

public class Main {

  public static void main(String[] args) {

//      //int size = 1_000_000_000;
//      long size = (long) Math.pow(1024,3);
//
//      try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\temp\\test.dat"))){
//          for (long i = 0; i < size; i++) {
//              byte b = (byte) size;
//              bos.write(b);
//          }
//      } catch (IOException ex){
//          System.out.println("oh, something went wrong");
//      }


    String src = "C:\\temp\\test.dat";
    String trg = "C:\\temp\\test.dot";

    byte[] buffer = new byte[1024];
    long totalSize = new File(src).length();
    long processedSize = 0;
    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(trg));
         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src))) {

      int cnt = bis.read(buffer);
      while (cnt > 0) {
        processedSize+=cnt;
        bos.write(buffer, 0, cnt);
        cnt = bis.read(buffer);
        double prc = processedSize / (double) totalSize * 100;
        System.out.printf("\rdone: %.02f%n", prc);
      }

    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }

  }
}
