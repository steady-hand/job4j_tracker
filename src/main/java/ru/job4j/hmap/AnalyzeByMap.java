package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        List<Label> students = averageScoreByPupil(pupils);
        double allScore = 0;
        for (Label pupil : students) {
            allScore += pupil.score();
        }
        allScore /= students.size();
        return allScore;
    }

    public static List<Label> averageScoreByPupil (List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double allScore = 0;
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
            }
            double rsl = allScore / pupil.subjects().size();
            Label student = new Label(pupil.name(), rsl);
            students.add(student);
        }
        return students;
    }

    public static Label bestStudent (List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double allScore = 0;
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
            }
            Label student = new Label(pupil.name(), allScore);
            students.add(student);
        }
        students.sort(Comparator.naturalOrder());
            return students.get(students.size() - 1);
    }
    public static List<Label> averageScoreBySubject (List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.get(subject.name()) != null ? map.get(subject.name()) : 0;
                map.put(subject.name(), subject.score() + score);
            }
        }
        for (String key : map.keySet()) {
            Label subject = new Label(key,map.get(key) / pupils.size());
            subjects.add(subject);
        }
        return subjects;
    }
    public static Label bestSubject (List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.get(subject.name()) != null ? map.get(subject.name()) : 0;
                map.put(subject.name(), subject.score() + score);
            }
            for (String key : map.keySet()) {
                Label subject = new Label(key, map.get(key));
                subjects.add(subject);
            }
        }
        subjects.sort(Comparator.naturalOrder());
        return subjects.get(subjects.size()-1);
    }
}
