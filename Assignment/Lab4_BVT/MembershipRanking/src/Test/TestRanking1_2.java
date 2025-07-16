package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class TestRanking1_2 {


    Ranking ranker = new Ranking();

    @ParameterizedTest
    @CsvSource({
        // purchaseTotal, frequency, points, expectedRank
        "0,4,500,Standard",          // min–1 (invalid)
        "10000,4,500,Silver",       // min
        "10001,4,500,Silver",       // min+1
        "45000,4,500,Silver",       // nominal
        "99999,4,500,Gold",       // max-1
        "100000,4,500,Gold",      // max
        "100099,4,500,Gold",      // max+1 (invalid but system allows)

        "45000,0,500,Standard",     // min–1 (invalid)
        "45000,1,500,Silver",     // min
        "45000,2,500,Silver",       // min+1
        "45000,6,500,Silver",       // max-1
        "45000,7,500,Silver",       // max
        "45000,8,500,Silver",       // max+1

        "45000,4,50,Standard",      // min–1 (invalid)
        "45000,4,100,Silver",       // min
        "45000,4,250,Silver",       // min+1
        "45000,4,750,Silver",       // max-1
        "45000,4,1000,Silver",      // max
        "45000,4,1001,Silver"       // max+1
    })
    void testRobustBoundary(int purchase, int freq, int points, String expected) {
        assertEquals(expected, ranker.CalculateMembershipRank(purchase, freq, points));
    }
}
