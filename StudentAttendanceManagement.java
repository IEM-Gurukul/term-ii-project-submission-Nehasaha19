import java.util.Scanner;

public class StudentAttendanceManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceSystem system = new AttendanceSystem();

        // Sample students
        system.addStudent(new Student(1, "Rahul"));
        system.addStudent(new Student(2, "Anjali"));
        system.addStudent(new Student(3, "Amit"));

        int choice;

        do {
            System.out.println("\n===== Student Attendance System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Mark Attendance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    system.addStudent(new Student(id, name));
                    break;

                case 2:
                    system.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    system.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int attId = sc.nextInt();

                    System.out.print("Present? (true/false): ");
                    boolean present = sc.nextBoolean();

                    system.markAttendance(attId, present);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
 