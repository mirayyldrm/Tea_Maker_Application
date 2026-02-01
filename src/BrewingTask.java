import java.util.TimerTask;
import javax.swing.SwingUtilities;

public class BrewingTask extends TimerTask {
    TeaMakerModel model;

    public BrewingTask(TeaMakerModel model){
        this.model = model;
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(() -> {
            model.setState(model.getDoneState());

            try {
                DatabaseHelper.getInstance().logTea(model.getCups());
            } catch (Exception e) {
                System.out.println("DB Error");
            }

            model.setMessage("Process finished! Please RESET.");
            model.notifyObservers();
        });
    }
}