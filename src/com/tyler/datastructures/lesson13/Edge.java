package com.tyler.datastructures.lesson13;

public class Edge {
    private int weight;
    private Vertex[] endpoints;

    public Edge(Vertex u, Vertex v, int weight) {
        this.weight = weight;
        endpoints = new Vertex[]{u, v};
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex[] getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Vertex[] endpoints) {
        this.endpoints = endpoints;
    }
}
