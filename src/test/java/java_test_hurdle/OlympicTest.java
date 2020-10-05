package java_test_hurdle;

import java.util.ArrayList;
import java.util.List;
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
    @MethodSource("dataWall")
    public void testWall(Wall wall, Gamer gamer, boolean isSuccessful) {
        boolean check = wall.isCheck(gamer);
        Assertions.assertEquals(isSuccessful, check);
    }

    private static Stream<Arguments> dataWall() {
        Wall wallSmall = new Wall(5);
        Wall wallGreat = new Wall(10);

        Cat pirat = new Cat("Pirat", 2, 2);
        Cat holly = new Cat("Holly", 2, 6);
        Cat milla = new Cat("Milla", 5, 11);
        Human vova = new Human("Vova", 7, 2);
        Robot rde20 = new Robot("RDE20", 7, 2);

        return Stream.of(Arguments.of(wallSmall, pirat, false),
            Arguments.of(wallGreat, pirat, false),
            Arguments.of(wallSmall, pirat, false),
            Arguments.of(wallGreat, holly, false),
            Arguments.of(wallSmall, holly, true),
            Arguments.of(wallGreat, milla, true),
            Arguments.of(wallSmall, milla, true),
            Arguments.of(wallGreat, vova, false),
            Arguments.of(wallSmall, vova, false),
            Arguments.of(wallSmall, rde20, false)
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
        Racecourse racecourseGreat = new Racecourse(12);

        Cat barsik = new Cat("Barsik", 6, 2);
        Cat marta = new Cat("Marta", 14, 6);
        Cat molly = new Cat("Molly", 5, 11);
        Human semen = new Human("Semen", 7, 2);
        Robot rde19 = new Robot("RDE19", 7, 2);

        return Stream.of(Arguments.of(racecourseSmall, barsik, true),
            Arguments.of(racecourseGreat, barsik, false),
            Arguments.of(racecourseSmall, barsik, true),
            Arguments.of(racecourseGreat, marta, true),
            Arguments.of(racecourseSmall, marta, true),
            Arguments.of(racecourseGreat, molly, false),
            Arguments.of(racecourseGreat, molly, false),
            Arguments.of(racecourseSmall, semen, true),
            Arguments.of(racecourseGreat, semen, false),
            Arguments.of(racecourseGreat, rde19, false)
        );
    }

    @Test
    void tryActionList() {
        List<Cat> cats = getCats();
        List<Robot> robots = getRobots();
        List<Human> humans = getHumans();
        List<Wall> walls = getWalls();
        List<Gamer> expectedResult = new ArrayList<>();

        expectedResult.addAll(cats);

        expectedResult.add(robots.get(1));
        expectedResult.add(robots.get(2));
        expectedResult.add(humans.get(1));
        expectedResult.add(humans.get(2));

        List<Gamer> gamers = getGamers(cats, robots, humans);

        List<Hurdle> hurdles = new ArrayList<>();
        hurdles.addAll(walls);
        Assertions.assertEquals(expectedResult, taskoperation.jumpOrRun(gamers, hurdles));
    }

    private List<Wall> getWalls() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(5));
        return walls;
    }

    private List<Cat> getCats() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", 2, 5));
        cats.add(new Cat("Holly", 2, 6));
        cats.add(new Cat("Molly", 5, 11));
        return cats;
    }

    private List<Human> getHumans() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Pasha", 7, 3));
        humans.add(new Human("Sveta", 8, 6));
        humans.add(new Human("Nina", 7, 11));
        return humans;
    }

    private List<Robot> getRobots() {
        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot("R2D1", 7, 2));
        robots.add(new Robot("R2D3", 9, 5));
        robots.add(new Robot("R2D5", 5, 12));
        return robots;
    }

    private List<Gamer> getGamers(List<Cat> cats, List<Robot> robots, List<Human> humans) {
        List<Gamer> gamers = new ArrayList<>();
        gamers.addAll(cats);
        gamers.addAll(robots);
        gamers.addAll(humans);
        return gamers;
    }

}