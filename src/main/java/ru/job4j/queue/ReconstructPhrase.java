package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < evenElements.size() + i; i++) {
            if (i % 2 == 0) {
                str.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return str.toString();
    }

    private String getDescendingElements() {
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < descendingElements.size() + i; i++) {
            str2.append(descendingElements.pollLast());
            }
        return str2.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}