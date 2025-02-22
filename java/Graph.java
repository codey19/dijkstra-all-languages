import java.util.*;

public class Graph {
    private HashMap<String, ArrayList<Node>> adjacencies;
    
    public Graph() {
        this.adjacencies = new HashMap<>();
    }

    public Graph(HashMap<String, ArrayList<Node>> adjacencies) {
        this.adjacencies = adjacencies;
    }

    public HashMap<String, ArrayList<Node>> getAdjacencies() {
        return adjacencies;
    }

    public void setadjacencies(HashMap<String, ArrayList<Node>> adjacencies) {
        this.adjacencies = adjacencies;
    }
    
    public void addEdge(String vertex1, String vertex2, int weight){
        // adjacencies.put(edge.getName(), adjacencies.getOrDefault(edge.getName(), 0) + 1);
        if(adjacencies.containsKey(vertex1)){
            adjacencies.get(vertex1).add(new Node(vertex2, weight));
        }else{
            ArrayList<Node> temp = new ArrayList<>();
            temp.add(new Node(vertex2, weight));
            adjacencies.put(vertex1, temp);
        }

        if(adjacencies.containsKey(vertex2)){
            adjacencies.get(vertex2).add(new Node(vertex1, weight));
        }else{
            ArrayList<Node> temp = new ArrayList<>();
            temp.add(new Node(vertex1, weight));
            adjacencies.put(vertex2, temp);
        }
    }

    public ArrayList<Node> getAdjacent(Node vertex){
        return adjacencies.get(vertex.getName());
    }

    
}
