package ru.job4j.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskSorter {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task(Position.DEPUTY_DIRECTOR, "description_1", 5),
                new Task(Position.DIRECTOR, "description 2", 9),
                new Task(Position.DEPARTMENT_HEAD, "description 3", 1)
        );
        Collections.sort(tasks, new TaskByPositionAsc());
        Collections.sort(tasks, new TaskByUrgencyDesc());
        Collections.sort(tasks, new TaskByPositionAsc().thenComparing(new TaskByUrgencyDesc()));
    }
}
