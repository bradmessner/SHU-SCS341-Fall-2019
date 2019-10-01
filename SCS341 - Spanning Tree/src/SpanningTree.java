import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue;

public class SpanningTree {


    public static void main(String[] args) {

        // input graph information
        int[] startNum = {0, 1, 1, 2, 5, 3, 4};
        int[] endNum = {2, 2, 4, 3, 1, 4, 5};
        int[] weight = {10, 5, 1, 7, 4, 2, 6};
        int vertices = 6;

        Tree tree = new Tree(vertices);

        for (int i = 0; i<startNum.length; i++){
            tree.inputEdges(startNum[i],endNum[i],weight[i]);
        }

        tree.minSpanTree();
    }

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

        // contains all of the edges
        ArrayList<Edge> edges = new ArrayList<>();

        public Tree(int vertex){
            this.vertex = vertex;
        }

        public void inputEdges(int start, int end, int weight){
            // add new edge values to list
            Edge edge = new Edge(start,end,weight);
            edges.add(edge);
        }

        public void minSpanTree(){
            // create iterator
            int iter = 0;
            // create new array for
            int [] parentPointer = new int[vertex];
            // create another list for clean and ordered numbers.
            ArrayList<Edge> minTree = new ArrayList<>();
            // FIFO
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(edges.size(), Comparator.comparingInt(comp -> comp.weight));

            // add to queue sort by weight by ascending order
            for (int i = 0; i <edges.size(); i++) {
                priorityQueue.add(edges.get(i));
            }

            for (int i = 0; i <vertex ; i++) {
                parentPointer[i] = i;
            }

            //checks for cycle / recursion might eliminate this process
            while(iter<vertex-1){
                Edge edge = priorityQueue.remove();

                int x = getEdgePair(parentPointer, edge.start);
                int y = getEdgePair(parentPointer, edge.end);

                if(x==y){
                    //this is a cycle
                } else {
                    // add to new array
                    minTree.add(edge);
                    iter++;
                    difference(parentPointer,x,y);
                }
            }
            // show mst results of graph
            showMinTree(minTree);
        }

        // show results.
        public void showMinTree(ArrayList<Edge> list){
            System.out.println("the Minimum Spanning Tree of this graph is: ");
            for (int i = 0; i <list.size() ; i++) {
                Edge edge = list.get(i);
                System.out.println(i + ": starting point: " + edge.start +
                        " ending point: " + edge.end +
                        " weight: " + edge.weight);
            }
        }

        public void difference(int [] parent, int x, int y){
            int xParent = getEdgePair(parent, x);
            int yParent = getEdgePair(parent, y);
            //make x as parent of y
            parent[yParent] = xParent;
        }


        public int getEdgePair(int [] parent, int v){
            if(parent[v]!=v)
                return getEdgePair(parent, parent[v]);
            return v;
        }


    }

}

