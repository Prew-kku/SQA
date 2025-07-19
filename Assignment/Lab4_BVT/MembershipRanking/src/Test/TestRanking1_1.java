package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRanking1_1 {

    Ranking ranker = new Ranking();

    @ParameterizedTest
    @CsvSource({
        // purchase, freq, point, expectedRank
    	"0, 15, 500, Standard",
    	"1, 15, 500, Standard",
    	"50000, 15, 500, Gold",
    	"99999, 15, 500, Gold",
    	"100000, 15, 500, Gold",
    	"50000, 1, 500, Silver",
    	"50000, 2, 500, Silver",
    	"50000, 30, 500, Gold",
    	"50000, 31, 500, Gold",
    	"50000, 15, 0, Standard",
    	"50000, 15, 1, Standard",
    	"50000, 15, 999, Gold",
    	"50000, 15, 1000, Gold"

    })
    void testRankingFromCSV(int purchase, int freq, int point, String expectedRank) {
        assertEquals(expectedRank, ranker.CalculateMembershipRank(purchase, freq, point));
    }
}
