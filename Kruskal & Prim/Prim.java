
import java.util.*;
import java.util.ArrayList;


class Edge implements Comparable<Edge> {
    int from, to, cost;
 
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
 
    @Override // Prioirty Queue 우선순위 큐를 사용하기 위한 함수 오버라이딩
   public int compareTo(Edge e) {  
        return this.cost - e.cost;
    }
}

class Graph {
    List<Edge>[] edge;
 
    public Graph(int V) {
        edge = new LinkedList[V];
 
        for (int i=0; i < V; i++)
            edge[i] = new LinkedList<>();
    }
 
    // 양방향 그래프
    public void addEdge(int from, int to, int cost) {
        edge[from].add(new Edge(from, to, cost));
        edge[to].add(new Edge(to, from, cost));
    }

}

public class Prim {
    static int V, E, min = 0;
    static Graph g1;
    static boolean[] visited;//방문했는지 표시
    static ArrayList<Edge> mst; //mst간선을 가짐
    
    public static void Prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 가중치가 낮은 순대로 간선을 정렬할 우선순위
        Queue<Integer> queue = new LinkedList<>();      // 정점방문 스케줄 처리를 위한 큐
 
        queue.add(0);                                   // 정점 1을 시작정점으로 선택
 
        while (!queue.isEmpty()) {
            int from = queue.poll();
            visited[from] = true;
 
            for (Edge edge : g1.edge[from]) {        // 현재 정점 from과 연결된 간선 중
                if (!visited[edge.to]) {                // 아직 정점 to를 방문하지 않았다면
                    pq.add(edge);                       // 우선순위 큐에 간선을 추가한다. 우선순위큐이므로 작은것에서 큰 간선으로정렬
                }
            }
 
            while (!pq.isEmpty()) {// edges are in pq 
                Edge edge = pq.poll();                  // 가중치가 가장 적은 간선이 나올 것이며,
                if (!visited[edge.to]) {                // 간선이 연결된 정점 to를 방문한 적이 없다면,
                   queue.add(edge.to);                 // 큐에 삽입하여 다음에 방문한다.
                    visited[edge.to] = true;            // 방문했던 정점을 다시 방문하지 않도록 방문표시.
                    mst.add(edge);                      // 최소 스패닝 트리를 구성하는 간선 추가.
                    min += edge.cost;                   // 총 최소 가중치 합을 구하기 위해 덧셈.
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        V = 14;
        E = 9;
        visited = new boolean[V];
        mst = new ArrayList<>();
        g1 = new Graph(V);
 
        g1.addEdge(0, 1, 8);
        g1.addEdge(0, 7, 5);
        g1.addEdge(0, 5, 10);
        g1.addEdge(1, 5, 4);
        g1.addEdge(1, 7, 4);
        g1.addEdge(1, 2, 4);
        g1.addEdge(1, 4, 4);
        g1.addEdge(2, 5, 3);
        g1.addEdge(2, 3, 3);
        g1.addEdge(3, 4, 1);
        g1.addEdge(3, 5, 6);
        g1.addEdge(3, 6, 2);
        g1.addEdge(4, 6, 3);
        g1.addEdge(6, 7, 3);
        
        Prim();
 
        for (Edge edge : mst) {
            System.out.println(edge.from + " - " + edge.to + " cost : " + edge.cost);
        }
 
        System.out.println(min);
    }
 
  
}
 
