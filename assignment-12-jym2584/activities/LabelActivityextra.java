package activities;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class LabelActivityextra extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello, world!");

        label.setFont(new Font("Courier New", 48));
        label.setTextFill(Color.YELLOW);
        label.setPadding(new Insets(10, 20, 30, 40));
        label.setBackground(new Background(new BackgroundFill(Color.MAROON, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(Pos.CENTER);

        Scene scene = new Scene(label);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My first javafx app!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
