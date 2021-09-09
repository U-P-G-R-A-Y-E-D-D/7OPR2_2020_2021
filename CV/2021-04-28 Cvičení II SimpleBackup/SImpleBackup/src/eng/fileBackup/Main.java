package eng.fileBackup;

public class Main {

  public static void main(String[] args) {
    String src = "C:\\temp\\airlines";
    String trg = "R:\\backup";

    BackupProvider backupProvider = new BackupProvider();
    backupProvider.doBackup(src, trg);

  }
}
