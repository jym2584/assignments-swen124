package activities;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VBoxExample extends Application {
    @Override
    public void start(Stage stage){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
            makeLabel("Top", Color.LIGHTBLUE, Color.DARKBLUE),
            makeLabel("Center", Color.MAROON, Color.YELLOW),
            makeLabel("Bottom", Color.VIOLET, Color.GREENYELLOW)
        );

        Scene scene = new Scene(vbox);

        stage.setTitle("HBox ex");
        stage.setScene(scene);
        stage.show();
    }

    private static Label makeLabel(String text, Color foreground, Color background) {
        Label label = new Label(text);
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(10));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), null, Insets.EMPTY)));
        return label;
    }

    
}
