import java.util.ArrayList;
import java.util.Timer;

public class TeaMakerModel implements Subject {
    State emptyState;
    State idleState;
    State teaState;
    State boilingWaterState;
    State doneState;
    State state;
    int cups = 0;
    String currentMessage = "Welcome";
    ArrayList<Observer> observers = new ArrayList<>();

    public TeaMakerModel(){
        emptyState = new EmptyState(this);
        idleState = new IdleState(this);
        teaState = new TeaState(this);
        boilingWaterState = new BoilingWaterState(this);
        doneState = new DoneState(this);
        state = emptyState;
    }

    public void fill(int cups){
        state.fill(cups);
        notifyObservers();
    }

    public void start(){
        state.start();
        notifyObservers();
    }

    public void boilWater(){
        state.boilWater();
        notifyObservers();
    }

    public void reset(){
        state.reset();
        notifyObservers();
    }

    public void startTimer(long delay){
        Timer timer = new Timer();
        timer.schedule(new BrewingTask(this), delay);
    }

    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }

    public State getEmptyState(){
        return emptyState;
    }
    public State getIdleState(){
        return idleState;
    }
    public State getTeaState(){
        return teaState;
    }
    public State getBoilingWaterState(){
        return boilingWaterState;
    }
    public State getDoneState(){
        return doneState;
    }

    public void setCups(int cups){
        this.cups = cups;
    }
    public int getCups(){
        return cups;
    }

    public void setMessage(String message){
        this.currentMessage = message;
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        MessageDisplay message = new BasicMessage(state.getStateName());

        if (DatabaseHelper.getInstance().getDailyCups() > 10){
            message = new HealthWarningDecorator(message);
        }

        String displayMessage;
        if (currentMessage.startsWith("WARNING") || currentMessage.startsWith("Please") || currentMessage.startsWith("Machine") || currentMessage.startsWith("Tea"))
            displayMessage = currentMessage;
        else
            displayMessage = message.getDescription();

        for (Observer o: observers){
            o.update(state.getStateName(), displayMessage, cups);
        }
    }
}