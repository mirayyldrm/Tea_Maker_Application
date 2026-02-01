public class EmptyState implements State {
    TeaMakerModel model;
    public EmptyState(TeaMakerModel model){
        this.model = model;
    }
    public void fill(int cups){
        System.out.println("Machine filled with " + cups + " cups.");
        model.setCups(cups);
        model.setState(model.getIdleState());
    }

    @Override
    public void start() {
        model.setMessage("Machine is empty! Please fill first.");
    }

    @Override
    public void boilWater() {
        model.setMessage("Machine is empty! Please fill first.");
    }

    @Override
    public void reset() {
        System.out.println("Empty.");
    }

    @Override
    public String getStateName() {
        return "EMPTY";
    }
}
