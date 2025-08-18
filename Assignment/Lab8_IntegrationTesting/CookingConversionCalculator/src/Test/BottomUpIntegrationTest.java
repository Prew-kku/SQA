package Test;
//จุฬาราช คูณคำ  663380378-4
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class BottomUpIntegrationTest {

    @Test
    @DisplayName("1")
    void testConvertT_WithDriversT() {
    	System.out.println("Debug: Input to convert_T = 100 fahrenheit to celsius");
        DriversT driver = new DriversT();
        double result = driver.convert_T(100, "fahrenheit", "celsius");
        System.out.println("Debug: Result = " + result);
        assertEquals(37.7, result); // Expected: 37.7
        
    }

    @Test
    @DisplayName("2")
    void testTemperatureConverter_WithDriversC() {
        DriversC driver = new DriversC();
        double result = driver.convert_C("temperature", 100, "fahrenheit", "celsius");
        assertEquals(37.7, result); // Expected: 37.7
    }

    @Test
    @DisplayName("3")
    void testGetConversionFactor_WithDriversM() {
        DriversM driver = new DriversM();
        double result = driver.getConversionFactor("cup", "gram");
        assertEquals(125.0, result); // Expected: 125
    }

    @Test
    @DisplayName("4")
    void testConvertM_WithDriversMassConverter() {
        DriversM driver = new DriversM();
        double result = driver.convert_M(2, "cup", "gram");
        assertEquals(250.0, result); // Expected: 250
    }

    @Test
    @DisplayName("5")
    void testMassConverter_WithDriversC() {
        DriversC driver = new DriversC();
        double result = driver.convert_C("mass", 2, "cup", "gram");
        assertEquals(250.0, result); // Expected: 250
    }

    @Test
    @DisplayName("6")
    void testGetConversionFactor_WithDriversL() {
        DriversL driver = new DriversL();
        double result = driver.getConversionFactor("cup", "oz");
        assertEquals(8.0, result); // Expected: 8
    }

    @Test
    @DisplayName("7")
    void testConvertL_WithDriversLiquidVolumeConverter() {
        DriversL driver = new DriversL();
        double result = driver.convert_L(2, "cup", "oz");
        assertEquals(16.0, result); // Expected: 16
    }

    @Test
    @DisplayName("8")
    void testLiquidVolumeConverter_WithDriversC() {
        DriversC driver = new DriversC();
        double result = driver.convert_C("liquid", 2, "cup", "oz");
        assertEquals(16.0, result); // Expected: 16
    }

    @Test
    @DisplayName("9")
    void testConvertC_WithDriversCookingConversionCalculator() {
        DriversC driver = new DriversC();
        double result = driver.convert_C("temperature", 100, "fahrenheit", "celsius");
        assertEquals(37.7, result); // Expected: 37.7
    }

    @Test
    @DisplayName("10")
    void testCookingConversionCalculator_WithDriversMain() {
        DriversMain driver = new DriversMain();
        double result = driver.callConvert("temperature", 100, "fahrenheit", "celsius");
        assertEquals(37.7, result); // Expected: 37.7
    }
}