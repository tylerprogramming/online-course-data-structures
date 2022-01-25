package com.tyler.datastructures.lesson13;

import java.util.HashSet;
import java.util.Set;

public class GraphTester {
    public void run() {
        AdjacencyMapGraph graph = new AdjacencyMapGraph(true);
        Vertex zero = new Vertex("0", true);
        Vertex one = new Vertex("1", true);
        Vertex two = new Vertex("2", true);
        Vertex three = new Vertex("3", true);
        Vertex four = new Vertex("4", true);
        Vertex five = new Vertex("5", true);

//        graph.addVertex(zero);
//        graph.addVertex(one);
//        graph.addVertex(two);
//        graph.addVertex(three);
//        graph.addVertex(four);
////        graph.addVertex(five);
//        graph.addEdge(zero, one, 1);
//        graph.addEdge(zero, two, 1);
//        graph.addEdge(zero, three, 1);
//        graph.addEdge(two, four, 1);
//        graph.addEdge(two, five, 1);
//        graph.addEdge(three, five, 1);
        graph.addEdge(zero, one, 1);
        graph.addEdge(zero, four, 1);
        graph.addEdge(zero, five, 1);
        graph.addEdge(one, three, 1);
        graph.addEdge(one, four, 1);
        graph.addEdge(three, two, 1);
        graph.addEdge(three, four, 1);

        Set<Vertex> visited = new HashSet<>();
        DFS dfs = new DFS();
        dfs.dfs(graph, zero, visited);

        System.out.println();

        BFS bfs = new BFS();
        bfs.bfs(graph, zero);
    }
}
