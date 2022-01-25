package com.tyler.datastructures.lesson13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyMapGraph {
    private boolean isDirected;
    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge> edges = new LinkedList<>();

    public AdjacencyMapGraph(boolean directed) {
        isDirected = directed;
    }

    public int numVertices() {
        return vertices.size();
    }

    public Iterable<Vertex> vertices() {
        return vertices;
    }

    public int numEdges() {
        return edges.size();
    }

    public Iterable<Edge> edges() {
        return edges;
    }

    public Edge getEdge(Vertex u, Vertex v) {
        return u.getOutgoing().get(v);
    }

    public Vertex addVertex(Vertex v) {
        vertices.add(v);
        return v;
    }

    public Edge addEdge(Vertex u, Vertex v, int weight) {
        if (getEdge(u,v) == null) {
            Edge newEdge = new Edge(u, v, weight);
            edges.add(newEdge);
            u.getOutgoing().put(v, newEdge);
            v.getIncoming().put(u, newEdge);
            return newEdge;
        } else {
            throw new IllegalArgumentException("Edge from u to v already exists!");
        }
    }

    private Vertex validateVertex(Vertex v) {
        if (vertices.contains(v)) {
            return v;
        } else {
            return null;
        }
    }

    public Iterable<Edge> incomingEdges(Vertex v) throws IllegalArgumentException {
        return v.getIncoming().values();   // edges are the values in the adjacency map
    }

    /**
     * Returns an iterable collection of edges for which vertex v is the origin.
     * Note that for an undirected graph, this is the same result
     * returned by incomingEdges(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public Iterable<Edge> outgoingEdges(Vertex v) throws IllegalArgumentException {
        return v.getOutgoing().values();   // edges are the values in the adjacency map
    }

    /** Returns the vertex that is opposite vertex v on edge e. */
    public Vertex opposite(Vertex v, Edge e) throws IllegalArgumentException {
        Vertex[] endpoints = e.getEndpoints();
        if (endpoints[0] == v)
            return endpoints[1];
        else if (endpoints[1] == v)
            return endpoints[0];
        else
            throw new IllegalArgumentException("v is not opposite to this edge");
    }

    /**
     * Returns the number of edges for which vertex v is the destination.
     * Note that for an undirected graph, this is the same result
     * returned by outDegree(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public int inDegree(Vertex v) throws IllegalArgumentException {
        return v.getIncoming().size();
    }

    /**
     * Returns the number of edges for which vertex v is the origin.
     * Note that for an undirected graph, this is the same result
     * returned by inDegree(v).
     * @throws IllegalArgumentException if v is not a valid vertex
     */
    public int outDegree(Vertex v) throws IllegalArgumentException {
        return v.getOutgoing().size();
    }

    /**
     * Returns a string representation of the graph.
     * This is used only for debugging; do not rely on the string representation.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
//     sb.append("Edges:");
//     for (Edge<E> e : edges) {
//       Vertex<V>[] verts = endVertices(e);
//       sb.append(String.format(" (%s->%s, %s)", verts[0].getElement(), verts[1].getElement(), e.getElement()));
//     }
//     sb.append("\n");
        for (Vertex v : vertices) {
            sb.append("Vertex " + v.getElement() + "\n");
            if (isDirected)
                sb.append(" [outgoing]");
            sb.append(" " + outDegree(v) + " adjacencies:");
            for (Edge e: outgoingEdges(v))
                sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getWeight()));
            sb.append("\n");
            if (isDirected) {
                sb.append(" [incoming]");
                sb.append(" " + inDegree(v) + " adjacencies:");
                for (Edge e: incomingEdges(v))
                    sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getWeight()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
