import UI.GuiProcessor;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Main Class
 *
 * @author naveen.goswami
 * @since 6/5/2017
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * Instantiating the frontend
         */
        GuiProcessor processor = new GuiProcessor();

        /**
         * Passing the primary stage
         */
        processor.process(primaryStage);
    }
}