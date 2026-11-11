import java.util.ArrayList;

public abstract class Graphs {
    protected ArrayList<Vertex> vertices;


    public abstract Vertex addVertex(String n);


    public abstract void addEdge(String from, String to, double weight);


    public abstract void printGraph();

    public abstract boolean isVertex(String name);
}
