package employee.management.systems;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceSystem {
    private Map<String, Boolean> attendanceMap; // Student name -> Attendance status

    public AttendanceSystem() {
        attendanceMap = new HashMap<>();
    }

    public void markAttendance(String studentName, boolean isPresent) {
        attendanceMap.put(studentName, isPresent);
    }

    public void printAttendanceReport() {
        System.out.println("Attendance Report:");
        for (String student : attendanceMap.keySet()) {
            String status = attendanceMap.get(student) ? "Present" : "Absent";
            System.out.println(student + ": " + status);
        }
    }

    public static void main(String[] args) {
        AttendanceSystem system = new AttendanceSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Mark Attendance");
            System.out.println("2. Print Attendance Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Is the student present? (true/false): ");
                    boolean isPresent = scanner.nextBoolean();
                    system.markAttendance(name, isPresent);
                    break;
                case 2:
                    system.printAttendanceReport();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
