package adventOfCode2024.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SecondPuzzleTest {
    private static final String TEST_INPUT = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9""";
    private static final int EXPECTED_SAFE_REPORTS = 4;

    @Test
    void givenTestInputShouldCountOnlySafeReports() {
        // given
        final String TEST_INPUT = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9""";
        final int EXPECTED_SAFE_REPORTS = 4;

        // when
        long result = SecondPuzzle.countSafeReports(TEST_INPUT);

        // then
        assertEquals(EXPECTED_SAFE_REPORTS, result);
    }

    @ParameterizedTest
    @MethodSource("reportSafety")
    void givenReportShouldAssertSafety(String report, boolean expectedSafety) {
        // when
        boolean result = SecondPuzzle.isReportOneErrorProne(report);

        // then
        assertEquals(expectedSafety, result);
    }

    static Stream<Arguments> reportSafety() {
        return Stream.of(
                arguments("7 6 4 2 1", true),
                arguments("1 2 7 8 9", false),
                arguments("9 7 6 2 1", false),
                arguments("1 3 2 4 5", true),
                arguments("8 6 4 4 1", true),
                arguments("1 3 6 7 9", true)
        );
    }
}