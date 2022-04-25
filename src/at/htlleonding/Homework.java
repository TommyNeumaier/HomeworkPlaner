package at.htlleonding;

import java.time.LocalDateTime;

public class Homework {
    private int moodleId;
    private String task;
    private String course;
    private LocalDateTime deadline;

    public Homework(int moodleId, String course, String task, LocalDateTime deadline) {
        this.setMoodleId(moodleId);
        this.setCourse(course);
        this.setTask(task);
        this.setDeadline(deadline);
    }

    public int getMoodleId() {
        return moodleId;
    }

    private void setMoodleId(int moodleId) {
        if (moodleId > 0) {
            this.moodleId = moodleId;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getTask() {
        return task;
    }

    private void setTask(String task) {
        this.task = task;
    }

    public String getCourse() {
        return course;
    }

    private void setCourse(String course) {
        if (course.length() >= 1 && 4 >= course.length()) {
            course = course.toUpperCase();
            this.course = course;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    private void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "moodleId=" + moodleId +
                ", task='" + task + '\'' +
                ", course='" + course + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
