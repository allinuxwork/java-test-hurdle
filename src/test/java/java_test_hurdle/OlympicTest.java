package java_test_hurdle;

import java.util.ArrayList;
import java.util.stream.Stream;
import java_test_hurdle.gamer.Cat;
import java_test_hurdle.gamer.Gamer;
import java_test_hurdle.gamer.Human;
import java_test_hurdle.gamer.Robot;
import java_test_hurdle.hurdle.Hurdle;
import java_test_hurdle.hurdle.Racecourse;
import java_test_hurdle.hurdle.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OlympicTest {
    TaskOperation taskoperation = new TaskOperation();

    @ParameterizedTest
    @MethodSource("data")
    public void testWall(Wall wall, Gamer gamer, boolean isSuccessful) {
        boolean check = wall.isCheck(gamer);
        Assertions.assertEquals(isSuccessful, check);
    }

    private static Stream<Arguments> data() {
        Wall wallSmall = new Wall(5);
        Wall wallGreat = new Wall(10);

        Cat barsik = new Cat("Barsik", 2, 2);
        Cat holly = new Cat("Holly", 2, 6);
        Cat molly = new Cat("Molly", 5, 11);
        Human pasha = new Human("Pasha", 7, 2);
        Robot rde = new Robot("Rde", 7, 2);

        return Stream.of(Arguments.of(wallSmall, barsik, false),
            Arguments.of(wallGreat, barsik, false),
            Arguments.of(wallSmall, barsik, false),
            Arguments.of(wallGreat, holly, false),
            Arguments.of(wallSmall, holly, true),
            Arguments.of(wallGreat, molly, true),
            Arguments.of(wallSmall, molly, true),
            Arguments.of(wallGreat, pasha, false),
            Arguments.of(wallSmall, pasha, false),
            Arguments.of(wallSmall, rde, false)
        );


    }

    @ParameterizedTest
    @MethodSource("dataRacecourse")
    public void testRacecourse(Hurdle hurdle, Gamer gamer, boolean isSuccessful) {
        boolean check = hurdle.isCheck(gamer);
        Assertions.assertEquals(isSuccessful, check);
    }

    private static Stream<Arguments> dataRacecourse() {
        Racecourse racecourseSmall = new Racecourse(5);
        Racecourse racecourseGreat = new Racecourse(10);

        Cat barsik = new Cat("Barsik", 6, 2);
        Cat holly = new Cat("Holly", 11, 6);
        Cat molly = new Cat("Molly", 5, 11);
        Human pasha = new Human("Pasha", 7, 2);
        Robot rde = new Robot("Rde", 7, 2);

        return Stream.of(Arguments.of(racecourseSmall, barsik, true),
            Arguments.of(racecourseGreat, barsik, false),
            Arguments.of(racecourseSmall, barsik, true),
            Arguments.of(racecourseGreat, holly, true),
            Arguments.of(racecourseSmall, holly, true),
            Arguments.of(racecourseGreat, molly, false),
            Arguments.of(racecourseGreat, molly, false),
            Arguments.of(racecourseSmall, pasha, true),
            Arguments.of(racecourseGreat, pasha, false),
            Arguments.of(racecourseGreat, rde, false)
        );
    }

    @Test
    void tryActionArrayList() {
        ArrayList<Cat> cats = getCats();
        ArrayList<Robot> robots = getRobots();
        ArrayList<Human> humans = getHumans();
        ArrayList<Wall> wall = getWalls();
        ArrayList<Gamer> expectedResult = new ArrayList<>();
        expectedResult.add(cats.get(1));
        expectedResult.add(cats.get(2));
        expectedResult.add(robots.get(1));
        expectedResult.add(robots.get(2));
        expectedResult.add(humans.get(1));
        expectedResult.add(humans.get(2));

        ArrayList<Gamer> gamers = getGamers(cats, robots, humans);

        ArrayList<Hurdle> hurdles = new ArrayList<>();
        hurdles.addAll(wall);
        Assertions.assertEquals(expectedResult, taskoperation.jumpOrRun(gamers, hurdles));
    }

    private ArrayList<Wall> getWalls() {
        ArrayList<Wall> wall = new ArrayList<>();
        wall.add(new Wall(5));
        return wall;
    }

    private ArrayList<Cat> getCats() {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", 2, 2));
        cats.add(new Cat("Holly", 2, 6));
        cats.add(new Cat("Molly", 5, 11));
        return cats;
    }

    private ArrayList<Human> getHumans() {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Pasha", 7, 2));
        humans.add(new Human("Sveta", 7, 6));
        humans.add(new Human("Nina", 7, 11));
        return humans;
    }

    private ArrayList<Robot> getRobots() {
        ArrayList<Robot> robots = new ArrayList<>();
        robots.add(new Robot("R2D2", 7, 2));
        robots.add(new Robot("R2D3", 7, 6));
        robots.add(new Robot("R2D4", 7, 11));
        return robots;
    }

    private ArrayList<Gamer> getGamers(ArrayList<Cat> cats, ArrayList<Robot> robots, ArrayList<Human> humans) {
        ArrayList<Gamer> gamers = new ArrayList<>();
        gamers.addAll(cats);
        gamers.addAll(robots);
        gamers.addAll(humans);
        return gamers;
    }

}