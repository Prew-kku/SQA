package Test;
//663380378-4 จุฬาราช คูณคำ

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Test_v2 {

    @ParameterizedTest
    @CsvSource({
        //   S    , M   , L   , expected
        "0   , 0  , 0  , 0",
        "0   , 0  , 50 , 50",
        "0   , 100, 0  , 100",
        "200 , 0  , 0  , 200",
        "0   , 1  , 99 , 100",
        "0   , 99 , 50 , 149",
        "100 , 50 , 49 , 199",
        "0   , 0  , 100, 100",
        "0   , 200, 0  , 200",
        "500 , 0  , 0  , 500",
        "0   , 0  , 101, -1",
        "100 , 100, 50 , -1",
        "600 , 0  , 0  , -1",
        "0   , 201, 0  , -1",
        "1   , 1  , 98 , 100"
    })
    void testCalculate(int small, int medium, int large, int expected) {
        ShippingVehicle vehicle = new ShippingVehicle();
        List<Integer> result = vehicle.calculate(small, medium, large);

        if (expected == -1) {
            System.out.println(
                "Input: S=" + small + ", M=" + medium + ", L=" + large +" | Expected Result: " + expected +
                " | Actual Result: " + result.get(0));
            
            assertEquals(1, result.size());
            assertEquals(-1, result.get(0));
        } else {
            int sum = result.stream().mapToInt(Integer::intValue).sum();
            System.out.println(
                "Input: S=" + small + ", M=" + medium + ", L=" + large +" | Expected Result: " + expected +
                " | Actual Result: " + sum);
            
            assertEquals(expected, sum);
        }
    }}
    