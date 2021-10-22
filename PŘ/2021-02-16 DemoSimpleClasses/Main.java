package cz.osu.kip.oopr2.demoSimpleClasses;

public class Main {

  public static void main(String[] args) {
    Speed speedInKph = new Speed(50, SpeedUnit.kph);

    Speed speedInMph = new Speed(
            Speed.convert(speedInKph.getValue(), SpeedUnit.kph, SpeedUnit.miph),
            SpeedUnit.miph);
    Speed speedInMph2 = speedInKph.convert(SpeedUnit.miph);
  }
}
