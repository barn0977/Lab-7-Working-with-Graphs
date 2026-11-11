import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst {
    public static void BreadthFirstSearch(AdjList graph, String startName) {
        Queue<Vertex> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();

        Vertex start = graph.nameVertex(startName);

        if (start == null) {
            System.out.print("Vertex Wasn't Found");
            return;
        }
        queue.add(start);
        visited.add(startName);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.getName() + " ");

            for (Edge edge: current.getEdges()) {
                Vertex neighbor;

                if (edge.getFrom() == current) {
                    neighbor = edge.getTo();
                }else {
                    neighbor = edge.getFrom();
                }
                if (!visited.contains(neighbor.getName())) {
                    visited.add(neighbor.getName());
                    queue.add(neighbor);
                }
            }
        }
    }

}
