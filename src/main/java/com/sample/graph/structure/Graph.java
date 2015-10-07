package com.sample.graph.structure;

import java.util.*;

/**
 * Author: alexey.ivlev
 * Date: 06.10.15
 */
public class Graph {
    private Map<Vertex, Set<Vertex>> vertices = new TreeMap<>(new Comparator<Vertex>() {
        @Override
        public int compare(Vertex v1, Vertex v2) {
            if(v1.getId() == v2.getId()){
                return 0;
            }else {
                return v1.getId() > v2.getId() ? 1 : -1;
            }
        }
    });

    public Map<Vertex, Set<Vertex>> getVertices() {
        return vertices;
    }

    public boolean hasVertex(Vertex vertex) {
        return vertices.containsKey(vertex);
    }

    public void addVertex(Vertex vertex){
        if(!hasVertex(vertex)){
            vertices.put(vertex, new HashSet<Vertex>());
        }
    }

    public void addEdge(Vertex v, Vertex w){
        if(!hasVertex(v)) addVertex(v);
        if(!hasVertex(w)) addVertex(w);
        vertices.get(v).add(w);
    }

    private void validateVertex(Vertex vertex) {
        if (!hasVertex(vertex)) throw new IllegalArgumentException(vertex + " is not a vertex");
    }

    public Set<Vertex> getVertexVertices(Vertex vertex){
        return vertices.get(vertex);
    }

    public boolean hasEdge(Vertex v, Vertex w) {
        validateVertex(v);
        validateVertex(w);
        return vertices.get(v).contains(w);
    }

    public Set<Vertex> getNeighbors(Vertex vertex){
        if(!hasVertex(vertex)) throw new  IllegalArgumentException("There is no vertex - " + vertex);
        else  return vertices.get(vertex);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(Map.Entry<Vertex, Set<Vertex>> entry : vertices.entrySet()){
            s.append(entry.getKey().toString() + ": ");
            for(Vertex w : entry.getValue()){
                vertices.get(entry);
                s.append(w.toString() + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }




//    private final Map<Integer, Vertex> vertices = new TreeMap<>( new Comparator<Integer>() {
//        @Override
//        public int compare( Integer arg0, Integer arg1 ) {
//            return arg0.compareTo( arg1 );
//        }
//    });
//
//    private final List<Edge> edges = new ArrayList<>();
//
//    public void addVertex(Vertex v) {
//        vertices.put(v.getId(), v);
//    }
//
//    public Vertex getVertex(int id) {
//        Vertex v;
//        if(null == (v = vertices.get(id))) {
//            v = new Vertex(id);
//            addVertex(v);
//        }
//        return v;
//    }
//
//    public Map<Integer, Vertex> getVertices() {
//        return this.vertices;
//    }
//
//    public List<Edge> getEdges() {
//        return this.edges;
//    }
}
