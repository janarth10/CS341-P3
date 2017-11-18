import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.Vector;


public class P3Q1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        float t = Float.parseFloat(scan.nextLine());

        class Edge implements Comparable<Edge>{
            int start, end, weight;
            public Edge(){}

            public Edge(String[] edge_input) {
                int a = Integer.parseInt(edge_input[1]);
                start = Integer.parseInt(edge_input[0]);
                end = a;
                if (a < start){
                    end = start;
                    start = a;
                }
                weight = Integer.parseInt(edge_input[2]);
            }

            @Override
            public int compareTo(Edge e){
                if (weight < e.weight){
                    return -1;
                }
                return 1;
            }

            public String toString(){
                return String.format("start: %d, End: %d, Weight: %d", start, end, weight);
            }

            // Calculate shortest path using Bellman Ford's algo
            public int shortest_path(Vector<Edge> H, int source, int v){
                int[] distances = new int[n+1];
                Arrays.fill(distances, Integer.MAX_VALUE);
                distances[source] = 0;

                for(int i = 0; i < n; i++){
                    for(Edge e: H){
                        distances[e.end] = Math.min(distances[e.end],
                                            distances[e.start] + e.weight);
                    }
                }

                return distances[v];
            }
        }

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(scan.nextLine().split(" "));
        }

        //start of algo A
        Arrays.sort(edges);
        Vector<Edge> H = new Vector<Edge>();
        Edge dummy = new Edge();
        for(int i = 0; i < m; i++){
            int d = dummy.shortest_path(H, edges[i].start, edges[i].end);
            if(t * edges[i].weight < d){
                H.add(edges[i]);
            }
        }

        System.out.println(H);
    }
}