// STACK: Last In First Out. Jo aakhir mein aaya woh pehle nikalta hai.
// Hum isay "served patients ki history" ke liye use kar rahe hain.

public class PatientStack {

    class Node {
        Patient patient;
        Node next;
        Node(Patient p) {
            patient = p;
            next = null;
        }
    }

    Node top = null;
    int size = 0;

    // Sab se upar rakho
    public void push(Patient p) {
        Node newNode = new Node(p);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Sab se upar wala nikalo
    public Patient pop() {
        if (top == null) {
            return null;
        }
        Patient p = top.patient;
        top = top.next;
        size--;
        return p;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Sab se naya pehle dikhega
    public void display() {
        if (isEmpty()) {
            System.out.println("No history available.");
            return;
        }
        Node current = top;
        int number = 1;
        while (current != null) {
            System.out.println(number + ". " + current.patient);
            current = current.next;
            number++;
        }
    }
}
