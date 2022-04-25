package at.htlleonding;

public class HomeworkNode {
    private HomeworkNode next;
    private Homework homework;

    public HomeworkNode(Homework homework) {
        this.setHomework(homework);
    }

    public Homework getHomework() {
        return homework;
    }

    public void setNext(HomeworkNode next) {
        this.next = next;
    }

    private void setHomework(Homework homework) {
        this.homework = homework;
    }

    public HomeworkNode getNext() {
        return next;
    }
}
