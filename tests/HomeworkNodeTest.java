import at.htlleonding.Homework;
import at.htlleonding.HomeworkNode;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkNodeTest {
    @Test
    void testConstructor() {
        Homework homework = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));

        HomeworkNode node = new HomeworkNode(homework);

        assertEquals(homework, node.getHomework());
        assertEquals(null, node.getNext());
    }

    @Test
    void testNext() {
        Homework homeworkSew = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        Homework homeworkKids = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));

        HomeworkNode node = new HomeworkNode(homeworkSew);
        HomeworkNode nodeOther = new HomeworkNode(homeworkKids);

        assertEquals(homeworkSew, node.getHomework());
        assertEquals(null, node.getNext());
        assertEquals(homeworkKids, nodeOther.getHomework());
        assertEquals(null, nodeOther.getNext());

        node.setNext(nodeOther);

        assertEquals(homeworkSew, node.getHomework());
        assertEquals(nodeOther, node.getNext());
        assertEquals(homeworkKids, nodeOther.getHomework());
        assertEquals(null, nodeOther.getNext());

        node.setNext(null);

        assertEquals(homeworkSew, node.getHomework());
        assertEquals(null, node.getNext());
        assertEquals(homeworkKids, nodeOther.getHomework());
        assertEquals(null, nodeOther.getNext());
    }
}