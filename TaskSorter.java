package edu.tjhsst.finalproject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sanjay on 1/21/2018.
 */

public class TaskSorter {

    ArrayList<Task> task = new ArrayList<>();
    public TaskSorter(ArrayList<Task> task) {
        this.task = task;
    }
    public ArrayList<Task> getSorted() {
        Collections.sort(task);
        return task;
    }
}
