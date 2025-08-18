package Test;
//จุฬาราช คูณคำ  663380378-4
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class TopDownIntegrationTest {

    @Test
    @DisplayName("1) testCookingConversionCalculator_WithStubConvertC")
    void testCookingConversionCalculator_WithStubConvertC() {
        ConvertCStub stub = new ConvertCStub();
        double result = stub.convert(100, "mass", "cup", "gram");
        assertEquals(12500.0, result); // Expected: 100 × 125 = 12500.0
    }

    @Test
    @DisplayName("2) testConvertC_WithStubsConverters_CallTemperature")
    void testConvertC_WithStubsConverters_CallTemperature() {
        // Simulate call to TemperatureConverter.convert via stub
        ConvertTStub stub = new ConvertTStub();
        double result = stub.convert(100, "fahrenheit", "celsius");
        assertEquals(37.7, result,0.1); // Expected: (100−32)×5/9 = 37.7
    }

    @Test
    @DisplayName("3) testTemperatureConverter_ConvertT")
    void testTemperatureConverter_ConvertT() {
        ConvertTStub stub = new ConvertTStub();
        double result = stub.convert(212, "fahrenheit", "celsius");
        assertEquals(100.0, result); // Expected: (212−32)×5/9 = 100.0
    }

    @Test
    @DisplayName("4) testMassConverter_ConvertM")
    void testMassConverter_ConvertM() {
        ConvertMStub stub = new ConvertMStub();
        double result = stub.convert(1, "cup", "gram");
        assertEquals(125.0, result); // Expected: 1 × 125 = 125.0
    }

    @Test
    @DisplayName("5) testMassConverter_GetConversionFactor")
    void testMassConverter_GetConversionFactor() {
        ConvertMStub stub = new ConvertMStub();
        double result = stub.getConversionFactor("cup", "gram");
        assertEquals(125.0, result); // Expected: 125.0
    }

    @Test
    @DisplayName("6) testLiquidVolumeConverter_ConvertL")
    void testLiquidVolumeConverter_ConvertL() {
        ConvertLStub stub = new ConvertLStub();
        double result = stub.convert(2, "tablespoon", "ml");
        assertEquals(30.0, result); // Expected: 2 × 15 = 30
    }

    @Test
    @DisplayName("7) testLiquidVolumeConverter_ConvertL")
    void testLiquidVolumeConverter_GetConversionFactor() {
        ConvertLStub stub = new ConvertLStub();
        double result = stub.getConversionFactor("tablespoon", "ml");
        assertEquals(15.0, result); // Expected: 15 (from calculation 30/2)
    }
}