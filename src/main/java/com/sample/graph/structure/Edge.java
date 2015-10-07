package com.sample.graph.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: alexey.ivlev
 * Date: 06.10.15
 */
public class Edge {

    private final List<Vertex> vertices = new ArrayList<>();

    public Edge(Vertex v, Vertex w) {
        if(v == null || w == null) {
            throw new IllegalArgumentException("Both vertices are required");
        }
        vertices.add(v);
        vertices.add(w);
    }

    public Vertex getSecondVertex(Vertex v) {
        if(!vertices.contains(v)) {
            throw new IllegalArgumentException("Vertex " + v.getId());
        }
        return vertices.get(vertices.size() - 1);
    }

    public void replaceVertex(Vertex oVertex, Vertex nVertex) {
        if( !vertices.contains(oVertex) ) {
            throw new IllegalArgumentException( "Vertex " + oVertex.getId() );
        }
        vertices.remove(oVertex);
        vertices.add(nVertex);
    }

    public List<Vertex> getVertices() {
        return this.vertices;
    }
}
