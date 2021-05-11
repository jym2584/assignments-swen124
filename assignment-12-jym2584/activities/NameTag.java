package activities;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("HELLO MY NAME IS");
        hello.setAlignment(Pos.CENTER);
        hello.setFont(new Font("Impact", 20));
        hello.setPadding(new Insets(10));
        hello.setTextFill(Color.BLUE);
        hello.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label name = new Label("Your Name");
        name.setFont(new Font("Comic Sans MS", 48));
        name.setTextFill(Color.RED);
        name.setPadding(new Insets(20));
        name.setAlignment(Pos.CENTER);
        name.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Image i = new Image("file:media/images/smb.gif");
        ImageView iv = new ImageView();
        StackPane spane = new StackPane();

        VBox nameTag = new VBox();
        nameTag.setBorder(new Border(new BorderStroke(Color.BLUE, 
            BorderStrokeStyle.SOLID, new CornerRadii(10), 
            BorderStroke.THICK)));
        nameTag.getChildren().addAll(
            hello,
            name
        );
        spane.getChildren().addAll(iv, nameTag);

        //System.out.println(iv.getImage().getUrl());

        String path = "file:media/sounds/buzzer.wav";
        Media media = new Media(path);
        MediaPlayer player = new MediaPlayer(media);

        Media media2 = new Media("file:media/sounds/end.wav");
        MediaPlayer player2 = new MediaPlayer(media2);

        player.play();
        
        TextField field = new TextField();
        field.setPromptText("Enter Your Name");
        field.setAlignment(Pos.CENTER);
        field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button update = new Button("Update Name Tag");
        update.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //create event handler
        // Updater updatebuttonhandler = new Updater(field, name);
        // update.setOnAction(updatebuttonhandler);

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.MAX_VALUE, Double.MIN_VALUE);

        ImageView brickim = new ImageView("file:media/images/smb/brick.png");
        Button tune2 = new Button("End tune", brickim);
        tune2.setMaxSize(Double.MAX_VALUE, Double.MIN_VALUE);
        tune2.setContentDisplay(ContentDisplay.TOP);

        VBox box = new VBox();
        box.getChildren().addAll(
            spane,
            field,
            update,
            clear,
            tune2
        );


        update.setOnAction((ActionEvent e) -> {name.setText(field.getText());});

        clear.setOnAction((ActionEvent e) -> {player.stop(); player.play();});

        tune2.setOnAction((ActionEvent e) -> { player2.stop(); player2.play();});

        primaryStage.setTitle("Your Name");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
