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

    // Add attendance record
    public void markAttendance(String date, String status) {
        attendance.add(date + ":" + status);
    }

    // Show all attendance
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
}