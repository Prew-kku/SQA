package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRanking1_1 {

    Ranking ranker = new Ranking();

    @ParameterizedTest
    @CsvSource({
        // purchase, freq, point, expectedRank
        "10000, 4, 500, Silver",
        "10001, 4, 500, Silver",
        "45000, 4, 500, Silver",
        "99999, 4, 500, Gold",
        "100000, 4, 500, Gold",
        "45000, 1, 500, Silver",
        "45000, 2, 500, Silver",
        "45000, 6, 500, Silver",
        "45000, 7, 500, Silver",
        "45000, 4, 100, Silver",
        "45000, 4, 250, Silver",
        "45000, 4, 750, Silver",
        "45000, 4, 1000, Silver",

    })
    void testRankingFromCSV(int purchase, int freq, int point, String expectedRank) {
        assertEquals(expectedRank, ranker.CalculateMembershipRank(purchase, freq, point));
    }
}
