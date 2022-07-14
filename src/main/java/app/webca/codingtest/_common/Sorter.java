package app.webca.codingtest._common;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    public static void asc(int[] array) {
        Arrays.sort(array);
    }

    // public static void desc(int[] array) {
    // Arrays.sort(array, Collections.reverseOrder());
    // }

    public static Integer[] ascBoxed(int[] array) {
        Integer[] boxedArray = Converter.toBoxedArray(array);
        asc(boxedArray);
        return boxedArray;
    }

    public static Integer[] descBoxed(int[] array) {
        Integer[] boxedArray = Converter.toBoxedArray(array);
        desc(boxedArray);
        return boxedArray;
    }

    public static void asc(Integer[] array) {
        Arrays.sort(array);
    }

    public static void desc(Integer[] array) {
        Arrays.sort(array, Collections.reverseOrder());
    }

    public static void asc(String[] array) {
        Arrays.sort(array);
    }

    public static void desc(String[] array) {
        Arrays.sort(array, Collections.reverseOrder());
    }

    public static List<Integer> ascInteger(List<Integer> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> descInteger(List<Integer> list) {
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<String> ascString(List<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> descString(List<String> list) {
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

}
