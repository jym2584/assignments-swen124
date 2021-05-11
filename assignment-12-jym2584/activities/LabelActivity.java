package activities;

import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application {
    private Label makeLabel(String text, Color textColor, Color backgroundColor) {
        Label label = new Label(text);
            label.setFont(new Font("Arial",36));
            label.setTextFill(textColor);
            label.setPadding(new Insets(30));
            label.setMaxWidth(Double.MAX_VALUE);
            label.setMaxHeight(Double.MAX_VALUE);
            label.setBackground(new Background(new BackgroundFill(
                                                backgroundColor, 
                                                new CornerRadii(8), 
                                                Insets.EMPTY)));
        return label;
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("My First GUI!");

        Label label = makeLabel("Hello JavaFX!", Color.ALICEBLUE, Color.DARKSLATEBLUE);
            label.setBorder(new Border(new BorderStroke(
                Color.BLACK, 
                BorderStrokeStyle.SOLID, 
                new CornerRadii(5), 
                BorderStroke.THICK)
            ));

        Label label2 = makeLabel("with Style!", Color.DARKGREEN, Color.CHARTREUSE);
        label2.setBorder(new Border(new BorderStroke(
            Color.LIMEGREEN, 
            BorderStrokeStyle.DASHED, 
            new CornerRadii(8), 
            BorderStroke.THICK)
        ));

        Label label3 = makeLabel("Goodbye JavaFX!", Color.ANTIQUEWHITE, Color.DODGERBLUE);
        label3.setBorder(new Border(new BorderStroke(
            Color.CORNFLOWERBLUE, 
            BorderStrokeStyle.DOTTED, 
            CornerRadii.EMPTY, 
            BorderStroke.MEDIUM)
        ));





        HBox box = new HBox(); //HBox (Horizontal Box) , VBox  (Vertical Box)
        box.getChildren().addAll(label, label2, label3);

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
