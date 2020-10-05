package java_test_hurdle.hurdle;

import java_test_hurdle.gamer.Gamer;

public class Racecourse implements Hurdle {
    private int length;

    public Racecourse(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Racecourse{" +
            "length=" + length +
            '}';
    }

    public boolean isCheck(Gamer gamer) {
        gamer.setSuccess(gamer.getMaxLength() >= length);
        if (gamer.getSuccess()) {
            return true;
        } else {
            return false;
        }
    }
}