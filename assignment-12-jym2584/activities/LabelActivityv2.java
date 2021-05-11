package activities;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class LabelActivityv2 extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();

        Label label1 = makeLabel("Top", Color.ORANGE, Color.CYAN);
        label1.setBorder(new Border(
            new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(5),
            BorderStroke.THICK)));

        Label label2 = makeLabel("Middle", Color.ORANGE, Color.CYAN);
        label2.setBorder(new Border(
            new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(5),
            BorderStroke.THICK)));    

        Label label3 = makeLabel("Bottom", Color.BLUE, Color.WHITE);
        label3.setBorder(new Border(
            new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(5),
            BorderStroke.THICK)));

        box.getChildren().addAll(label1, label2, label3);

        Label label = new Label("Hello, world!");
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My first javafx app!");
        primaryStage.show();
    }

    private static Label makeLabel(String text, Color foreground, Color background) {
        Label label = new Label(text);
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(10));
        label.setBorder(new Border(
            new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(5),
            BorderWidths.DEFAULT)));
        label.setTextFill(foreground);
        label.setBackground(new Background(new BackgroundFill(background, new CornerRadii(5), Insets.EMPTY)));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
