package eng.fileInfoDecoder;

import java.time.LocalDateTime;

public class FileInfo {
  public final LocalDateTime lastWriteTime;
  public final String name;
  public final long size;
  public final boolean isSystem;

  public FileInfo( String name, long size, LocalDateTime lastWriteTime,boolean isSystem) {
    this.lastWriteTime = lastWriteTime;
    this.name = name;
    this.size = size;
    this.isSystem = isSystem;
  }
}
