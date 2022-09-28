package org.concept.multithreading.executor.ex17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SearchNumberAction extends RecursiveAction {

    int taskSize;

    public SearchNumberAction(int taskSize) {
        this.taskSize = taskSize;
    }

    @Override
    protected void compute() {
        for (SearchNumberAction searchNumberAction : generateSubTasks()) {
            searchNumberAction.fork();
        }
    }

    private List<SearchNumberAction> generateSubTasks() {
        List<SearchNumberAction> subTasksList = new ArrayList<>();
        SearchNumberAction subTaskA = new SearchNumberAction(this.taskSize / 5);
        SearchNumberAction subtaskB = new SearchNumberAction(this.taskSize / 5);
        SearchNumberAction subtaskC = new SearchNumberAction(this.taskSize / 5);
        SearchNumberAction subtaskD = new SearchNumberAction(this.taskSize / 5);
        SearchNumberAction subtaskE = new SearchNumberAction(this.taskSize / 5);

        subTasksList.add(subTaskA);
        subTasksList.add(subtaskB);
        subTasksList.add(subtaskC);
        subTasksList.add(subtaskD);
        subTasksList.add(subtaskE);

        return subTasksList;
    }
}
