import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class P3Q1 {

    public static void main(String[] args) {
        class Edge implements Comparable<Edge>{
            int start, end, weight;
            public Edge(String[] edge_input) {
                start = Integer.parseInt(edge_input[0]);
                end = Integer.parseInt(edge_input[1]);
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

        }

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        float t = Float.parseFloat(scan.nextLine());
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(scan.nextLine().split(" "));
        }
        
    }
}