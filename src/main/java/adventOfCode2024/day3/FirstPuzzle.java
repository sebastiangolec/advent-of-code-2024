package adventOfCode2024.day3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstPuzzle {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/input/day3");
        Path path = inputFile.toPath();
        String inputString = Files.readString(path, Charset.defaultCharset());
        System.out.println(runProgram(inputString));
    }


    public static int runProgram(String testInput) {
        List<Mul> muls = fetchMuls(testInput);

        return muls.stream().mapToInt(Mul::multiply).sum();
    }

    public static List<Mul> fetchMuls(String testInput) {
        Pattern mulPattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Matcher mulMatcher = mulPattern.matcher(testInput);
        return mulMatcher.results()
                .map(MatchResult::group)
                .map(Mul::new)
                .toList();
    }
}