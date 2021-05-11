package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    private int numClicks = 0;
    @Override
    public void start(Stage arg0) throws Exception {
        DimmableLight light = new DillambeL
        
        Label label = new Label("Number of clicks");
        label.setFont(new Font("Arial", 24));
        label.setPadding(new Insets(10));

        Label clicks = new Label(numClicks + "");
        clicks.setFont(new Font("Arial", 64));
        clicks.setPadding(new Insets(20));
        clicks.setAlignment(Pos.CENTER);
        clicks.setBackground(new Background(new BackgroundFill(Color.CYAN,
        CornerRadii.EMPTY,
        Insets.EMPTY)));
        clicks.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button button = new Button("Click me");
        button.setFont(new Font("Arial", 24));
        button.setPadding(new Insets(10));
        button.setAlignment(Pos.CENTER);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction( (e) -> {
            numClicks++;
            clicks.setText(numClicks + "");
        });
        
        VBox box = new VBox();
        box.getChildren().addAll(label, clicks, button);

        Scene scene = new Scene(box);
        arg0.setTitle("Click Counter");
        arg0.setScene(scene);

        arg0.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
