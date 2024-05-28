// JOHN CYRUS M. YLEAÑA
import java.util.*;

public class GraphConnectedComponents {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the number of edges:");
			int edges = scanner.nextInt();

			System.out.println("Enter the edges (format: u v):");
			for (int i = 0; i < edges; i++) {
			    int u = scanner.nextInt();
			    int v = scanner.nextInt();
			    graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			    graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
			}
		}

        int components = 0;
        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                components++;
                dfs(node);
            }
        }

        if (components == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected. Number of connected components: " + components);
        }
    }

    private static void dfs(int node) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}
