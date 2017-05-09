package suffix;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class Graph {
	private int V;
	private LinkedList<Integer>[] adj;   
    Graph(int v){
		V = v;
		adj = new LinkedList[V];
		for(int i = 0;i < V;i++)
			adj[i]=new LinkedList<Integer>();
	}
	void addEdge(int v,int w){
			adj[v].add(w);
    }
	boolean isCyclicUtilDirected(int v, boolean visited[],boolean recStack[])
		{
	   if(visited[v]==false){
			visited[v]=true;
			recStack[v]=true;
			Iterator<Integer> iter=adj[v].iterator();
			while(iter.hasNext()){
				int i=iter.next();
				if(visited[i]==false&&isCyclicUtilDirected(i,visited,recStack))
					return true;
				else if (recStack[i])
					return true;
			}
	   }
			recStack[v]=false;
			return false;
	}
     boolean isCyclicDirected(){
			boolean visited[]=new boolean [V];
			boolean recStack[]=new boolean[V];
			for(int i=0;i<V;i++){
				if(isCyclicUtilDirected(i,visited,recStack))
					return true;
			}
			return false;
	}
   public static void main (String[] args)  {
     Scanner sc = new Scanner(System.in);
	 int ns = sc.nextInt();
	 Graph gp = new Graph(ns);
	 int m = sc.nextInt();
     int n1 = 0;
     int n2 = 0;
	 while(m > 0){
    	n1 =  sc.nextInt();
    	n2 = sc.nextInt();
    	gp.addEdge(n1, n2);
		m--;
	 }
	 System.out.println(gp.isCyclicDirected());
   }
}
