package Test;

//จุฬาราช คูณคำ  663380378-4
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class test_v1 {

    @Test
    void testNullArray() {
        assertEquals(0, CountWordClumps.countClumps(null));
    }

    @Test
    void testEmptyArray() {
        assertEquals(0, CountWordClumps.countClumps(new int[] {}));
    }

    @Test
    void testClumps122() {
        assertEquals(1, CountWordClumps.countClumps(new int[] {1, 2, 2}));
    }

    @Test
    void testLongClump() {
        assertEquals(1, CountWordClumps.countClumps(new int[] {1,1,1}));
    }
}