package cz.arrayUtils;

public class RegistrationPlate {

  private String value;

  public RegistrationPlate(String value) {
    if (value == null || value.length() == 0)
      throw new IllegalArgumentException("Registration plate value is null or zero length.");
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if ((obj instanceof RegistrationPlate) == false) return false;

    RegistrationPlate otherObject = (RegistrationPlate) obj;
    return this.value.equals(otherObject.value);
  }

  public boolean isVeteran() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return value + " {SPZ}";
  }

  public boolean isSameAs(RegistrationPlate otherValue){
    return this.value.equals(otherValue.value);
  }
}
