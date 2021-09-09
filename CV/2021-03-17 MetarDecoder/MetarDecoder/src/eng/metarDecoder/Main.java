package eng.metarDecoder;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    List<String> lines = java.nio.file.Files.readAllLines(Paths.get("R:\\lkmt.txt"));

    for (String line : lines) {
      processLine(line);
    }
  }

  private static void processLine(String line) {

    LocalDateTime ldt = decodeDateTime(line);

    Integer[] wind = decodeWind(line);

    DateTimeFormatter df = DateTimeFormatter.ofPattern("d. MMMM yyyy");
    DateTimeFormatter tf = DateTimeFormatter.ofPattern("H:mm:ss");

    System.out.println(ldt.format(df) + " // " + ldt.format(tf) + " /// ");
    for (Integer integer : wind) {
      System.out.println("\t" + integer);
    }

  }

  private static Integer[] decodeWind(String line) {
    int index = line.indexOf("KT");
    int startIndex = line.substring(0, index).lastIndexOf(" ");
    String tmp = line.substring(startIndex+1, index);

    String hdgS = tmp.substring(0, 3);
    String spdS = tmp.substring(3, 5);
    String gstS = tmp.length() > 5 ? tmp.substring(5, 7) : null;

    int hdg = Integer.parseInt(hdgS);
    int spd = Integer.parseInt(spdS);
    Integer gst = gstS != null ? Integer.parseInt(gstS) : null;

    Integer[] ret = new Integer[]{hdg, spd, gst};

    return ret;
  }

  private static LocalDateTime decodeDateTime(String line) {
    String pt = line.substring(0, 12);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    LocalDateTime ldt = LocalDateTime.parse(pt, dtf);
    return ldt;
  }
}
