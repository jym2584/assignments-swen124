package activities;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewer extends Application {
    @Override
    public void start(Stage stage) {
        Image image = new Image("media/images/sunflowers.jpg");
        ImageView view = new ImageView(image);
        HBox box = new HBox();
        box.getChildren().addAll(view);
        
        stage.setTitle("Image");
        stage.setScene(new Scene(box));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}