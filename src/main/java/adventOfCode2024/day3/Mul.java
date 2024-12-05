package adventOfCode2024.day3;

import java.util.List;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Mul {
    private final int valueOne;
    private final int valueTwo;
    private static final Pattern DIGITS_PATTERN = Pattern.compile("\\d+");

    public Mul(int valueOne, int valueTwo) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    /**
     * Accepts input in mul([0-9]+,[0-9]+) format, parses the string and fetches the numeric values
     */
    public Mul(String mulString) {
        List<Integer> numericValues = DIGITS_PATTERN.matcher(mulString).results().map(MatchResult::group).map(Integer::parseInt).toList();
        this.valueOne = numericValues.get(0);
        this.valueTwo = numericValues.get(1);
    }

    public int multiply() {
        return this.valueOne * this.valueTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mul mul = (Mul) o;
        return valueOne == mul.valueOne && valueTwo == mul.valueTwo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueOne, valueTwo);
    }
}
