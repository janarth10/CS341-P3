import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class P3Q1 {

    public static void main(String[] args) {
        class Edge{
            int start, end, weight;
            public Edge(String[] edge_input) {
                start = Integer.parseInt(edge_input[0]);
                end = Integer.parseInt(edge_input[1]);
                weight = Integer.parseInt(edge_input[2]);
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