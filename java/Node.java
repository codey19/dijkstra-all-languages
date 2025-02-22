public class Node implements Comparable<Node>{
    private String name;
    private int weight;
    public Node(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Node o) {
        if(this.name.equals(o.getName()))
            return this.weight - o.getWeight();
        return this.name.compareTo(o.getName());

    }
}