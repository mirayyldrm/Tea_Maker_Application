import java.time.LocalDate;
public class BasicMessage extends MessageDisplay {
    String stateName;
    public BasicMessage(String stateName){
        this.stateName = stateName;
    }

    @Override
    public String getDescription() {
        return LocalDate.now().getDayOfWeek() + ", " + LocalDate.now() + "- State: " + stateName;
    }
}
