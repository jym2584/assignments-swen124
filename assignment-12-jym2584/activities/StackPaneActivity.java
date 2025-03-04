package activities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StackPaneActivity extends Application
{

    @Override
    public void start(Stage stage) throws Exception 
    {
        ImageView head = new ImageView("file:media/images/emojis/headblue.png");
        ImageView eyes = new ImageView("file:media/images/emojis/eyesgreen.png");
        ImageView brows = new ImageView("file:media/images/emojis/browsangry.png");
        ImageView nose = new ImageView("file:media/images/emojis/nosered.png");
        ImageView mouth = new ImageView("file:media/images/emojis/mouthohno.png");
        
        StackPane pane = new StackPane();
        pane.getChildren().addAll(head, eyes, brows, nose, mouth);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }

} 