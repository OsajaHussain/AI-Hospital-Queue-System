// BST (Binary Search Tree)
// Rule: chhota naam LEFT mein jata hai, bada naam RIGHT mein.
// Is se dhundhna bohat tez hota hai.

public class PatientBST {

    class Node {
        Patient patient;
        Node left;
        Node right;
        Node(Patient p) {
            patient = p;
            left = null;
            right = null;
        }
    }

    Node root = null;

    // Naya patient tree mein lagao
    public void insert(Patient p) {
        root = insertNode(root, p);
    }

    private Node insertNode(Node node, Patient p) {
        if (node == null) {
            return new Node(p);
        }
        if (p.name.compareToIgnoreCase(node.patient.name) < 0) {
            node.left = insertNode(node.left, p);
        } else {
            node.right = insertNode(node.right, p);
        }
        return node;
    }

    // Naam se patient dhundho
    public Patient search(String name) {
        Node current = root;
        while (current != null) {
            int result = name.compareToIgnoreCase(current.patient.name);
            if (result == 0) {
                return current.patient;
            } else if (result < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    // Saare patients A se Z dikhao (inorder: left, phir node, phir right)
    public void displayAll() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.patient);
        inorder(node.right);
    }
}
