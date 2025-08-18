package Test;
//จุฬาราช คูณคำ  663380378-4
//Driver for MassConverter (Bottom-up: calls convert_M and getConversionFactor)
class DriversM {
 public double getConversionFactor(String fromUnit, String toUnit) {
     MassConverter converter = new MassConverter();
     return converter.getConversionFactor(fromUnit, toUnit);
 }

 public double convert_M(double massValue, String fromUnit, String toUnit) {
     MassConverter converter = new MassConverter();
     return converter.convert(massValue, fromUnit, toUnit);
 }
}