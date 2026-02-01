public interface State {
    void fill(int cups);
    void start();
    void boilWater();
    void reset();
    String getStateName();
}
