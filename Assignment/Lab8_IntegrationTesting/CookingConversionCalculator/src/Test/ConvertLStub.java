package Test;
//จุฬาราช คูณคำ  663380378-4
//Stub for convert_L (simulates LiquidVolumeConverter's convert method)
class ConvertLStub {
 public double convert(double liquidValue, String fromUnit, String toUnit) {
     // Simulate PDF: uses getConversionFactor
     return liquidValue * getConversionFactor(fromUnit, toUnit);
 }

 public double getConversionFactor(String fromUnit, String toUnit) {
     if (fromUnit.equals("tablespoon") && toUnit.equals("ml")) {
         return 15.0; // PDF says 2 * 15 = 30, so multiplier 15
     } else if (fromUnit.equals("cup") && toUnit.equals("oz")) {
         return 8.0;
     }
     return 1.0;
 }
}