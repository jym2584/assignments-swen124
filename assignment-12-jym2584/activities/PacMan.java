package activities;
import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacMan extends Application {
    private static final String PATH = "media\\sounds\\";

    @Override
    public void start(Stage stage) throws Exception {
        VBox v = new VBox();
        v.getChildren().addAll(
            makeButton("Start", PATH+"start.wav"),
            makeButton("Chomp", PATH+"chomp.wav"),
            makeButton("Eat", PATH+"eat.wav"),
            makeButton("Gameover", PATH+"end.wav")
        );

        stage.setScene(new Scene(v));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    private Button makeButton(String text, String path){
        Button start = new Button(text);
        start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        start.setPadding(new Insets(10));
        String uri =  new File(path).toURI().toString();
        Media media = new Media(uri);
        MediaPlayer mp = new MediaPlayer(media);
        start.setOnAction((e) -> {
            System.out.println(mp.getStatus());
            switch(mp.getStatus()){
                case PLAYING:
                    System.out.println("Stopped song");
                    mp.stop();
                    break;
                case READY:
                    System.out.println("Playing song");
                    mp.play();
                    break;
                case STOPPED:
                System.out.println("Playing song");
                    mp.play();
                    break;
                case DISPOSED:
                    break;
                case HALTED:
                    break;
                case PAUSED:
                    break;
                case STALLED:
                    break;
                case UNKNOWN:
                    break;
                default:
                    break;
                }

        });
        return start;
    }
}