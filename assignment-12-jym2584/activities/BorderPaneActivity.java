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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class BorderPaneActivity extends Application {
    private Label makeLabel(String text, Color textColor, Color backgroundColor) {
        Label label = new Label(text);
            label.setFont(new Font("Arial",36));
            label.setTextFill(textColor);
            label.setPadding(new Insets(30));
            label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            label.setBackground(new Background(new BackgroundFill(
                                                backgroundColor, 
                                                new CornerRadii(8), 
                                                Insets.EMPTY)));
        return label;
    }


    @Override
    public void start(Stage arg0) throws Exception {
        Label top = makeLabel("Top", Color.DIMGRAY, Color.BISQUE);
        Label left = makeLabel("Left", Color.DIMGRAY, Color.RED);
        Label middle = makeLabel("Center", Color.DIMGRAY, Color.BLUE);
        Label right = makeLabel("Right", Color.DIMGRAY, Color.GREEN);
        Label bottom = makeLabel("Bottom", Color.DIMGRAY, Color.LIME);

        BorderPane pane = new BorderPane();
        pane.setTop(top);
        pane.setLeft(left);
        pane.setCenter(middle);
        pane.setRight(right);
        pane.setBottom(bottom);

        Scene scene = new Scene(pane);
        arg0.setScene(scene);
        arg0.show();

    }


    
    public static void main(String[] args) {
        launch(args);
    }
}
