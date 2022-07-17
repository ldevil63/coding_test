package app.webca.codingtest._common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample {

    static class Student {
        final String name;
        final Integer score;

        Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        Integer getScore() {
            return this.score;
        }
    }

    public static void sum(Integer[] numbers) {
        Integer sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("sum : " + sum);
    }

    public static void sum(List<Integer> numbers) {
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum : " + sum);
    }

    public static void sort(List<Student> list) {
        List<String> names = list.stream()
                .sorted(Comparator.comparingInt(Student::getScore))
                .map(s -> s.name)
                .collect(Collectors.toList());
        for (String name : names) {
            System.out.print(name + " ");
        }
    }

    public static void main(String[] args) {
        sum(new Integer[] { 1, 2, 3, 4, 5 });
        sum(Arrays.asList(1, 2, 3, 4, 5));
        sort(Arrays.asList(
                new Student("홍길동", 95),
                new Student("이순신", 77),
                new Student("하지윤", 100)));
    }

}
