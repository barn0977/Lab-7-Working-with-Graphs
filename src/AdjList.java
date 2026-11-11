import java.util.ArrayList;

public class AdjList extends Graphs{

    public AdjList() {
        this.vertices = new ArrayList<>();
    }

    @Override
    public Vertex addVertex(String name) {

        Vertex newVertex = null;

        if (isVertex(name)) {
            newVertex = nameVertex(name);
        }
        else {
            newVertex = new Vertex(name);
            vertices.add(newVertex);
        }


        return newVertex;
    }


    @Override
    public void addEdge(String from, String to, double weight) {
        Vertex start = addVertex(from);
        Vertex goal = addVertex(to);

        Edge newEdge = new Edge(start, goal, weight);

        start.getEdges().add(newEdge);
        goal.getEdges().add(newEdge);

    }

    @Override
    public void printGraph() {
        for (Vertex vertex: vertices) {
            System.out.println("-" + vertex.getName() + "-");
            for (Edge edge: vertex.getEdges()) {
                //This isn't truly necessary but just shows the heap storage of what previous vertex its coming from
                //This is a good way to check that it's pulling from the correct Vertex in the graph
//                System.out.println("\nVertex Identification " + edge.toString());
                System.out.println("Vertex From " + edge.getFrom().getName());
                System.out.println("Vertex Destination " +edge.getTo().getName());
                System.out.println("Edge Weight " + edge.getWeight());
                System.out.print("\n --------------------------------------- \n");
            }

        }

    }

    @Override
    public boolean isVertex(String name) {
        for (Vertex vertex: vertices) {
            if (vertex.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public Vertex nameVertex(String name) {
        for (Vertex vertex: vertices) {
            if (vertex.getName().equals(name)) {
                return vertex;
            }
        }
        return null;
    }

}
