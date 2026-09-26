class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }
        return topologicalSort(numCourses,result,adj);
    }
    private int[] topologicalSort(int numCourses,int[] result,ArrayList<ArrayList<Integer>> adj) {
    int[] indegree = new int[numCourses];
      for(int i =0;i<numCourses;i++) {
        for(int nbr:adj.get(i)) {
            indegree[nbr]++;
        } 
      }
      Queue<Integer>qu = new LinkedList<>();
      for(int i=0;i<numCourses;i++) {
        if(indegree[i] ==0) {
            qu.offer(i);
        }
      }
      int i=0;
      while(!qu.isEmpty()) {
        int node = qu.poll();
        result[i] = node;
        i++;
        for(int nbr:adj.get(node)) {
            indegree[nbr]--;
            if(indegree[nbr] ==0) {
                qu.offer(nbr);
            }
        }
      }
      if (i != numCourses) {
            return new int[0];
        }
      return result;
    }
}