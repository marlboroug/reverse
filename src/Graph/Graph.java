package Graph;

import java.util.Arrays;
import java.util.HashSet;

class Graph
{
    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };

    // A class to represent a subset for union-find
    class subset {
        int parent, rank;
    };

    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges

    // Creates a graph with V vertices and E edges
    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(subset subsets[], int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST() {
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<V; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                               result[i].weight);
    }

    // Driver Program
    public static void main (String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] edges = new HashSet[numCourses];
        for (int i = 0 ; i < numCourses; i++) {
            edges[i] = new HashSet<Integer>();
        }
        for (int[] temp : prerequisites) {
            HashSet a = edges[temp[0]];
            a.add(temp[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            boolean[] visit = new boolean[numCourses];
            boolean[] resTack = new boolean[numCourses];
            if (isRecyle(i, edges, visit, resTack)) {
                return false;
            }
        }
        return true;
  }
  public boolean isRecyle(int i,HashSet<Integer>[] edges, boolean[] visit, boolean[] resTack) {
      if (visit[i] == false) {
	          visit[i] = true;
	          resTack[i] = true;
	          HashSet<Integer> pre = edges[i];
	          for (int id : pre) {
	              if (! visit[id] && isRecyle(id, edges, visit, resTack) ) {
	                  return true;
	              } else if (resTack[id]) {
	                  return true;
	              }
	          }
      }
      resTack[i] = false;
      return false;
  }
  
  
  
/*  bool Graph::isCyclicUtil(int v, bool visited[], bool *recStack)
  {
      if(visited[v] == false)
      {
          // Mark the current node as visited and part of recursion stack
          visited[v] = true;
          recStack[v] = true;

          // Recur for all the vertices adjacent to this vertex
          list<int>::iterator i;
          for(i = adj[v].begin(); i != adj[v].end(); ++i)
          {
              if ( !visited[*i] && isCyclicUtil(*i, visited, recStack) )
                  return true;
              else if (recStack[*i])
                  return true;
          }

      }
      recStack[v] = false;  // remove the vertex from recursion stack
      return false;
  }

  // Returns true if the graph contains a cycle, else false.
  // This function is a variation of DFS() in http://www.geeksforgeeks.org/archives/18212
  bool Graph::isCyclic()
  {
      // Mark all the vertices as not visited and not part of recursion
      // stack
      bool *visited = new bool[V];
      bool *recStack = new bool[V];
      for(int i = 0; i < V; i++)
      {
          visited[i] = false;
          recStack[i] = false;
      }

      // Call the recursive helper function to detect cycle in different
      // DFS trees
      for(int i = 0; i < V; i++)
          if (isCyclicUtil(i, visited, recStack))
              return true;

      return false;
  }*/

    
}
//This code is contributed by Aakash Hasija