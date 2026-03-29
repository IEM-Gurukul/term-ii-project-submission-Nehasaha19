import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Load data from file at program start
        loadData(students);

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
                    // Save data before exiting
                    saveData(students);
                    System.out.println("Data saved. Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Save student data to file
    public static void saveData(ArrayList<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                pw.println(s.getId() + "," + s.getName() + "," + s.getAttendedClasses() + "," + s.getTotalClasses());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load student data from file
    public static void loadData(ArrayList<Student> students) {
        File f = new File("students.txt");
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int attended = Integer.parseInt(parts[2]);
                    int total = Integer.parseInt(parts[3]);
                    Student s = new Student(id, name);
                    for (int i = 0; i < total; i++) {
                        s.markAttendance(i < attended); // first `attended` classes marked present
                    }
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
