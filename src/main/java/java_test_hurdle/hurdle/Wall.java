package java_test_hurdle.hurdle;

import java_test_hurdle.gamer.Gamer;

public class Wall implements Hurdle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Wall{" +
            "height=" + height +
            '}';
    }

    public boolean isCheck(Gamer gamer) {
        gamer.setSuccess(gamer.getMaxHeight() >= height);
        if (gamer.getSuccess()) {
            return true;
        } else {
            return false;
        }
    }

}