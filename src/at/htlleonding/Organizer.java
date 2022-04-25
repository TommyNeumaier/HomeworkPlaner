package at.htlleonding;

import java.time.LocalDateTime;

public class Organizer {
    private HomeworkNode head;

    public int getHomeworkCountBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        HomeworkNode temp = head;
        int count = 0;

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException();
        }

        while (temp != null) {
            if (startDate.isBefore(temp.getHomework().getDeadline()) && endDate.isAfter(temp.getHomework().getDeadline())) {
                count++;
            }
            temp = temp.getNext();
        }
        return count;
    }

    public int getHomeworkCountByCourse(String course) {
        int count = 0;
        HomeworkNode temp = head;
        while (temp != null) {
            if (temp.getHomework().getCourse().equals(course)) {
                count++;
            }
            temp = temp.getNext();
        }
        return count;
    }

    public Homework getHomeworkAt(int index) {
        HomeworkNode temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.getHomework();
            }
            count++;
            temp = temp.getNext();
        }
        return null;
    }

    public int getHomeworkCount() {
        int count = 0;
        HomeworkNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void addHomework(Homework homework) {
        boolean set = false;
        HomeworkNode newNode = new HomeworkNode(homework);
        HomeworkNode currentNode = this.head;

        if (currentNode == null) this.head = newNode;
        else if (!homework.getDeadline().isBefore(currentNode.getHomework().getDeadline())) {
            do {
                if (currentNode.getNext() != null && homework.getDeadline().isBefore(currentNode.getNext().getHomework().getDeadline())) {
                    newNode.setNext(currentNode.getNext());
                    currentNode.setNext(newNode);
                    set = true;
                }
                if (currentNode.getNext() == null && !set) {
                    currentNode.setNext(newNode);
                    set = true;
                }
                currentNode = currentNode.getNext();
            } while (currentNode != null && !set);
        } else {
            newNode.setNext(currentNode);
            this.head = newNode;
        }
    }

    public boolean turnInHomework(int moodleId) {
        HomeworkNode temp = this.head;
        if (temp.getHomework().getMoodleId() == moodleId) {
            if (temp.getNext() != null) this.head = temp.getNext();
            else this.head = null;
            return true;
        }

        while (temp.getNext() != null) {
            if (moodleId == temp.getNext().getHomework().getMoodleId() || moodleId == temp.getHomework().getMoodleId()) {
                temp.setNext(temp.getNext().getNext());
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
}