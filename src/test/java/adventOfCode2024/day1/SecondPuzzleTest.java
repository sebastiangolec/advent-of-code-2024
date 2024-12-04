package adventOfCode2024.day1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondPuzzleTest {

    @Test
    void givenInputStringShouldCalculateSimilarityScore() {
        // given
        final String TEST_INPUT = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3""";
        final int expectedSimilarityScore = 31;

        // when
        BigDecimal result = SecondPuzzle.calculateSimilarityScore(TEST_INPUT);

        // then
        assertEquals(expectedSimilarityScore, result.intValue());
    }
}