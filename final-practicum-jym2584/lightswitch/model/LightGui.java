package lightswitch.model;

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

public class LightGui extends Application {
    @Override
    public void start(Stage arg0) throws Exception {
        DimmableLight light = new DimmableLight();
        
        Label clicks = new Label("");
        clicks.setFont(new Font("Arial", 64));
        clicks.setPadding(new Insets(200));
        clicks.setAlignment(Pos.CENTER);
        clicks.setBackground(new Background(new BackgroundFill(Color.BLACK,
        CornerRadii.EMPTY,
        Insets.EMPTY)));
        clicks.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button button = new Button("Change Lights");
        button.setAlignment(Pos.CENTER);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction( (e) -> {
            light.flipLights();
            int luminosity = light.getLuminosity();
            
            if(luminosity == 100) {
                clicks.setBackground(new Background(new BackgroundFill(Color.YELLOW,
                CornerRadii.EMPTY,
                Insets.EMPTY)));
            } else if (luminosity == 50) {
                clicks.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN,
                CornerRadii.EMPTY,
                Insets.EMPTY)));
            } else {
                clicks.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY,
                Insets.EMPTY)));
            }


        });
        
        VBox box = new VBox();
        box.getChildren().addAll(clicks, button);

        Scene scene = new Scene(box);
        arg0.setTitle("Light Changer");
        arg0.setScene(scene);

        arg0.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
