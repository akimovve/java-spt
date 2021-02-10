package ru.mirea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Function<Integer[], String> getMinValue = array ->
                new HashSet<>(Arrays.asList(array))
                        .stream()
                        .filter(item -> item > 0 && item < 10)
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
        System.out.println(getMinValue.apply(new Integer[]{5, 2, 1, 3, 1}));
    }
}
