package Test;

//จุฬาราช คูณคำ  663380378-4

// Stub for convert_M (simulates MassConverter's convert method)
class ConvertMStub {
    public double convert(double massValue, String fromUnit, String toUnit) {
        // Simulate PDF: uses getConversionFactor
        return massValue * getConversionFactor(fromUnit, toUnit);
    }

    public double getConversionFactor(String fromUnit, String toUnit) {
        if (fromUnit.equals("cup") && toUnit.equals("gram")) {
            return 125.0;
        }
        return 1.0;
    }
}