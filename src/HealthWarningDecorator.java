public class HealthWarningDecorator extends MessageDecorator {
    MessageDisplay messageDisplay;
    public HealthWarningDecorator(MessageDisplay messageDisplay){
        this.messageDisplay = messageDisplay;
    }

    @Override
    public String getDescription() {
        return messageDisplay.getDescription() + "\n The number of total cups today has reached the limit";
    }
}
