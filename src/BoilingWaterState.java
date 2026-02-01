public class BoilingWaterState implements State {
    TeaMakerModel model;

    public BoilingWaterState(TeaMakerModel model) {
        this.model = model;
    }

    @Override
    public void fill(int cups) {
        System.out.println("Wait. Boiling water.");
    }

    @Override
    public void start() {
        System.out.println("Busy boiling water.");
    }

    @Override
    public void boilWater() {
        System.out.println("Already boiling.");
    }

    @Override
    public void reset() {
        System.out.println("Cannot reset while working.");
    }

    @Override
    public String getStateName() {
        return "BOILING WATER";
    }
}