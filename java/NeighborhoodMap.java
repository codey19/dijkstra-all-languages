import java.util.ArrayList;
import java.util.Map;

public class NeighborhoodMap {
    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println(
                    "Too few arguments. Did you put in command line arguments? If using the debugger, add args to launch.json.");
            StdOut.println(
                    "Execute: java -cp bin trick.NeighborhoodMap <neighborhoodmap INput file> <neighborhoodmap OUTput file>");
            return;
        }

       // WRITE YOUR CODE HERE
        Graph graph = new Graph();
        readIn(graph, args[0]);
        //output
        StdOut.setFile(args[1]);
        for(Map.Entry<String, ArrayList<Candy>> entry : graph.getCandies().entrySet()){
            String key = entry.getKey();
            ArrayList<Candy> value = entry.getValue();
            StdOut.print(key);
            for(Candy e: value)
                StdOut.print(" " + e + " " + e.getCount());
            StdOut.println();
        }

        for (Map.Entry<String, ArrayList<House>> entry: graph.getAdjacencies().entrySet()){
            String key = entry.getKey();
            ArrayList<House> value = entry.getValue();
            StdOut.print(key);
            for(House e: value)
                StdOut.print(" " + e.getName() + " " + e.getWeight());
            StdOut.println();
        }
        StdOut.print(" ");
    }

    public static void readIn(Graph graph, String inputFileName){
        StdIn.setFile(inputFileName);
        int numHouses = Integer.parseInt(StdIn.readLine());
        for(int i = 0; i < numHouses; i++){
            String line = StdIn.readLine();
            String[] temp = line.split(" ");
            ArrayList<Candy> candies = new ArrayList<>();
            for(int j = 0; j < Integer.parseInt(temp[1]); j++)
                candies.add(new Candy(temp[2 + j*2], Integer.parseInt(temp[3 + j*2])));//issue
            graph.getCandies().put(temp[0], candies);
        }
        int numEdges = Integer.parseInt(StdIn.readLine());
        for(int i = 0; i < numEdges; i++){
            String line = StdIn.readLine();
            String[] temp = line.split(" ");
            graph.addEdge(temp[0], temp[1], Integer.parseInt(temp[2]));
        }
    }
}
