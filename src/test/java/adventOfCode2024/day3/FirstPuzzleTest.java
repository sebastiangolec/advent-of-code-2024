package adventOfCode2024.day3;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstPuzzleTest {
    private static final String TEST_INPUT = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    private static final int EXPECTED_RESULT = 161;

    @Test
    void givenInputShouldMultiplyValidNumbers() {
        // when
        int result = FirstPuzzle.runProgram(TEST_INPUT);

        // then
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    void givenInputShouldFetchProperValues() {
        // given
        List<Mul> expectedMuls = new LinkedList<>();
        expectedMuls.add(new Mul(2, 4));
        expectedMuls.add(new Mul(5, 5));
        expectedMuls.add(new Mul(11,8));
        expectedMuls.add(new Mul(8, 5));


        // when
        List<Mul> muls = FirstPuzzle.fetchMuls(TEST_INPUT);

        // then
        assertIterableEquals(expectedMuls, muls);
    }
}