package Test;

//Driver for main (Top-down or Bottom-up: simulates entry point)
class DriversMain {
 public double callConvert(String choice, double value, String fromUnit, String toUnit) {
     CookingConversionCalculator calculator = new CookingConversionCalculator();
     return calculator.convert(value, choice, fromUnit, toUnit);
 }
}