import java.util.Scanner;

public class Main {

    // Keeps asking until the user enters a valid number
    static int readNumber(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String text = sc.nextLine();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (e.g., 25).");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientQueue queue = new PatientQueue();
        PatientStack history = new PatientStack();
        PatientBST records = new PatientBST();
        HospitalGraph hospital = new HospitalGraph();
        int nextId = 1;

        while (true) {
            System.out.println("\n===== AI HOSPITAL QUEUE MANAGEMENT SYSTEM =====");
            System.out.println("1. Register a new patient (AI suggests department)");
            System.out.println("2. Call next patient");
            System.out.println("3. View waiting queue");
            System.out.println("4. View served patients (history)");
            System.out.println("5. Undo last call");
            System.out.println("6. Search patient by name");
            System.out.println("7. List all patients (A-Z)");
            System.out.println("8. Show route to a department (from Reception)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Patient name: ");
                String name = sc.nextLine();
                int age = readNumber(sc, "Age: ");
                System.out.print("Symptoms (e.g., chest pain): ");
                String symptoms = sc.nextLine();

                Patient p = new Patient(nextId, name, age, symptoms);
                nextId++;

                System.out.println("Analyzing symptoms with AI...");
                String dept = AIHelper.suggestDepartment(symptoms);
                p.department = dept;
                System.out.println("Recommended department: " + dept);

                for (int i = 0; i < hospital.names.length; i++) {
                    if (hospital.names[i].equals(dept)) {
                        hospital.showShortestPath(0, i);
                    }
                }

                queue.enqueue(p);
                records.insert(p);
                System.out.println("Patient registered. Position in queue: " + queue.getSize());

            } else if (choice.equals("2")) {
                Patient p = queue.dequeue();
                if (p == null) {
                    System.out.println("No patients are waiting in the queue.");
                } else {
                    history.push(p);
                    System.out.println("Now calling: " + p);
                }

            } else if (choice.equals("3")) {
                queue.display();

            } else if (choice.equals("4")) {
                history.display();

            } else if (choice.equals("5")) {
                Patient p = history.pop();
                if (p == null) {
                    System.out.println("Nothing to undo.");
                } else {
                    queue.enqueueFront(p);
                    System.out.println("Patient returned to the front of the queue: " + p);
                }

            } else if (choice.equals("6")) {
                System.out.print("Enter patient name to search: ");
                String name = sc.nextLine();
                Patient p = records.search(name);
                if (p == null) {
                    System.out.println("No patient found with that name.");
                } else {
                    System.out.println("Patient found: " + p);
                }

            } else if (choice.equals("7")) {
                records.displayAll();

            } else if (choice.equals("8")) {
                hospital.printDepartments();
                int number = readNumber(sc, "Select a department (enter number): ");
                if (number < 1 || number > hospital.count()) {
                    System.out.println("Invalid selection.");
                } else {
                    hospital.showShortestPath(0, number - 1);
                }

            } else if (choice.equals("0")) {
                System.out.println("Thank you. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
