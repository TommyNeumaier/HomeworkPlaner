import at.htlleonding.Homework;
import at.htlleonding.Organizer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerTest {
    @Test
    void testEmptyOrganizer() {
        Organizer organizer = new Organizer();

        assertEquals(null, organizer.getHomeworkAt(0));
        assertEquals(null, organizer.getHomeworkAt(5));
        assertEquals(0, organizer.getHomeworkCount());
        assertEquals(0, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(0, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
    }

    @Test
    void testAddHomeworkCountsCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);
        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);
        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);

        assertEquals(9, organizer.getHomeworkCount());

        assertEquals(4, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(3, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(2, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(8, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(6, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));
    }

    @Test
    void testIllegalDateRangeThrowsException() {
        Organizer organizer = new Organizer();

        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);

        assertThrows(IllegalArgumentException.class, () -> {
            organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 13, 12, 0), LocalDateTime.of(2022, 3, 12, 12, 0));
        });
    }


    @Test
    void testAddHomeworkPositionsCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);
        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);
        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);

        assertEquals(homeworkKidsPenguins, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewParty, organizer.getHomeworkAt(1));
        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(2));
        assertEquals(homeworkKidsWater, organizer.getHomeworkAt(3));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(4));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(5));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(6));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(7));
        assertEquals(homeworkLoalPokedex, organizer.getHomeworkAt(8));
        assertEquals(null, organizer.getHomeworkAt(9));
    }

    @Test
    void testTurnInHomeworkReturnValueCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);
        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);
        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);

        assertEquals(true, organizer.turnInHomework(138665)); //SEW - Party Calendar
        assertEquals(false, organizer.turnInHomework(138665)); //SEW - Party Calendar
        assertEquals(true, organizer.turnInHomework(141617)); //KIDS - Heart Failure
        assertEquals(false, organizer.turnInHomework(123456)); //random number
        assertEquals(true, organizer.turnInHomework(128111)); //LOAL - Prolog Pokedex
        assertEquals(false, organizer.turnInHomework(124020)); //random number
    }

    @Test
    void testTurnInHomeworkCountsCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);
        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);
        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);

        organizer.turnInHomework(139686); //SEW - Student Management

        assertEquals(8, organizer.getHomeworkCount());

        assertEquals(3, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(3, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(2, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(7, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(6, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        organizer.turnInHomework(141617); //KIDS - Heart Failures
        assertEquals(7, organizer.getHomeworkCount());

        assertEquals(3, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(2, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(2, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(6, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(5, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        organizer.turnInHomework(141617); //KIDS - Heart Failures - again

        assertEquals(7, organizer.getHomeworkCount());

        assertEquals(3, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(2, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(2, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(6, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(5, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        organizer.turnInHomework(137694); //KIDS - Penguin Visualizations

        assertEquals(6, organizer.getHomeworkCount());

        assertEquals(3, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(1, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(2, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(6, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(5, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));
    }

    @Test
    void testTurnInHomeworkPositionsCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);
        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);
        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);

        organizer.turnInHomework(140929); //KIDS - Water Potability

        assertEquals(homeworkKidsPenguins, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewParty, organizer.getHomeworkAt(1));
        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(2));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(3));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(4));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(5));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(6));
        assertEquals(homeworkLoalPokedex, organizer.getHomeworkAt(7));
        assertEquals(null, organizer.getHomeworkAt(8));

        organizer.turnInHomework(137694); //KIDS - Penguin Visualization

        assertEquals(homeworkSewParty, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(1));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(2));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(3));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(4));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(5));
        assertEquals(homeworkLoalPokedex, organizer.getHomeworkAt(6));
        assertEquals(null, organizer.getHomeworkAt(7));

        organizer.turnInHomework(137694); //KIDS - Penguin Visualization - again

        assertEquals(homeworkSewParty, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(1));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(2));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(3));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(4));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(5));
        assertEquals(homeworkLoalPokedex, organizer.getHomeworkAt(6));
        assertEquals(null, organizer.getHomeworkAt(7));

        organizer.turnInHomework(141520); //SEW - RPN Calculator

        assertEquals(homeworkSewParty, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(1));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(2));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(3));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(4));
        assertEquals(homeworkLoalPokedex, organizer.getHomeworkAt(5));
        assertEquals(null, organizer.getHomeworkAt(6));

        organizer.turnInHomework(128111); //LOAL - Prolog Pokedex

        assertEquals(homeworkSewParty, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(1));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(2));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(3));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(4));
        assertEquals(null, organizer.getHomeworkAt(5));
    }

    @Test
    void testAddTurnInHomeworkCombinationPositionsCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);
        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);

        assertEquals(homeworkKidsWater, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(1));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(2));
        assertEquals(homeworkLoalPokedex, organizer.getHomeworkAt(3));
        assertEquals(null, organizer.getHomeworkAt(4));

        organizer.turnInHomework(128111); //LOAL - Prolog-Pokedex

        assertEquals(homeworkKidsWater, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(1));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(2));
        assertEquals(null, organizer.getHomeworkAt(3));

        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);

        assertEquals(homeworkSewStudentMgmt, organizer.getHomeworkAt(0));
        assertEquals(homeworkKidsWater, organizer.getHomeworkAt(1));
        assertEquals(homeworkSewNecklace, organizer.getHomeworkAt(2));
        assertEquals(homeworkSewRpn, organizer.getHomeworkAt(3));
        assertEquals(homeworkKidsHeart, organizer.getHomeworkAt(4));
        assertEquals(null, organizer.getHomeworkAt(5));

        organizer.turnInHomework(139686);
        organizer.turnInHomework(140708);
        organizer.turnInHomework(141617);
        organizer.turnInHomework(140929);
        organizer.turnInHomework(141520);

        assertEquals(null, organizer.getHomeworkAt(0));

        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);

        assertEquals(homeworkKidsPenguins, organizer.getHomeworkAt(0));
        assertEquals(homeworkSewParty, organizer.getHomeworkAt(1));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(2));
        assertEquals(null, organizer.getHomeworkAt(3));

        organizer.turnInHomework(137694); //KIDS - Penguin Visualization

        assertEquals(homeworkSewParty, organizer.getHomeworkAt(0));
        assertEquals(homeworkLoalPredicates, organizer.getHomeworkAt(1));
        assertEquals(null, organizer.getHomeworkAt(2));
    }

    @Test
    void testAddTurnInHomeworkCombinationCountsCorrect() {
        Organizer organizer = new Organizer();

        Homework homeworkLoalPokedex = new Homework(128111, "LOAL", "Prolog-Pokedex", LocalDateTime.of(2022, 3, 22, 10, 50));
        organizer.addHomework(homeworkLoalPokedex);
        Homework homeworkSewRpn = new Homework(141520, "SEW", "RPN-Calculator", LocalDateTime.of(2022, 3, 13, 23, 55));
        organizer.addHomework(homeworkSewRpn);
        Homework homeworkKidsWater = new Homework(140929, "KIDS", "Water Potability", LocalDateTime.of(2022, 3, 1, 8, 00));
        organizer.addHomework(homeworkKidsWater);
        Homework homeworkSewNecklace = new Homework(140708, "SEW", "Necklace", LocalDateTime.of(2022, 3, 6, 23, 55));
        organizer.addHomework(homeworkSewNecklace);

        assertEquals(4, organizer.getHomeworkCount());

        assertEquals(2, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(1, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(1, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(2, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(4, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(4, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        organizer.turnInHomework(128111); //LOAL - Prolog-Pokedex

        assertEquals(3, organizer.getHomeworkCount());

        assertEquals(2, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(1, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(2, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(3, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        Homework homeworkSewStudentMgmt = new Homework(139686, "SEW", "Student Management", LocalDateTime.of(2022, 2, 13, 23, 55));
        organizer.addHomework(homeworkSewStudentMgmt);
        Homework homeworkKidsHeart = new Homework(141617, "KIDS", "Heart Failures", LocalDateTime.of(2022, 3, 22, 8, 00));
        organizer.addHomework(homeworkKidsHeart);

        assertEquals(5, organizer.getHomeworkCount());

        assertEquals(3, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(2, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(2, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(5, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(4, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        organizer.turnInHomework(139686);
        organizer.turnInHomework(140708);
        organizer.turnInHomework(141617);
        organizer.turnInHomework(140929);
        organizer.turnInHomework(141520);

        assertEquals(0, organizer.getHomeworkCount());

        assertEquals(0, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(0, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        Homework homeworkSewParty = new Homework(138665, "SEW", "Party Calendar", LocalDateTime.of(2022, 1, 16, 23, 55));
        organizer.addHomework(homeworkSewParty);
        Homework homeworkKidsPenguins = new Homework(137694, "KIDS", "Penguin Visualization", LocalDateTime.of(2022, 1, 11, 8, 00));
        organizer.addHomework(homeworkKidsPenguins);
        Homework homeworkLoalPredicates = new Homework(128101, "LOAL", "Predicate Logic", LocalDateTime.of(2022, 3, 1, 10, 50));
        organizer.addHomework(homeworkLoalPredicates);

        assertEquals(3, organizer.getHomeworkCount());

        assertEquals(1, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(1, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(1, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(1, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(2, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(1, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));

        organizer.turnInHomework(137694); //KIDS - Penguin Visualization

        assertEquals(2, organizer.getHomeworkCount());

        assertEquals(1, organizer.getHomeworkCountByCourse("SEW"));
        assertEquals(0, organizer.getHomeworkCountByCourse("KIDS"));
        assertEquals(1, organizer.getHomeworkCountByCourse("LOAL"));
        assertEquals(0, organizer.getHomeworkCountByCourse("LINZ"));

        assertEquals(1, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 2, 14, 12, 0), LocalDateTime.of(2022, 3, 10, 12, 0)));
        assertEquals(0, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 1, 8, 0), LocalDateTime.of(2022, 1, 11, 7, 59)));
        assertEquals(2, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 1, 11, 12, 0), LocalDateTime.of(2022, 4, 1, 12, 0)));
        assertEquals(1, organizer.getHomeworkCountBetweenDates(LocalDateTime.of(2022, 3, 1, 7, 0), LocalDateTime.of(2022, 3, 31, 23, 59)));
    }
}