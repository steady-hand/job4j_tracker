package ru.job4j.queue;

import java.util.Objects;

public record Task(Position position,
                   String description,
                   int urgency) {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return urgency == task.urgency && position == task.position && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, description, urgency);
    }
}