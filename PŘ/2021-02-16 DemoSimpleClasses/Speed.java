package cz.osu.kip.oopr2.demoSimpleClasses;

public class Speed {

  private static final int MAXIMAL_SPEED = 350;
  private static final double MIPH_2_KPH_RATIO = 1.611;
  private static final double MPS_2_KPH_RATIO = 1.611;

  public static int convert(int value, SpeedUnit sourceUnit, SpeedUnit targetUnit) {
    double inKph = convertToKph(value, sourceUnit);
    int ret = convertFromKph(inKph, targetUnit);
    return ret;
  }

  private static double convertToKph(int value, SpeedUnit sourceUnit) {
    switch (sourceUnit) {
      case kph:
        return value;
      case miph:
        return value * MIPH_2_KPH_RATIO;
      case mps:
        return value * MPS_2_KPH_RATIO;
      default:
        throw new RuntimeException("Unknown SpeedUnit");
    }
  }

  private static int convertFromKph(double value, SpeedUnit targetUnit) {
    switch (targetUnit) {
      case kph:
        return (int) value;
      case miph:
        return (int) (value / MIPH_2_KPH_RATIO);
      case mps:
        return (int) (value / MPS_2_KPH_RATIO);
      default:
        throw new RuntimeException("Unknown SpeedUnit");
    }
  }
  private final int value;
  private final SpeedUnit unit;

  public Speed(int value, SpeedUnit unit) {
    NumberUtils.ensureValueBetween(0, value, MAXIMAL_SPEED, "Speed-value");
    this.value = value;
    this.unit = unit;
  }

  public Speed convert(SpeedUnit targetUnit) {
    Speed ret;
    int resultSpeed = Speed.convert(this.value, this.unit, targetUnit);
    ret = new Speed(resultSpeed, targetUnit);
    return ret;
  }

  public SpeedUnit getUnit() {
    return unit;
  }

  public int getValue() {
    return value;
  }
}
