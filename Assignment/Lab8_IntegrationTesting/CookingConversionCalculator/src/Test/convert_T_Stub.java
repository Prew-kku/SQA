package Test;

//จุฬาราช คูณคำ  663380378-4

// Stub for convert_T (simulates TemperatureConverter's convert method)
class ConvertTStub {
    public double convert(double tempValue, String fromUnit, String toUnit) {
        // Simulate PDF calculations
        if (fromUnit.equals("fahrenheit") && toUnit.equals("celsius")) {
            return (tempValue - 32) * (5.0 / 9.0);
        }
        return 0.0;
    }
}