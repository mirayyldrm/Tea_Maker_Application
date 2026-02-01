public class DoneState implements State {
    TeaMakerModel model;
    public DoneState(TeaMakerModel model){
        this.model = model;
    }
    @Override
    public void fill(int cups) {
        System.out.println("Process done. Reset first.");
    }

    @Override
    public void start() {
        System.out.println("Process done. Reset first.");
    }

    @Override
    public void boilWater() {
        System.out.println("Process done. Reset first.");
    }

    @Override
    public void reset() {
        System.out.println("Resetting");
        model.setCups(0);
        model.setMessage("Machine has been reset.");
        model.setState(model.getEmptyState());
    }

    @Override
    public String getStateName() {
        return "DONE";
    }
}
