package app.webca.codingtest._common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static Integer[] toBoxedArray(int[] array) {
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
    }

    public static List<Integer> toBoxedList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public static List<Integer> toList(Integer[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public static List<String> toList(String[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

}
