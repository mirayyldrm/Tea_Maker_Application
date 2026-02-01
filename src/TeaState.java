public class TeaState implements State {
    TeaMakerModel model;

    public TeaState(TeaMakerModel model) {
        this.model = model;
    }

    @Override
    public void fill(int cups) {
        System.out.println("Wait, making tea.");
    }

    @Override
    public void start() {
        System.out.println("Already making tea.");
    }

    @Override
    public void boilWater() {
        System.out.println("Busy making tea.");
    }

    @Override
    public void reset() {
        System.out.println("Cannot reset while working.");
    }

    @Override
    public String getStateName() {
        return "MAKING TEA";
    }
}