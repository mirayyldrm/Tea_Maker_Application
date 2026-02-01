public class IdleState implements State {
    TeaMakerModel model;

    public IdleState(TeaMakerModel model){
        this.model = model;
    }

    @Override
    public void fill(int cups) {
        System.out.println("Adding more water");
        model.setCups(cups);
    }

    @Override
    public void start() {
        System.out.println("Starting to make tea...");
        model.setState(model.getTeaState());
        model.startTimer(4000);
    }

    @Override
    public void boilWater() {
        System.out.println("Boiling water...");
        model.setState(model.getBoilingWaterState());
        model.startTimer(4000);
    }

    @Override
    public void reset() {
        model.setCups(0);
        model.setState(model.getEmptyState());
    }

    @Override
    public String getStateName() {
        return "IDLE";
    }
}