import java.util.*;

class student {
    String name;
    int id;

    student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class st {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.println("4. Delete Student");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    System.out.println("Enter student name:");
                    String name = sc.nextLine();

                    System.out.println("Enter id:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (student s : students) {
                        if (s.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("ID already exists!");
                    } else {
                        students.add(new student(name, id));
                        System.out.println("Student added successfully");
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available");
                    } else {
                        for (student s : students) {
                            System.out.println("Name: " + s.name + " Id: " + s.id);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                case 4:
                    System.out.println("Enter id to delete:");
                    int deleteid = sc.nextInt();
                    sc.nextLine();

                    boolean removed = students.removeIf(s -> s.id == deleteid);

                    if (removed) {
                        System.out.println("Student deleted successfully");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}