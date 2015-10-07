package com.sample.graph.utils;

import com.sample.graph.structure.Graph;
import com.sample.graph.structure.Vertex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Author: alexey.ivlev
 * Date: 06.10.15
 */
public final class GraphUtils {

    public static Graph createGraph(String path) {
        Graph graph = new Graph();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader(new File(path));
            br = new BufferedReader(fileReader);
            String line;
            int lineCount = 0;
            Vertex vertex;
            Vertex parent;
            String[] firstLine = null;
            while((line = br.readLine()) != null) {
                if(lineCount < 1){
                    firstLine = line.trim().split( "(\\s)+" );
                    for(int i = 0; i < firstLine.length; i++) {
                        vertex = new Vertex(Integer.parseInt(firstLine[i]));
                        graph.addVertex(vertex);
                    }
                } else {
                    String[] split = line.trim().split( "(\\s)+" );
                    vertex = new Vertex(Integer.parseInt(split[0]));
                    for(int i = 0; i < firstLine.length; i++){
                        if(1 == Integer.parseInt(split[i + 1])){
                            parent = new Vertex(Integer.parseInt(firstLine[i]));
                            graph.addEdge(parent, vertex);
                        }
                    }
                }
                lineCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return graph;
    }
}
