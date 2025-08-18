package Test;
//จุฬาราช คูณคำ  663380378-4
//Driver for TemperatureConverter (Bottom-up: calls convert)
class DriversT {
 public double convert_T(double tempValue, String fromUnit, String toUnit) {
     TemperatureConverter converter = new TemperatureConverter();
     return converter.convert(tempValue, fromUnit, toUnit);
 }
}
