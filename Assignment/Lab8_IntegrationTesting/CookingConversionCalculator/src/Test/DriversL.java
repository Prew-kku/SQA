package Test;


//Driver for LiquidVolumeConverter (Bottom-up: calls convert_L and getConversionFactor)
class DriversL {
 public double getConversionFactor(String fromUnit, String toUnit) {
     LiquidVolumeConverter converter = new LiquidVolumeConverter();
     return converter.getConversionFactor(fromUnit, toUnit);
 }

 public double convert_L(double liquidValue, String fromUnit, String toUnit) {
     LiquidVolumeConverter converter = new LiquidVolumeConverter();
     return converter.convert(liquidValue, fromUnit, toUnit);
 }
}