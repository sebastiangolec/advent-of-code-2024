package adventOfCode2024.day1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FirstPuzzle {
    public static final int LEFT_COLUMN = 0;
    public static final int RIGHT_COLUMN = 1;

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/input/day1");
        Path path = inputFile.toPath();
        String inputString = Files.readString(path, Charset.defaultCharset());
        int result = calculateTotalDistance(inputString);
        System.out.println(result);
    }

    public static int calculateTotalDistance(String testInput) {
        List<Integer> leftColumn = getColumnAsList(testInput, LEFT_COLUMN);
        List<Integer> rightColumn = getColumnAsList(testInput, RIGHT_COLUMN);

        leftColumn.sort(Comparator.naturalOrder());
        rightColumn.sort(Comparator.naturalOrder());

        int totalDistance = 0;
        for (int i = 0; i < leftColumn.size(); i++) {
            totalDistance += Math.abs(leftColumn.get(i) - rightColumn.get(i));
        }

        return totalDistance;
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
