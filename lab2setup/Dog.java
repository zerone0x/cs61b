package lab2setup;

public class Dog {
    private final int size;

    public Dog(int s) {
        size = s;
    }

    /** Makes a noise. */
    public String noise() {
        if (size < 10) {
            return "yip";
        } 
        return "bark";
    }
}
