package com.sample.graph;

import com.sample.graph.structure.Graph;
import com.sample.graph.structure.Vertex;
import com.sample.graph.utils.BubbleSort;
import com.sample.graph.utils.GraphUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: alexey.ivlev
 * Date: 06.10.15
 */
public class Main {

    public static void main( String[] args ) {
        Graph graph = GraphUtils.createGraph(args[0]);
        List<Integer> edgesCount = new LinkedList<>();
        for(Vertex v : graph.getVertices().keySet()){
            edgesCount.add(graph.getVertexVertices(v).size());
        }
        int[] arr = listToArray(edgesCount);
        BubbleSort.bubbleSort(arr);
        int minCut = 0;
        int tmp = arr[0];
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > tmp){
                break;
            } else {
                minCut++;
            }
        }
        System.out.println("Min cut numbers: " + minCut);
    }

    public static int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer el : list){
            res[i++] = el.intValue();
        }
        return res;
    }

}
