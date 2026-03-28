public class Student {
    private int studentId;
    private String name;
    private int totalClasses;
    private int attendedClasses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) {
            attendedClasses++;
        }
    }

    public void displayStudent() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Name         : " + name);
        System.out.println("Total Classes: " + totalClasses);
        System.out.println("Attended     : " + attendedClasses);

        double percentage = totalClasses == 0 ? 0 : (attendedClasses * 100.0 / totalClasses);
        System.out.println("Attendance % : " + percentage + "%");
        System.out.println("----------------------------");
    }
}
