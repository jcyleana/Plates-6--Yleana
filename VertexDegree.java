// JOHN CYRUS M. YLEAÑA
import java.util.*;

public class VertexDegree {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        System.out.println("Degrees of vertices:");
        for (int vertex : graph.keySet()) {
            System.out.println("Vertex " + vertex + " has degree " + graph.get(vertex).size());
        }
    }
}
