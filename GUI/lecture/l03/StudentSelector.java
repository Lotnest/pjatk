package lecture.l03;

public interface StudentSelector {

    boolean crit(Student student);

    static Student[] filter(Student[] students, StudentSelector studentSelector) {
        int count = 0;
        for (Student student : students) {
            if (studentSelector.crit(student)) {
                count++;
            }
        }
        Student[] critStudents = new Student[count];
        count = 0;
        for (Student student : students) {
            if (studentSelector.crit(student)) {
                critStudents[count++] = student;
            }
        }
        return critStudents;
    }
}
