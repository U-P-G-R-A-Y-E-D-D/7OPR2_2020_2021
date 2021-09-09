package cz.ou.kip.oopr2.filtering;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileInfoMockFactory {
  public List<FileInfo> generateFilesSet() {
    List<FileInfo> ret = new ArrayList<>();

    FileInfo fi;

    fi = new FileInfo("test", "txt", "c:\\temp", 2038,
            LocalDateTime.of(2020, 01, 10, 12, 23, 12),
            LocalDateTime.of(2021, 11, 1, 13, 32, 32),
            true, true, false);
    ret.add(fi);

    fi = new FileInfo("other", "mpg", "c:\\temp", 20382312,
            LocalDateTime.of(2021, 3, 10, 12, 2, 12),
            LocalDateTime.of(2021, 7, 5, 11, 2, 32),
            true, true, false);
    ret.add(fi);

    fi = new FileInfo("another", "docx", "c:\\temp", 13123,
            LocalDateTime.of(2018, 5, 5, 12, 23, 28),
            LocalDateTime.of(2020, 4, 3, 8, 29, 12),
            false, false, false);
    ret.add(fi);

    fi = new FileInfo("table", "csv", "c:\\temp", 2038,
            LocalDateTime.of(2020, 01, 10, 12, 23, 12),
            LocalDateTime.of(20201, 11, 1, 13, 32, 32),
            true, true, false);
    ret.add(fi);

    fi = new FileInfo("command", "com", "c:\\", 38271,
            LocalDateTime.of(1989, 5, 13, 11, 18, 48),
            LocalDateTime.of(1989, 5, 13, 11, 18, 58),
            true, true, false);
    ret.add(fi);

    return ret;
  }
}
