package assignment122;
import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MusicPlayerGUI extends Application {

    private static final String PATH = "media\\sounds\\";
    private static final String SONG_PATH = "media_assignment122\\songs\\";
    private static final String IMAGE_PATH = "media_assignment122\\images\\";

    /**
     * List of songs. Automatically adds to the GUI
     */
    protected static final ArrayList<Song> songs_list = new ArrayList<>(); static {
        songs_list.add(new Song("That's the World of Warcraft That You Play! - ibeckman671", SONG_PATH+"game_of_wow.mp3", IMAGE_PATH + "game_wow_ibeckman671.png"));
        songs_list.add(new Song("Bromance - nigahiga", SONG_PATH+"bromance.mp3", IMAGE_PATH + "nigahiga.png"));
        songs_list.add(new Song("Karma - Dareharu", SONG_PATH+"karma.mp3", IMAGE_PATH + "dareharu.png"));
        songs_list.add(new Song("Bassline Junkie - Dizzie Rascal", SONG_PATH+"bassline_junkie.mp3", IMAGE_PATH + "dizzie_rascal.png"));
        songs_list.add(new Song("DO IT! - 별빛우주선 (Team Starlight Spaceship)", SONG_PATH+"do_it.mp3", IMAGE_PATH + "do_it.png"));
    }

    /**
     * Currently playing song
     */
    private Song currentlyPlaying = null;
    /**
     * Image of the song
     */
    private Image currentImage = new Image(IMAGE_PATH + "blank.png");
    /** 
     * Image embedding
    */
    private ImageView view = new ImageView(currentImage);
    
    /** 
     * Label of currently playing song
     */
    Label currentSong = new Label("None playing");

    @Override
    public void start(Stage stage) throws Exception {
        
        VBox songs = new VBox();
        songs.getChildren().addAll(
            new Label("Songs")
        );
        songs.setAlignment(Pos.BASELINE_CENTER);
        
        /* Images */
        VBox image = new VBox();
        image.getChildren().addAll(
            new Label("Artist Image"),
            view,
            new Label("Current Song:"),
            currentSong,
            new Label(""),
            new Label("Media Controls")
        );

        /* Add songs */
        for(int i = 0; i < songs_list.size(); i++) {
            songs.getChildren().add(songButton(songs_list.get(i)));
        }


        /* Media Buttons */
        Button play = playerButton("Play");
        play.setOnAction( (e) -> {
            currentlyPlaying.play();
            currentSong.setGraphic(new ImageView(new Image(IMAGE_PATH + "loader.gif", 20, 20, false, false)));
            
        });

        Button stop = playerButton("Stop");
        stop.setOnAction( (e) -> {
            currentlyPlaying.stop();
            currentSong.setGraphic(new ImageView(new Image(IMAGE_PATH + "loader_stopped.png", 20, 20, false, false))); 
        });

        Button toggle = playerButton("Toggle pause");
        toggle.setOnAction( (e) -> {
            currentlyPlaying.togglePause();
            if(currentlyPlaying.getPlayer().getStatus() == Status.PAUSED) {
                currentSong.setGraphic(new ImageView(new Image(IMAGE_PATH + "loader.gif", 20, 20, false, false))); 
            } else {
                currentSong.setGraphic(new ImageView(new Image(IMAGE_PATH + "loader_stopped.png", 20, 20, false, false))); 
            }
        });

        Button rewind = playerButton("Rewind");
        rewind.setOnAction( (e) -> {
            currentlyPlaying.rewind();
        });

        Button fast = playerButton("Fast Forward");
        fast.setOnAction( (e) -> {
            currentlyPlaying.fastForward();
        });


        HBox mediaButtons = new HBox();
        mediaButtons.getChildren().addAll(
            play, stop, toggle, rewind, fast
        );

        VBox title = new VBox();
        Label titleLabel = new Label("An awesome media player! (not really)", new ImageView(new Image(IMAGE_PATH + "dance.gif", 50, 50, false, false)));
        titleLabel.setFont(new Font("Arial", 20));
        title.getChildren().addAll(new Label(),titleLabel, new Label());
        title.setAlignment(Pos.CENTER);

        /* Setting up elements */
        BorderPane pane = new BorderPane();
        pane.setBottom(mediaButtons);
        pane.setRight(songs);
        pane.setLeft(image);
        pane.setTop(title);
        
        stage.setTitle("Media Player");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    /**
     * Song button. Plays once pressed
     * @param song song
     * @return
     */
    public Button songButton(Song song) {
        Button button = new Button(song.getDescription());
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setPadding(new Insets(10));

        button.setOnAction((e) -> {
            if(currentlyPlaying == null) {
                currentlyPlaying = song;
                currentImage = currentlyPlaying.getImage();
                view.setImage(currentImage);
            } else {
                currentlyPlaying.stop();
            }

            currentlyPlaying = song;
            currentlyPlaying.play();
            currentImage = currentlyPlaying.getImage();
            view.setImage(currentImage);
            currentSong.setText(currentlyPlaying.getDescription().split(" - ")[0]);
            currentSong.setGraphic(new ImageView(new Image(IMAGE_PATH + "loader.gif", 20, 20, false, false))); 
        });

        return button;
    }

    /**
     * Media control buttons
     * @param text
     * @return
     */
    public Button playerButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setPadding(new Insets(10));

        return button;
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
