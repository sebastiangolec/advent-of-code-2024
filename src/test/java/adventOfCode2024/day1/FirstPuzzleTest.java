package adventOfCode2024.day1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FirstPuzzleTest {

    @Test
    void givenInputStringShouldCalculateTotalDistance() {
        // given
        final String TEST_INPUT = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3""";
        final int expectedTotalDistance = 11;

        // when
        int result = FirstPuzzle.calculateTotalDistance(TEST_INPUT);

        // then
        assertEquals(expectedTotalDistance, result);
    }
}