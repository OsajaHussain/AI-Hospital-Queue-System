// GRAPH: departments = points (nodes), raaste = lines (edges)
// Har raaste ki doori meters mein hai.
// Sab se chhota raasta Dijkstra algorithm se nikalte hain.

public class HospitalGraph {

    String[] names = {
        "Reception", "Emergency", "Cardiology", "Neurology",
        "Orthopedics", "Pediatrics", "Pharmacy", "Lab"
    };

    // matrix[a][b] = a aur b ke beech doori (0 matlab seedha raasta nahi)
    int[][] matrix = new int[8][8];

    public HospitalGraph() {
        addRoad(0, 1, 20);  // Reception - Emergency
        addRoad(0, 6, 15);  // Reception - Pharmacy
        addRoad(0, 7, 25);  // Reception - Lab
        addRoad(1, 2, 30);  // Emergency - Cardiology
        addRoad(1, 4, 25);  // Emergency - Orthopedics
        addRoad(7, 3, 20);  // Lab - Neurology
        addRoad(7, 5, 30);  // Lab - Pediatrics
        addRoad(2, 3, 15);  // Cardiology - Neurology
        addRoad(6, 5, 20);  // Pharmacy - Pediatrics
    }

    // Do departments ke beech do tarfa raasta
    private void addRoad(int a, int b, int meters) {
        matrix[a][b] = meters;
        matrix[b][a] = meters;
    }

    public void printDepartments() {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
    }

    public int count() {
        return names.length;
    }

    // Sab se chhota raasta (Dijkstra)
    public void showShortestPath(int from, int to) {
        int n = names.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] done = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = 999999;
            prev[i] = -1;
        }
        dist[from] = 0;

        for (int round = 0; round < n; round++) {
            // sab se kam doori wala department chuno
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            done[u] = true;

            // uske padosiyon ki doori update karo
            for (int v = 0; v < n; v++) {
                if (matrix[u][v] > 0 && !done[v] && dist[u] + matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + matrix[u][v];
                    prev[v] = u;
                }
            }
        }

        // peeche se raasta jodo
        String path = "";
        int current = to;
        while (current != -1) {
            if (path.isEmpty()) {
                path = names[current];
            } else {
                path = names[current] + " -> " + path;
            }
            current = prev[current];
        }

        System.out.println("Route: " + path);
        System.out.println("Total distance: " + dist[to] + " meters");
    }
}
