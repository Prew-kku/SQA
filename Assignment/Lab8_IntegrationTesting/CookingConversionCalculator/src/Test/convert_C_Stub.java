package Test;

// Stub for convert_C (simulates CookingConversionCalculator's convert method)
class ConvertCStub {
    public double convert(double value, String choice, String fromUnit, String toUnit) {
        // Simulate based on PDF example (e.g., for mass: return value * 125)
        if (choice.equals("mass") && fromUnit.equals("cup") && toUnit.equals("gram")) {
            return value * 125;
        }
        return 0.0; // Default for other cases
    }
}