package cz.osu.kip.oopr2.demoSimpleClasses;

public class DateTime {
  private final int year;
  private final MonthNames month;
  private final int day;
  private final int hour;
  private final int minute;
  private final int second;

  public DateTime(int year, MonthNames month, int day, int hour, int minute, int second) {
    NumberUtils.ensureValueBetween(0, second, 59, "second");
    NumberUtils.ensureValueBetween(0, hour, 23, "hour");
    NumberUtils.ensureValueBetween(0, minute, 59, "minute");
    // všechny ty kontroly na smyslupnost hodnot rok/měsíc/den

    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public int getDay() {
    return day;
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return this.minute;
  }

  public MonthNames getMonth() {
    return month;
  }

  public int getSecond() {
    return second;
  }

  public int getYear() {
    return year;
  }

  private int getMaxDaysInMonth() {
    int maxDaysInMonth;
    switch (month) {
      case JANUARY:
      case MARCH:
      case MAY:
      case JULY:
      case SEPTEMBER:
      case DECEMBER:
        maxDaysInMonth = 31;
        break;
      case FEBRUARY:
        maxDaysInMonth = 28;
        break;
      case APRIL:
      case JUNE:
      case AUGUST:
      case OCTOBER:
      case NOVEMBER:
        maxDaysInMonth = 30;
        break;
      default:
        throw new RuntimeException("Unknown month.");
    }
    return maxDaysInMonth;
  }
}
