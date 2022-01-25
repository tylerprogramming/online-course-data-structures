package com.tyler.datastructures.lesson13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    private Set<Vertex> visited = new HashSet<>();
    Queue<Vertex> queue = new LinkedList<>();

    public void bfs(AdjacencyMapGraph g, Vertex u) {
        visited.add(u);
        queue.add(u);

        while (!queue.isEmpty()) {
            u = queue.remove();
            System.out.print(u.getElement() + " : ");
            for (Edge e : g.outgoingEdges(u)) {
                Vertex vertex = g.opposite(u, e);

                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    queue.add(vertex);
                }
            }
        }
    }
}
