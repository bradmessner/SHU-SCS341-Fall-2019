import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpanningTree {

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }

    static class Tree {
        int vertex;
        ArrayList<Edge> edges = new ArrayList<>();

        public Tree(int vertex){
            this.vertex = vertex;
        }

        public void inputEdges(int start, int end, int weight){
            Edge edge = new Edge(start,end,weight);
            edges.add(edge);
        }

        public void minSpanTree(){
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(edges.size(), Comparator.comparingInt(comp -> comp.weight));

            for (int i = 0; i <edges.size(); i++) {
                priorityQueue.add(edges.get(i));
            }

            int [] parentPointer = new int[vertex];

            ArrayList<Edge> minTree = new ArrayList<>();

        }

    }

    public static void main(String[] args) {

        int[] startNum = {0, 0, 1, 2, 2};
        int[] endNum = {1, 2, 3, 4, 5};
        int[] weight = {4, 2, 10, 1, 5};
        int vertices = 4;

        Tree tree = new Tree(vertices);

        for (int i = 0; i<startNum.length; i++){
            tree.inputEdges(startNum[i],endNum[i],weight[i]);
        }

        tree.minSpanTree();
    }
}

