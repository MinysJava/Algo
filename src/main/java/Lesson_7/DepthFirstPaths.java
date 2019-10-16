package Lesson_7;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph g, int source) {
        this.source = source;
        if( source < 0 || source >= g.getVertexCount()){
            throw new IllegalArgumentException("Заданна неверная вершина");
        }
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        dfs(g,source);
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    private void dfs(Graph g, int v){
        marked[v] = true;
        for (int w : g.getAdjList(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, v);
            }
        }
    }
}
