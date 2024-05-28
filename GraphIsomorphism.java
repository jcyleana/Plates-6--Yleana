// JOHN CYRUS M. YLEAÑA
import java.util.*;

public class GraphIsomorphism {

    private static Map<String, List<String>> graph1 = new HashMap<>();
    private static Map<String, List<String>> graph2 = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices in graph 1:");
        int vertices1 = scanner.nextInt();

        System.out.println("Enter the edges of graph 1 (format: u v):");
        readGraph(scanner, graph1, vertices1);

        System.out.println("Enter the number of vertices in graph 2:");
        int vertices2 = scanner.nextInt();

        System.out.println("Enter the edges of graph 2 (format: u v):");
        readGraph(scanner, graph2, vertices2);

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    private static void readGraph(Scanner scanner, Map<String, List<String>> graph, int vertices) {
        System.out.println("Enter the edges (format: u v):");
        for (int i = 0; i < vertices; i++) {
            String u = scanner.next();
            String v = scanner.next();
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }

    private static boolean areIsomorphic(Map<String, List<String>> graph1, Map<String, List<String>> graph2) {
        if (graph1.size() != graph2.size()) {
            return false;
        }

        Map<String, String> vertexMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        return isIsomorphic(graph1, graph2, vertexMap, visited);
    }

    private static boolean isIsomorphic(Map<String, List<String>> graph1, Map<String, List<String>> graph2,
                                        Map<String, String> vertexMap, Set<String> visited) {
        if (vertexMap.size() == graph1.size()) {
            return true;
        }

        String u = findUnmappedVertex(graph1, vertexMap, visited);
        if (u == null) {
            return false;
        }

        for (String v : graph2.keySet()) {
            if (!vertexMap.containsValue(v) && hasSameNeighbours(graph1, u, graph2, v, vertexMap)) {
                vertexMap.put(u, v);
                visited.add(v);
                if (isIsomorphic(graph1, graph2, vertexMap, visited)) {
                    return true;
                }
                vertexMap.remove(u);
                visited.remove(v);
            }
        }

        return false;
    }

    private static String findUnmappedVertex(Map<String, List<String>> graph, Map<String, String> vertexMap, Set<String> visited) {
        for (String vertex : graph.keySet()) {
            if (!vertexMap.containsKey(vertex) && !visited.contains(vertex)) {
                return vertex;
            }
        }
        return null;
    }

    private static boolean hasSameNeighbours(Map<String, List<String>> graph1, String u,
                                             Map<String, List<String>> graph2, String v,
                                             Map<String, String> vertexMap) {
        List<String> neighbours1 = graph1.get(u);
        List<String> neighbours2 = graph2.get(v);

        if (neighbours1.size() != neighbours2.size()) {
            return false;
        }

        for (String neighbour : neighbours1) {
            String mappedNeighbour = vertexMap.get(neighbour);
            if (!neighbours2.contains(mappedNeighbour)) {
                return false;
            }
        }

        return true;
    }
}
