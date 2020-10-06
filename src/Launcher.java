
public class Launcher {
	public static void main(String[] args) {
		RunController controller = new RunController();
		UI view = new UI(controller);
		controller.setView(view);
		
	}
}
