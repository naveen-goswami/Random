package UI;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.CharCounter;

/**
 * @author naveen.goswami
 * @since 6/5/2017
 */
public class GuiProcessor {

    public void process(Stage primaryStage) throws Exception {


        // Setting up the stage and scene
        Stage window;
        Scene scene;
        window = primaryStage;

        // Assigning title to the window
        window.setTitle("Character Count");

        // Setting up the grid
        GridPane grid = new GridPane();
        grid.setStyle("-fx-border-style: solid;");
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 20, 20, 20));

        //Instantiating the label and add it to the gird
        Label label = new Label("Text:");
        grid.add(label, 0, 1);

        //Setting up TextField for user input
        TextField inputText = new TextField();
        grid.add(inputText, 1, 1);

        //Setting up the response text below the TextField
        Text text = new Text();
        grid.add(text, 1, 2);

        // Instantiating Scene and setting the dimensions
        scene = new Scene(grid, 600, 300);
        window.setScene(scene);
        window.show();

        /**
         * At every key release calling the function
         * for character processing with entered string
         * as parameter to the calling function. Returned value
         * is displayed on the scene
         */
        inputText.setOnKeyReleased(e -> text.setText( CharCounter.characterProcessing(inputText.getText())));
    }

}
