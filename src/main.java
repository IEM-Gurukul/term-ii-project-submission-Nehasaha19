import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Show Attendance");
            System.out.println("3. Exit");
            System.out.println("4. Show Attendance Summary");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter student ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                String status = "";
                while (true) {
                    System.out.print("Enter status (Present/Absent/Late): ");
                    status = sc.nextLine();
                    if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent") || status.equalsIgnoreCase("Late")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter Present, Absent, or Late.");
                    }
                }

                if (id == 1) student1.markAttendance(date, status);
                else if (id == 2) student2.markAttendance(date, status);
                else System.out.println("Student not found.");

            } else if (choice == 2) {
                System.out.print("Enter student ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline
                if (id == 1) student1.showAttendance();
                else if (id == 2) student2.showAttendance();
                else System.out.println("Student not found.");

            } else if (choice == 4) {
                System.out.print("Enter student ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline
                if (id == 1) student1.showAttendanceSummary();
                else if (id == 2) student2.showAttendanceSummary();
                else System.out.println("Student not found.");

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}