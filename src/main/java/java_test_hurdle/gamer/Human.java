package java_test_hurdle.gamer;

public class Human implements Gamer {
    private String name;

    private int maxLength;

    private int maxHeight;

    private boolean success = true;

    public Human(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }


    public int getMaxLength() {
        return maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Human{" +
            "name='" + name + '\'' +
            ", maxLength=" + maxLength +
            ", maxHeight=" + maxHeight +
            ", success=" + success +
            '}';
    }
}