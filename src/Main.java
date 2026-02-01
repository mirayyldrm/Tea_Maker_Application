public class Main {
    public static void main(String[] args) {
        TeaMakerModel model = new TeaMakerModel();
        TeaMakerView view = new TeaMakerView(model);
        TeaMakerController controller = new TeaMakerController(model, view);
    }
}