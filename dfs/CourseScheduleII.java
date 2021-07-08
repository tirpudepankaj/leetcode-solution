import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CourseScheduleII
{

 private Map<Integer, List<Integer>> adjList = new HashMap<>();
 private Map<Integer, Integer> color = new HashMap<>();
 private List<Integer> topologicalOrder = new ArrayList<>();

 private int WHITE = 1;
 private int GRAY = 2;
 private int BLACK = 3;

 private boolean possible = true; 


  private void init(int numCourses)
  {
    for(int i = 0; i < numCourses; i++)
      color.put(i, WHITE);
  }

  private void dfs(int node)
  {
     if(possible == false) return;

     color.put(node, GRAY);

     for(int neighbor : adjList.getOrDefault(node,new ArrayList<>()))
     {
        if(color.get(neighbor) == GRAY) possible = false;
        else if(color.get(neighbor) == WHITE) dfs(neighbor);
     }
    
     color.put(node, BLACK);
     topologicalOrder.add(node);
     
  } 

  public int[] findOrder(int numCourses, int[][] prerequisites)
  {
     init(numCourses);
     
     for(int i = 0; i < prerequisites.length; i++)
     {
        int source = prerequisites[i][1];
        int dest =   prerequisites[i][0];
        
        List<Integer> list = adjList.getOrDefault(source, new ArrayList<>());
        list.add(dest);
       
        adjList.put(source, list);
     }  

     for(int i = 0; i < numCourses; i++)
     {
        if(color.get(i) == WHITE) dfs(i);
     }

     if(possible)
     {
        int order[] = new int [numCourses];

        for(int i = 0; i < numCourses; i++)
         order[i] = topologicalOrder.get(numCourses - i  - 1);
        
        return order; 
     }

     return new int[0]; 
     
  }
}


