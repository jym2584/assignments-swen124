package activities;
import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GridPaneActivity extends Application {
    private Label makeLabel(String text, Color textColor, Color backgroundColor) {
        Label label = new Label(text);
            label.setFont(new Font("Arial",36));
            label.setTextFill(textColor);
            label.setPadding(new Insets(30));
            label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            label.setBackground(new Background(new BackgroundFill(
                backgroundColor, 
                new CornerRadii(8), 
                Insets.EMPTY)
            ));
        return label;
    }


    @Override
    public void start(Stage arg0) throws Exception {
        Label result = makeLabel("0", Color.BLACK, Color.WHITE);
        result.setBorder(new Border(new BorderStroke(
            Color.BLACK, 
            BorderStrokeStyle.SOLID, 
            CornerRadii.EMPTY, 
            BorderStroke.MEDIUM)
        ));

        Label zero = makeLabel("0", Color.BLACK, Color.LIGHTGRAY);
        Label one = makeLabel("1", Color.BLACK, Color.LIGHTGRAY);
        Label two = makeLabel("2", Color.BLACK, Color.LIGHTGRAY);
        Label three = makeLabel("3", Color.BLACK, Color.LIGHTGRAY);
        Label four = makeLabel("4", Color.BLACK, Color.LIGHTGRAY);
        Label five = makeLabel("5", Color.BLACK, Color.LIGHTGRAY);
        Label six = makeLabel("6", Color.BLACK, Color.LIGHTGRAY);
        Label seven = makeLabel("7", Color.BLACK, Color.LIGHTGRAY);
        Label eight = makeLabel("8", Color.BLACK, Color.LIGHTGRAY);
        Label nine = makeLabel("9", Color.BLACK, Color.LIGHTGRAY);
        Label plus = makeLabel("+", Color.BLACK, Color.LIGHTGRAY);
        Label minus = makeLabel("-", Color.BLACK, Color.LIGHTGRAY);
        Label divide = makeLabel("/", Color.BLACK, Color.LIGHTGRAY);
        Label multiply = makeLabel("x", Color.BLACK, Color.LIGHTGRAY);
        Label modulo = makeLabel("%", Color.BLACK, Color.LIGHTGRAY);
        Label equals = makeLabel("=", Color.BLACK, Color.LIGHTGRAY);


        GridPane pane = new GridPane();
        pane.add(result, 0, 0, 4, 1);
        pane.add(one, 0, 1);
        pane.add(two, 1, 1);
        pane.add(three, 2, 1);
        pane.add(plus, 3, 1);

        pane.add(four, 0, 2);
        pane.add(five, 1, 2);
        pane.add(six, 2, 2);
        pane.add(minus, 3, 2);
        
        pane.add(seven, 0, 3);
        pane.add(eight, 1, 3);
        pane.add(nine, 2, 3);
        pane.add(equals, 3, 3);



        Scene scene = new Scene(pane);
        arg0.setScene(scene);
        arg0.show();

    }


    
    public static void main(String[] args) {
        launch(args);
    }
    
}
