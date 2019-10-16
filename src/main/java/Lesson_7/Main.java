package Lesson_7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

//        graph.addEdge(1,2);
//        graph.addEdge(0,4);
//        graph.addEdge(1,4);

//        System.out.println(graph.getAdjList(1));

        //-------- Создаю граф с рисунка вручную -------------

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(5,5);
        graph.addEdge(5,7);
        graph.addEdge(2,9);
        graph.addEdge(2,4);
        graph.addEdge(3,8);
        graph.addEdge(4,6);
        graph.addEdge(9,6);
        graph.addEdge(6,8);
        graph.addEdge(6,7);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.pathTo(6));
    }
}
