
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayOfListGraph {
    //stores the number of vertices   

    private int vertices;
    //creates a linked list for the adjacency list of the graph   

    private LinkedList<Integer> adjlist[];
    //creating a constructor of the Graph class   

    ArrayOfListGraph(int count_v) {
        //assigning the number of vertices to the passed parameter  
        vertices = count_v;
        adjlist = new LinkedList[count_v];

        //loop for creating the adjacency lists  
        for (int i = 0; i < count_v; ++i) {
            adjlist[i] = new LinkedList();
        }
    }
//method that adds a new edge to the graph  

    void addNewEdge(int v, int w) {
        adjlist[v].add(w);
    }

    void traversalDFS(int v, boolean vnodelist[]) {
        //if current node (root node) is visited, add it to the vnodelist   
        vnodelist[v] = true;
        System.out.print(v + " ");
        //determines the negihboring nodes of the current node  
        //iterates over the list    
        Iterator<Integer> i = adjlist[v].listIterator();
        while (i.hasNext()) {
            //returns the next element in the iteration and store that element in the variable n      
            int n = i.next();
            if (!vnodelist[n]) //calling the function that performs depth first traversal    
            {
                traversalDFS(n, vnodelist);
            }
        }
    }

    void DFS(int v) {
        //creates an array of boolean type for visited node   
        //initially all nodes are unvisited  
        boolean visited[] = new boolean[vertices];

        //call recursive traversalDFS() function for DFS   
        traversalDFS(v, visited);
    }
    //traversal starts from the root node   

    void traversalBFS(int rnode) {
        //creates an array of boolean type for visited node   
        //initially all nodes are unvisited  
        boolean visitednode[] = new boolean[vertices];

        //creating another list for storing the visited node  
        LinkedList<Integer> vnodelist = new LinkedList<Integer>();

        //if current node (root node) is visited, add it to the vnodelist   
        visitednode[rnode] = true;

        //inserts the visited node into vnodelist  
        vnodelist.add(rnode);

        //the while loop executes until we have visited all the nodes  
        while (vnodelist.size() != 0) {
            //deque an entry from queue and process it    
            //the poll() method retrieves and removes the head (first element) of this list  
            rnode = vnodelist.poll();
            System.out.print(rnode + " ");

            //detrmines the negihboring nodes of the current node  
            //iterates over the list   
            Iterator<Integer> i = adjlist[rnode].listIterator();
            while (i.hasNext()) {
                //returns the next element in the iteration and store that element in the variable n      
                int n = i.next();

                //checks the next node is visited or not  
                if (!visitednode[n]) {
                    //if the above if-statement returns true, visits the node   
                    visitednode[n] = true;
                    //adds the visited node in the vnodelist  
                    vnodelist.add(n);
                }
            }
        }
    }
}
