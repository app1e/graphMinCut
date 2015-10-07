package com.sample.graph.utils;

/**
 * Author: alexey.ivlev
 * Date: 07.10.15
 */
public final class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        int temp;
        for(int i=0; i < arr.length - 1; i++){

            for(int j = 1; j < arr.length - i; j++){
                if(arr[j - 1] > arr[j]){
                    temp=arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;

    }
}
