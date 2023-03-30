package ru.job4j.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class JobSorterTest {
    @Test
    public void jobAscByName() {
        Job job1 = new Job("Cooking", 2);
        Job job2 = new Job("Fishing", 5);
        Job job3 = new Job("Cleaner", 1);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(job3, job1, job2);
        Assertions.assertArrayEquals(jobs.toArray(), expected.toArray());
    }

    @Test
    public void jobAscByPriority() {
        Job job1 = new Job("Cooking", 5);
        Job job2 = new Job("Fishing", 2);
        Job job3 = new Job("Cleaner", 1);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(job3, job2, job1);
        Assertions.assertArrayEquals(jobs.toArray(), expected.toArray());
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}