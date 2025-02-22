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
        NeighborhoodMap.readIn(graph, args[0]);
        //output
        String startHouse = args[1];
        StdOut.setFile(args[2]);
        HashMap<String, Integer> minDistanceTo = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        dijkstrasAlgorithm(graph, minDistanceTo, parent, startHouse);

        for(Map.Entry<String, String> entry : parent.entrySet())
            StdOut.println(entry.getKey() + " " + entry.getValue());
    }
    public static void dijkstrasAlgorithm(Graph graph, HashMap<String, Integer> minDistanceTo, HashMap<String, String> parent, String startHouse){
        PriorityQueue<House> minHeap = new PriorityQueue<>();
        HashSet<String> visited = new HashSet<>();
        minHeap.add(new House(startHouse, 0));
        for(String e: graph.getAdjacencies().keySet())
            minDistanceTo.put(e, Integer.MAX_VALUE);
        minDistanceTo.put(startHouse, 0);
        while(!minHeap.isEmpty()){
            House temp = minHeap.poll();
            visited.add(temp.getName());
            
            for(House e: graph.getAdjacencies().get(temp.getName())){
                if(!visited.contains(e.getName())){
                    int dist = minDistanceTo.get(temp.getName()) + e.getWeight();
                    if(minDistanceTo.get(e.getName()) > dist){
                        minHeap.remove(new House(e.getName(), minDistanceTo.get(e.getName())));
                        minHeap.add(new House(e.getName(), dist));
                        minDistanceTo.put(e.getName(), dist);
                        parent.put(e.getName(), temp.getName());
                    }
                }
            }
        }
        parent.put(startHouse, null);
    }
}
