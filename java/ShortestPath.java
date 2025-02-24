import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println(
                    "Too few arguments. Did you put in command line arguments? If using the debugger, add args to launch.json.");
            StdOut.println(
                    "Execute: java -cp bin trick.ShortestPath input1.in h1 shortestpaths1.out");
            return;
        }
        // WRITE YOUR CODE HERE
        Graph graph = new Graph();
        readIn(graph, args[0]);
        //output
        String startNode = args[1];
        StdOut.setFile(args[2]);
        HashMap<String, Integer> minDistanceTo = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        dijkstrasAlgorithm(graph, minDistanceTo, parent, startNode);

        for(Map.Entry<String, String> entry : parent.entrySet())
            StdOut.println(entry.getKey() + " " + entry.getValue());
    }
    public static void dijkstrasAlgorithm(Graph graph, HashMap<String, Integer> minDistanceTo, HashMap<String, String> parent, String startNode){
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        HashSet<String> visited = new HashSet<>();
        minHeap.add(new Node(startNode, 0));
        for(String e: graph.getAdjacencies().keySet())
            minDistanceTo.put(e, Integer.MAX_VALUE);
        minDistanceTo.put(startNode, 0);
        while(!minHeap.isEmpty()){
            Node temp = minHeap.poll();
            visited.add(temp.getName());
            
            for(Node e: graph.getAdjacencies().get(temp.getName())){
                if(!visited.contains(e.getName())){
                    int dist = minDistanceTo.get(temp.getName()) + e.getWeight();
                    if(minDistanceTo.get(e.getName()) > dist){
                        minHeap.remove(new Node(e.getName(), minDistanceTo.get(e.getName())));
                        minHeap.add(new Node(e.getName(), dist));
                        minDistanceTo.put(e.getName(), dist);
                        parent.put(e.getName(), temp.getName());
                    }
                }
            }
        }
        parent.put(startNode, null);
    }

    public static void readIn(Graph graph, String inputFileName){
        StdIn.setFile(inputFileName);
        int numNodes = Integer.parseInt(StdIn.readLine());
        int numEdges = Integer.parseInt(StdIn.readLine());
        for(int i = 0; i < numEdges; i++){
            String line = StdIn.readLine();
            String[] temp = line.split(" ");
            graph.addEdge(temp[0], temp[1], Integer.parseInt(temp[2]));
        }
    }
}
