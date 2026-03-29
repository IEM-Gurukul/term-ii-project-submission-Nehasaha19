import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Show Attendance");
            System.out.println("4. Show Attendance Summary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    students.add(new Student(id, name));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available. Add students first.");
                        break;
                    }
                    System.out.print("Enter Student ID to mark attendance: ");
                    int sid = sc.nextInt();
                    sc.nextLine(); // consume newline
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == sid) {
                            System.out.print("Present? (true/false): ");
                            boolean present = sc.nextBoolean();
                            s.markAttendance(present);
                            System.out.println("Attendance updated for " + s.getName());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student ID not found!");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }
                    System.out.println("\n--- Student Attendance ---");
                    for (Student s : students) {
                        s.display();
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }
                    System.out.println("\n--- Attendance Summary ---");
                    for (Student s : students) {
                        System.out.printf("ID: %d, Name: %s, Attendance: %d/%d, Percentage: %.2f%%\n",
                                s.getId(), s.getName(), s.getAttendedClasses(), s.getTotalClasses(),
                                s.getAttendancePercentage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
