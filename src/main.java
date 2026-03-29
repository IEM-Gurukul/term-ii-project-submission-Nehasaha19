import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        loadData(students); // Load persisted student data

        System.out.println("Welcome!"); // harmless addition for 9th commit

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=====================");
            System.out.println("Student Attendance Menu");
            System.out.println("=====================");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Show Attendance");
            System.out.println("4. Show Attendance Summary");
            System.out.println("5. Exit");

            int choice = getValidChoice(sc, 1, 5);

            switch (choice) {
                case 1:
                    addStudent(sc, students);
                    break;
                case 2:
                    markAttendance(sc, students);
                    break;
                case 3:
                    showAttendance(students);
                    break;
                case 4:
                    showSummary(students);
                    break;
                case 5:
                    saveData(students);
                    System.out.println("Data saved. Exiting...");
                    sc.close();
                    return;
            }
        }
    }

    // ---------------- Input Validation ----------------
    public static int getValidChoice(Scanner sc, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
                if (choice >= min && choice <= max) break;
            } else {
                sc.nextLine();
            }
            System.out.println("Invalid input! Enter a number between " + min + " and " + max + ".");
        }
        return choice;
    }

    public static boolean getValidBoolean(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            else if (input.equals("false")) return false;
            else System.out.println("Invalid input! Enter true or false.");
        }
    }

    // ---------------- Student Operations ----------------
    public static void addStudent(Scanner sc, ArrayList<Student> students) {
        int id;
        while (true) {
            System.out.print("Enter Student ID (positive integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                if (id > 0 && !isDuplicateID(students, id)) break;
                else System.out.println("ID already exists or invalid. Try again.");
            } else {
                sc.nextLine();
                System.out.println("Invalid ID! Try again.");
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    public static boolean isDuplicateID(ArrayList<Student> students, int id) {
        for (Student s : students) {
            if (s.getId() == id) return true;
        }
        return false;
    }

    public static void markAttendance(Scanner sc, ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available. Add students first.");
            return;
        }

        int sid;
        Student target = null;
        while (true) {
            System.out.print("Enter Student ID to mark attendance: ");
            if (sc.hasNextInt()) {
                sid = sc.nextInt();
                sc.nextLine();
                for (Student s : students) {
                    if (s.getId() == sid) {
                        target = s;
                        break;
                    }
                }
                if (target != null) break;
            } else {
                sc.nextLine();
            }
            System.out.println("Student ID not found. Try again.");
        }

        boolean present = getValidBoolean(sc, "Present? (true/false): ");
        target.markAttendance(present);
        System.out.println("Attendance updated for " + target.getName());
    }

    public static void showAttendance(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- Student Attendance ---");
        for (Student s : students) {
            s.display();
        }
    }

    public static void showSummary(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- Attendance Summary ---");
        for (Student s : students) {
            System.out.printf("ID: %d, Name: %s, Attendance: %d/%d, Percentage: %.2f%%\n",
                    s.getId(), s.getName(), s.getAttendedClasses(), s.getTotalClasses(),
                    s.getAttendancePercentage());
        }
    }

    // ---------------- File Persistence ----------------
    public static void saveData(ArrayList<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                pw.println(s.getId() + "," + s.getName() + "," + s.getAttendedClasses() + "," + s.getTotalClasses());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

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
                        s.markAttendance(i < attended);
                    }
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
