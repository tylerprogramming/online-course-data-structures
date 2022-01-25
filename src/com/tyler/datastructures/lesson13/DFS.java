package com.tyler.datastructures.lesson13;

import java.util.Set;

public class DFS {
    public void dfs(AdjacencyMapGraph g, Vertex u, Set<Vertex> visited) {
        visited.add(u);
        System.out.print(u.getElement() + " - ");

        for (Edge e : g.outgoingEdges(u)) {
            Vertex v = g.opposite(u, e);

            if (!visited.contains(v)) {
                dfs(g, v, visited);
            }
        }
    }
}
