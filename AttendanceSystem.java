import java.util.ArrayList;

public class AttendanceSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== Student Records =====");
        for (Student s : students) {
            s.displayStudent();
        }
    }

    public void markAttendance(int id, boolean present) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                s.markAttendance(present);
                System.out.println("Attendance marked.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                System.out.println("Student found:");
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
