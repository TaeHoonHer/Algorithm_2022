import java.util.ArrayList;
import java.util.Collections;
 
//Comparable 은 정렬을 위해서
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
 
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
 
    @Override
    public int compareTo(Edge o) {  // cost를 가지고 정렬을 하겠다고 기준을 만듬
        if (this.cost < o.cost) {
            return - 1;
        }
        else if (this.cost == o.cost) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
 
public class Kruskal_1 {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x != y) {
            parent[y] = x;
        }
    }
 
    public static int find(int x) {  // 부모 노드 찾는 메소드
        if (parent[x] == x) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    //same parent means cycle
    public static boolean isSameParent(int x, int y) {
        x = find(x);  // find 메소드를 통해서 부모 노드 번호를 리턴 받음
        y = find(y);
 
        if (x == y) {
            return true;
        }
        else {
            return false;
        }
    }
 
    public static void main(String[] args) {
        edgeList = new ArrayList<Edge>();
 
        edgeList.add(new Edge(0, 1, 5));
        edgeList.add(new Edge(0, 2, 4));
        edgeList.add(new Edge(1, 2, 2));
        edgeList.add(new Edge(1, 3, 7));
        edgeList.add(new Edge(2, 3, 6));
        edgeList.add(new Edge(3, 4, 3));
        edgeList.add(new Edge(3, 5, 8));
        edgeList.add(new Edge(4, 5, 8));
        
 
        parent = new int[8];
 
        for (int i = 1; i <= 7; ++i) {
            parent[i] = i;
        }
 
        Collections.sort(edgeList);// 간선들을 정렬
 
        
        System.out.println("입력된 가중치 그래프의 값(정점A-정점B-가중치)");
        for (int i = 0; i < edgeList.size(); ++i) {
            Edge edge = edgeList.get(i);
            	System.out.print(" "+"(" + edge.v1 + "-" + edge.v2 + "-" + edge.cost + ")");
            
        }
        System.out.println();
        
        int sum = 0;
        System.out.println("최소 비용 간선(정점A-정점B-가중치)");
        for (int i = 0; i < edgeList.size(); ++i) {
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)) {// no cycle
            	System.out.print(" "+"(" + edge.v1 + "-" + edge.v2 + "-" + edge.cost + ")");
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }
        System.out.println();
      
        System.out.println("총합 : " + sum);
    }
}
