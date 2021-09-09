package eng.fileInfoDecoder;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    String fileName = args[0];
    System.out.println(fileName);

    List<String> lines;
    try {
      lines = java.nio.file.Files.readAllLines(Path.of(fileName));
    } catch (IOException e) {
      System.out.println("Nepodařilo se načíst soubor " + fileName);
      return;
    }

    List<FileInfo> fileInfos = new ArrayList<>();
    for (String line : lines) {
      Optional<FileInfo> fileInfo = analyseLine(line);
      if (fileInfo.isPresent())
        fileInfos.add(fileInfo.get());
    }

    for (FileInfo fileInfo : fileInfos) {
      printFileInfo(fileInfo);
    }
  }

  private static void printFileInfo(FileInfo fileInfo) {
    StringBuilder sb = new StringBuilder();
    sb.append(fileInfo.name)
            .append("\t")
            .append(fileInfo.size)
            .append("\t");
    if (fileInfo.isSystem)
      sb.append("(system)").append("\t");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d. MMMM yyyy, H:mm");
    sb.append(fileInfo.lastWriteTime.format(dtf));

    System.out.println(sb.toString());
  }

  private static Optional<FileInfo> analyseLine(String line) {
    if (line.startsWith("d")) return Optional.empty();

    LocalDateTime lastWriteTime = decodeLastWriteTime(line);
    String name = decodeName(line);
    long size = decodeSize(line);
    boolean isSystem = decodeSystemFlag(line);

    FileInfo fileInfo = new FileInfo(name, size, lastWriteTime, isSystem);
    return Optional.of(fileInfo);
  }

  private static LocalDateTime decodeLastWriteTime(String line) {
    LocalDateTime ret;

    String datePart = line.substring(14, 24);
    String timePart = line.substring(29, 34).trim();

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

    LocalDate localDate = LocalDate.parse(datePart, dateFormatter);
    LocalTime localTime = LocalTime.parse(timePart, timeFormatter);

    ret = LocalDateTime.of(localDate, localTime);
    return ret;
  }

  private static long decodeSize(String line) {
    int endIndex = 49;
    String sizePart = line.substring(0, endIndex);
    int startIndex = sizePart.lastIndexOf(' ');
    sizePart = sizePart.substring(startIndex + 1);

    long ret = Long.parseLong(sizePart);
    return ret;
  }

  private static boolean decodeSystemFlag(String line) {
    boolean ret = line.charAt(4) == 's';
    return ret;
  }

  private static String decodeName(String line) {
    String ret = line.substring(50);
    return ret;
  }
}
