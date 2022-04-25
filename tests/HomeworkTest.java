import at.htlleonding.Homework;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {
    @Test
    void testConstructorAndGetters() {
        Homework homework = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));

        assertEquals(141520, homework.getMoodleId());
        assertEquals("SEW", homework.getCourse());
        assertEquals("RPN-Calculator", homework.getTask());
        assertEquals("2022-03-13 23:55:00", homework.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        homework = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));

        assertEquals(137694, homework.getMoodleId());
        assertEquals("KIDS", homework.getCourse());
        assertEquals("Penguin Visualization", homework.getTask());
        assertEquals("2022-01-11 08:00:00", homework.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    void testConstructorNegativeMoodleIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Homework homework = new Homework(-123, "SEW", "First Steps With Exceptions", LocalDateTime.of(2022, 4, 15, 23, 55));
        });
    }

    @Test
    void testConstructorZeroMoodleIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Homework homework = new Homework(0, "SEW", "Exceptions For Experts", LocalDateTime.of(2022, 4, 22, 23, 55));
        });
    }

    @Test
    void testConstructorCourseNameUppered() {
        Homework homework = new Homework(123456, "sew", "String Operations Deep Dive", LocalDateTime.of(2021, 3, 10, 20, 0));

        assertEquals(123456, homework.getMoodleId());
        assertEquals("SEW", homework.getCourse());
        assertEquals("String Operations Deep Dive", homework.getTask());
        assertEquals("2021-03-10 20:00:00", homework.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        homework = new Homework(789321, "lOaL", "Regular Expressions", LocalDateTime.of(2022, 6, 17, 10, 50));

        assertEquals(789321, homework.getMoodleId());
        assertEquals("LOAL", homework.getCourse());
        assertEquals("Regular Expressions", homework.getTask());
        assertEquals("2022-06-17 10:50:00", homework.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    void testConstructorShortCourseNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Homework homework = new Homework(123456, "", "String Operations Deep Dive", LocalDateTime.of(2021, 3, 10, 20, 0));
        });
    }

    @Test
    void testConstructorLongCourseNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Homework homework = new Homework(789321, "LOGIC", "Regular Expressions", LocalDateTime.of(2022, 6, 17, 10, 50));
        });
    }
}