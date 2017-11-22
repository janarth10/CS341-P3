import java.util.*;
import java.util.Scanner;
import java.util.Vector;


public class P3Q1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        double t = Double.parseDouble(scan.nextLine());

        class Edge {
            int start, end, weight;
            public Edge(){}

            public Edge(String[] edge_input) {
                start = Integer.parseInt(edge_input[0]);
                end = Integer.parseInt(edge_input[1]);
                if (end < start){
                    int a = end;
                    end = start;
                    start = a;
                }
                weight = Integer.parseInt(edge_input[2]);
            }

            public String toString(){
                return String.format("start: %d, End: %d, Weight: %d", start, end, weight);
            }

            public String edgePointsToString(){
                return String.format("%d %d", start, end);
            }

            // Calculate shortest path using Bellman Ford's algo given edges in H
            public int shortest_path(Vector<Edge> H, int source, int end){
                int[] distances = new int[n+1];
                Arrays.fill(distances, Integer.MAX_VALUE);
                distances[source] = 0;

                int u, v = 0;
                boolean valueChange = false;
                for(int i = 0; i < n; i++){
                    valueChange = false;
                    for(Edge e: H){
                        u = e.start;
                        v = e.end;
                        if(v != source) {
                            distances[v] = Math.min(distances[v],
                                    Math.max(distances[u], distances[u] + e.weight));
                            valueChange = true;
                        }
                        if(u != source){
                            distances[u] = Math.min(distances[u],
                                    Math.max(distances[v], distances[v] + e.weight));
                            valueChange = true;
                        }
                    }
                    if(valueChange == false){
                        break;
                    }
                }

//                System.out.println(H);
//                System.out.printf("%d %d", source, end);
//                System.out.println("");
//                System.out.println(Arrays.toString(distances));
                return distances[end];
            }
        }

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(scan.nextLine().split(" "));
        }

        // start of algo A
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        Vector<Edge> H = new Vector<>();
        int weightOfH = 0;
        int d = 0;
        Edge dummy = new Edge(); // used solely to call shortest_path()
        for(int i = 0; i < m; i++){
            d = dummy.shortest_path(H, edges[i].start, edges[i].end);
            if(t * edges[i].weight < d){
                H.add(edges[i]);
                weightOfH += edges[i].weight;
            }
        }

        // sorting according to output req specified in assignment
        H.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if(e1.start == e2.start){
                    return e1.end - e2.end;
                }
                return e1.start - e2.start;
            }
        });

        // solution
        System.out.println(H.size());
        System.out.println(weightOfH);
        for(Edge e: H){
            System.out.println(e.edgePointsToString());
        }
    }
}