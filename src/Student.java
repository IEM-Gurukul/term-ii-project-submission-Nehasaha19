public class Student {
    private int id;
    private String name;
    private int totalClasses;
    private int attendedClasses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) attendedClasses++;
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    public void display() {
        System.out.printf("ID: %d, Name: %s, Attendance: %d/%d\n",
                id, name, attendedClasses, totalClasses);
    }
}
