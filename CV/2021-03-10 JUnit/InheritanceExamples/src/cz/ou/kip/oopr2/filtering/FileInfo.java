package cz.ou.kip.oopr2.filtering;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileInfo {
  private String nameWithoutExtension;
  private String extension;
  private String fullDirectory;
  private long sizeInB;
  private LocalDateTime creationDateTime;
  private LocalDateTime lastAccessDateTime;
  private boolean isReadOnly;
  private boolean isSystem;
  private boolean isArchive;

  public FileInfo() {
  }

  public FileInfo(String nameWithoutExtension, String extension, String fullDirectory, long sizeInB, LocalDateTime creationDateTime, LocalDateTime lastAccessDateTime, boolean isReadOnly, boolean isSystem, boolean isArchive) {
    Contracts.isNotNull(nameWithoutExtension, "Argument 'nameWithoutExtension'");
    Contracts.isNotNull(extension, "Argument 'extension'");
    Contracts.isNotNull(fullDirectory, "Argument 'fullDirectory'");
    Contracts.isNotNull(creationDateTime, "Argument 'creationDateTime'");
    Contracts.isNotNull(lastAccessDateTime, "Argument 'lastAccessDateTime'");
    
    
    this.nameWithoutExtension = nameWithoutExtension;
    this.extension = extension;
    this.fullDirectory = fullDirectory;
    this.sizeInB = sizeInB;
    this.creationDateTime = creationDateTime;
    this.lastAccessDateTime = lastAccessDateTime;
    this.isReadOnly = isReadOnly;
    this.isSystem = isSystem;
    this.isArchive = isArchive;
  }

  public String getNameWithoutExtension() {
    return nameWithoutExtension;
  }

  public String getExtension() {
    return extension;
  }

  public String getFullDirectory() {
    return fullDirectory;
  }

  public long getSizeInB() {
    return sizeInB;
  }

  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  public LocalDateTime getLastAccessDateTime() {
    return lastAccessDateTime;
  }

  public boolean isReadOnly() {
    return isReadOnly;
  }

  public boolean isSystem() {
    return isSystem;
  }

  public boolean isArchive() {
    return isArchive;
  }

  public List<FileInfo> getFilesInPath(String path){
    return new ArrayList<>();
  }
}
