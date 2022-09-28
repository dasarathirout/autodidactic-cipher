package org.concept.multithreading.executor.ex17;

import java.util.concurrent.RecursiveTask;

public class SearchNumberTask extends RecursiveTask<Integer> {

    int[] array;
    int indexStart;
    int indexEnd;
    int searchElement;

    public SearchNumberTask(int[] array, int indexStart, int indexEnd, int searchElement) {
        this.array = array;
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
        this.searchElement = searchElement;
    }

    private Integer countFrequencies() {
        int frequency = 0;
        for (int index = indexStart; index <= indexEnd; index++) {
            if (array[index] == searchElement) {
                frequency = frequency + 1;
            }
        }
        return frequency;
    }

    @Override
    protected Integer compute() {
        return countFrequencies();
    }
}
