package reversi.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reversi.model.Color;
import reversi.model.Reversi;
import reversi.model.ReversiException;
import reversi.model.Square;
import reversi.model.SquareObserver;

public class ReversiGUI extends Application {
    private static final Image SQUARE = new Image("file:media/images/square.png");
    private static final Image BLANK = new Image("file:media/images/blank.png");
    private static final Image BLACK_PIECE = new Image("file:media/images/blackpiece.png");
    private static final Image WHITE_PIECE = new Image("file:media/images/whitepiece.png");

    private Label message;
    private Label playerOneScore;
    private Label playerTwoScore;

    private Reversi model;

    private Image getImage(Square square) {
        Image image = BLANK;

        if(square.isOccupied()) {
            if(square.getOccupyingColor() == Color.BLACK) {
                image = BLACK_PIECE;
            } else {
                image = WHITE_PIECE;
            }
        }
        return image;
    }


    private Button makeReversiButton(int row, int col) {
        Square square = model.getSquare(row, col);
        Image image = getImage(square);
        
        
        Button button = new Button("", new ImageView(image));
        button.setPadding(new Insets(0));
        button.setPrefSize(72, 72);
        //button.setText("Hello");
        button.setBackground(new Background(
            new BackgroundImage(SQUARE, 
                            BackgroundRepeat.NO_REPEAT, 
                            BackgroundRepeat.NO_REPEAT, 
                            BackgroundPosition.CENTER,
                            BackgroundSize.DEFAULT)
        ));

        button.setOnAction(new EventHandler<ActionEvent>(){ // can do lambda instead for this

            @Override
            public void handle(ActionEvent arg0) {
                
                try {
                    //System.out.println("Before: " + square);
                    model.move(row, col);
                    message.setText(square.toString());
                    //System.out.println("After: " + square);
                } catch (ReversiException e) {
                    //System.out.println(e.getMessage());
                    message.setText(e.getMessage());
                }
                
            }
            
        });



        SquareObserver observer = (s) -> {
            button.setGraphic(new ImageView(getImage(square))); // change graphic to be image view
        };

        square.register(observer);


        return button;
    }


    @Override
    public void start(Stage stage) throws Exception {
        model = new Reversi();
        model.start();

        message = new Label("Welcome to Reversii");
        playerOneScore = new Label("2");
        playerTwoScore = new Label("2");
        //int count = 0;
        GridPane pane = new GridPane(); // col, row order
        for(int col = 0; col < model.COLS; col++) {
            for(int row = 0; row < model.ROWS; row++) {
                Button button = makeReversiButton(row, col);
                //button.setText("" + count++);
                pane.add(button, col, row);
            }
        }

        HBox status = new HBox();
        status.getChildren().add(message);
        message.setFont(new Font("Comic Sans MS", 10));
        message.setPadding(new Insets(10));
        message.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);




        
        VBox players = new VBox();
        players.getChildren().addAll(playerOneScore, playerTwoScore);
        
        VBox.setVgrow(playerOneScore, Priority.ALWAYS); // always sends to front
        playerOneScore.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        playerOneScore.setFont(new Font("Impact", 18));
        playerOneScore.setPadding(new Insets(10));
        
        VBox.setVgrow(playerTwoScore, Priority.ALWAYS);
        playerTwoScore.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        playerTwoScore.setFont(new Font("Impact", 18));
        playerTwoScore.setPadding(new Insets(10));





        BorderPane border = new BorderPane();
        border.setLeft(players);
        border.setCenter(pane);
        border.setBottom(status);

        Scene scene = new Scene(border);

        stage.setScene(scene);

        stage.setTitle("Reversi");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
