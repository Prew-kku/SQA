package Test;


//Driver for CookingConversionCalculator (Bottom-up: calls convert_C)
class DriversC {
 public double convert_C(String choice, double value, String fromUnit, String toUnit) {
     CookingConversionCalculator calculator = new CookingConversionCalculator();
     return calculator.convert(value, choice, fromUnit, toUnit);
 }
}