package com.tyler.datastructures.lesson13;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private String element;
    private Map<Vertex, Edge> outgoing, incoming;

    public Vertex(String element, boolean graphIsDirected) {
        this.element = element;

        outgoing = new HashMap<>();
        if (graphIsDirected) {
            incoming = new HashMap<>();
        } else {
            incoming = outgoing;
        }
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Map<Vertex, Edge> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Map<Vertex, Edge> outgoing) {
        this.outgoing = outgoing;
    }

    public Map<Vertex, Edge> getIncoming() {
        return incoming;
    }

    public void setIncoming(Map<Vertex, Edge> incoming) {
        this.incoming = incoming;
    }


}
