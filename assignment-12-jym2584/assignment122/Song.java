package assignment122;

import java.io.File;

import javafx.*;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class Song {
    private final String description;
    private final Image image;
    private final MediaPlayer player;
    private final Media media;
    private final String uri;

    /**
     * Song constructor
     * @param description title - description
     * @param mediaPath song path
     * @param imagePath image path
     */
    public Song(String description, String mediaPath, String imagePath) {
        uri =  new File(mediaPath).toURI().toString();
        media = new Media(uri);
        player = new MediaPlayer(media);
        
        image = new Image(imagePath);
        this.description = description;
    }

    /**
     * Plays the song
     */
    public void play() {
        player.play();
    }

    /**
     * Pauses the song
     */
    public void togglePause() {
        Status status = player.getStatus();
        if (status == Status.PAUSED) {
            player.play();
        } else if (status == Status.PLAYING) {
            player.pause();
        }
    }

    /**
     * Rewinds the song by 10 seconds
     */
    public void rewind() {
        Duration skip = new Duration(-10000);
        Duration current = player.getCurrentTime();
        player.seek(current.add(skip));
    }

    /**
     * Skips the song by 10 seconds
     */
    public void fastForward() {
        Duration skip = new Duration(10000);
        Duration current = player.getCurrentTime();
        player.seek(current.add(skip));
    }

    /**
     * Stops the song
     */
    public void stop(){
        player.stop();
    }


    public String getDescription() {
        return description;
    }

    public MediaPlayer getPlayer() {
        return player;
    }

    public Image getImage() {
        return image;
    }

    public Media getMedia() {
        return media;
    }

}