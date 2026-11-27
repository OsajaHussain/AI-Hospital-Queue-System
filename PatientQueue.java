public class PatientQueue {

    class Node {
        Patient patient;
        Node next;
        Node(Patient p) {
            patient = p;
            next = null;
        }
    }

    Node front = null;
    Node rear = null;
    int size = 0;

    // Peeche lagao
    public void enqueue(Patient p) {
        Node newNode = new Node(p);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Sab se aage lagao (undo ke liye)
    public void enqueueFront(Patient p) {
        Node newNode = new Node(p);
        newNode.next = front;
        front = newNode;
        if (rear == null) {
            rear = newNode;
        }
        size++;
    }

    // Aage se nikalo
    public Patient dequeue() {
        if (front == null) {
            return null;
        }
        Patient p = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return p;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        Node current = front;
        int number = 1;
        while (current != null) {
            System.out.println(number + ". " + current.patient);
            current = current.next;
            number++;
        }
    }
}
