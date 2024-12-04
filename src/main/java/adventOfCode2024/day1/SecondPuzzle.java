package adventOfCode2024.day1;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class SecondPuzzle {
    public static final int LEFT_COLUMN = 0;
    public static final int RIGHT_COLUMN = 1;

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/input/day1.txt");
        Path path = inputFile.toPath();
        String inputString = Files.readString(path, Charset.defaultCharset());
        BigDecimal result = calculateSimilarityScore(inputString);
        System.out.println(result);
    }

    public static BigDecimal calculateSimilarityScore(String testInput) {
        List<Integer> leftColumn = getColumnAsList(testInput, LEFT_COLUMN);
        List<Integer> rightColumn = getColumnAsList(testInput, RIGHT_COLUMN);

        BigDecimal similarityScore = BigDecimal.ZERO;
        for (int value : leftColumn) {
            long multiplier = rightColumn.stream().filter(e -> e.compareTo(value) == 0).count();
            similarityScore = similarityScore.add(BigDecimal.valueOf(value).multiply(BigDecimal.valueOf(multiplier)));
        }

        return similarityScore;
    }

    private static List<Integer> getColumnAsList(String input, int column) {
        LinkedList<Integer> result = new LinkedList<>();
        input.lines().forEach(line -> {
            String[] numbers = line.split(" {3}");
            result.add(Integer.parseInt(numbers[column]));
        });

        return result;
    }
}
