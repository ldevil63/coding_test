package app.webca.codingtest.ch06_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * 성적이 낮은 순서로 학생 출력하기
 * 
 * N명의 학생 정보가 있다. 학생 정보는 이름과 성적으로 구분된다.
 * 각 학생의 이름과 성적 정보가 주어졌을 때 성적이 낮은 순서대로 학생의 이름을 출력하는 프로그램을 작성하시오.
 * </pre>
 */
public class Ch0603 {

    static class Student {
        String name;
        Integer score;

        Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        Integer getScore() {
            return this.score;
        }
    }

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 95),
                new Student("이순신", 77),
                new Student("하지윤", 100));
        List<String> names = list.stream()
                .sorted(Comparator.comparingInt(Student::getScore))
                .map(s -> s.name)
                .collect(Collectors.toList());
        for (String name : names) {
            System.out.print(name + " ");
        }
    }
}
