import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<String> attendance; // Stores "date:status"

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.attendance = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Mark attendance
    public void markAttendance(String date, String status) {
        attendance.add(date + ":" + status);
    }

    // Show all attendance records
    public void showAttendance() {
        System.out.println("Attendance for " + name + ":");
        if (attendance.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            for (String record : attendance) {
                System.out.println(record);
            }
        }
    }

    // Show attendance summary
    public void showAttendanceSummary() {
        int present = 0, absent = 0, late = 0;

        for (String record : attendance) {
            if (record.endsWith("Present")) present++;
            else if (record.endsWith("Absent")) absent++;
            else if (record.endsWith("Late")) late++;
        }

        System.out.println("Attendance summary for " + name + ":");
        System.out.println("Present: " + present);
        System.out.println("Absent: " + absent);
        System.out.println("Late: " + late);
    }
}