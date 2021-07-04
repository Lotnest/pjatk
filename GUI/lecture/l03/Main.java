package lecture.l03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer();
        Mouse mouse = new Mouse();

        computer.connect(mouse);

        Student[] students = {
                new Student(100, "Sylvia"),
                new Student(5, "Philipa"),
                new Student(27, "Hugh"),
        };
        System.out.println(Arrays.toString(StudentSelector.filter(students, new MyStudentCrit())));
        System.out.println(Arrays.toString(StudentSelector.filter(students, student -> student.getId() < 1000)));
    }
}

class MyStudentCrit implements StudentSelector {

    @Override
    public boolean crit(Student student) {
        return student.getId() < 500;
    }
}
