public class Student {
    private int id;
    private String name;
    private int totalClasses;
    private int attendedClasses;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    // Mark attendance
    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) {
            attendedClasses++;
        }
    }

    // Get attendance percentage
    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    // Display student details
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Attendance: " + attendedClasses + "/" + totalClasses);
        System.out.printf("Percentage: %.2f%%\n", getAttendancePercentage());
        System.out.println("-------------------------");
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public int getTotalClasses() {
        return totalClasses;
    }
}
