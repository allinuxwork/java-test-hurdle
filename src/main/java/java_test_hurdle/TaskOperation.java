package java_test_hurdle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java_test_hurdle.gamer.Gamer;
import java_test_hurdle.hurdle.Hurdle;

public class TaskOperation {
    public List<Gamer> jumpOrRun(Collection<Gamer> gamers, Collection<Hurdle> hurdles) {
        List<Gamer> actualResult = new ArrayList<>(gamers);

        for (Hurdle hurdle : hurdles) {
            Iterator<Gamer> iterator = actualResult.iterator();
            while (iterator.hasNext()) {
                Gamer gamer = iterator.next();
                boolean isPassed = hurdle.isCheck(gamer);
                if (!isPassed) {
                    iterator.remove();
                }
            }
        }
        return actualResult;
    }
}