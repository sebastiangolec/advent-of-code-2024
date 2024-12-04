package adventOfCode2024.day2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondPuzzle {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/input/day2.txt");
        Path path = inputFile.toPath();
        String inputString = Files.readString(path, Charset.defaultCharset());
        long numberOfSafeReports = countSafeReports(inputString);
        System.out.println(numberOfSafeReports);
    }

    public static long countSafeReports(String input) {
        return input.lines()
                .filter(SecondPuzzle::isReportOneErrorProne)
                .count();
    }

    public static boolean isReportOneErrorProne(String report) {
        List<Integer> values = Arrays.stream(report.split(" ")).map(Integer::parseInt).toList();
        if (isReportSafe(values)) {
            return true;
        } else {
            int validReportsWithOneError = 0;
            for (int i = 0; i < values.size(); i++) {
                List<Integer> workCopy = new ArrayList<>(List.copyOf(values));
                workCopy.remove(i);
                if (isReportSafe(workCopy)) {
                    validReportsWithOneError++;
                }
            }

            // if there is at least one valid report after removing one value from it, then algorithm works
            return validReportsWithOneError >= 1;
        }
    }

    public static boolean isReportSafe(List<Integer> values) {
        List<Integer> diffs = new ArrayList<>(values.size() - 1);

        boolean isDiffSafe = true;
        for (int i = 0; i < values.size() - 1; i++) {
            int firstValue = values.get(i);
            int secondValue = values.get(i + 1);

            diffs.add(firstValue - secondValue);
            int absDiff = Math.abs(Math.abs(firstValue) - Math.abs(secondValue));
            isDiffSafe &= (1 <= absDiff && absDiff <= 3);
        }

        return isDiffSafe && allHaveSameSign(diffs);
    }

    private static boolean allHaveSameSign(List<Integer> numbers) {
        if (numbers.stream().allMatch(value -> value > 0)) {
            return true;
        } else if (numbers.stream().allMatch(value -> value < 0)) {
            return true;
        } else {
            return false;
        }
    }
}
