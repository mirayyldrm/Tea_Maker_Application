import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeaMakerController implements ActionListener {
    TeaMakerModel model;
    TeaMakerView view;

    public TeaMakerController(TeaMakerModel model, TeaMakerView view) {
        this.model = model;
        this.view = view;

        view.setFilledListener(e -> {
            try {
                String input = view.getCupInput();
                if (input.isEmpty()) {
                    model.setMessage("Please enter a cup amount.");
                    model.notifyObservers();
                    return;
                }
                int c = Integer.parseInt(input);
                model.fill(c);
            } catch (NumberFormatException exception) {
                model.setMessage("Please enter a valid number.");
                model.notifyObservers();
            }
        });

        view.setStartListener(e -> model.start());
        view.setBoilListener(e -> model.boilWater());
        view.setResetListener(e -> model.reset());

        view.setTotalCupsListener(e -> {
            try {
                int total = DatabaseHelper.getInstance().getMonthlyCups();

                model.setMessage("Total Monthly Cups: " + total);
                view.setMonthlyCountDisplay(total);
                model.notifyObservers();

            } catch (Exception ex) {
                System.out.println("Database Error: " + ex.getMessage());
                ex.printStackTrace();
                model.setMessage("Database Error! Check console.");
                model.notifyObservers();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}