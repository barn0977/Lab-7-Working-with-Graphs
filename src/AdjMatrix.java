import java.util.ArrayList;

public class AdjMatrix extends Graphs{

    private double[][] matrix;

    public AdjMatrix() {
        this.vertices = new ArrayList<Vertex>();
        matrix = new double[0][0];
    }

    @Override
    public Vertex addVertex(String name) {
        Vertex newVertex = null;

        if (isVertex(name)) {
            newVertex = nameVertex(name);
        } else {
            newVertex = new Vertex(name);
            vertices.add(newVertex);

            int size = vertices.size();
            double[][] newMatrix = new double[size][size];

            for (int x = 0; x < size - 1; x++) {
                for (int y = 0; y < size - 1; y++) {
                    newMatrix[x][y] = matrix[x][y];
                }
            }
            matrix = newMatrix;
        }
        return newVertex;

    }

    @Override
    public void addEdge(String from, String to, double weight) {
        Vertex start = addVertex(from);
        Vertex goal = addVertex(to);

        int startIndex = vertices.indexOf(start);
        int goalIndex = vertices.indexOf(goal);

        matrix[startIndex][goalIndex] = weight;
        matrix[goalIndex][startIndex] = weight;

    }

    @Override
    public void printGraph() {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                System.out.print(matrix[x][y] + " ");

            }
            System.out.println();

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
