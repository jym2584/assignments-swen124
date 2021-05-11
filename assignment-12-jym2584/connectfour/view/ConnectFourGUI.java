package connectfour.view;

import connectfour.model.Checker;
import connectfour.model.CheckerObserver;
import connectfour.model.ConnectFour;
import connectfour.model.ConnectFourException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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


public class ConnectFourGUI extends Application {
    private static final Image EMPTY = new Image("file:media_assignment123/empty.png");
    private static final Image YELLOW = new Image("file:media_assignment123/yellow_piece.png");
    private static final Image RED = new Image("file:media_assignment123/red_piece.png");
    private static final Image NOTHING = new Image("file:media_assignment123/nothing.png");
    private ConnectFour model;
    private Label turn = new Label("");
    private Label message = new Label("");


    private GridPane board;
    private Node[][] buttons = new Node[model.COLS][model.ROWS];

    /**
     * Gets the checker's color
     * @param checker checker enum
     * @return returns an image based on the checker's color
     */
    private Image getCheckerColor(Checker checker) {
        Image image = NOTHING;

        if (checker == Checker.BLACK) {
            image = YELLOW;
        } else if (checker == Checker.RED) {
            image = RED;
        }

        return image;
    }

    /**
     * Image of the connect four board. Not really supposed to be buttons but eh still works haha (pls dont dock points :( )
     * @param row checker position x 
     * @param col checker position y
     * @return technically an image of the piece
     */
    private Button makeConnectFourImage(int row, int col) {
        Checker checker = model.getChecker(col, row);
        Image image = getCheckerColor(checker);
        
        
        Button button = new Button("", new ImageView(image)); // always blank
        button.setPadding(new Insets(0));
        //button.setText("Hello");
        button.setBackground(new Background(
            new BackgroundImage(EMPTY, 
                            BackgroundRepeat.NO_REPEAT, 
                            BackgroundRepeat.NO_REPEAT, 
                            BackgroundPosition.CENTER,
                            BackgroundSize.DEFAULT)
        ));

        /*
        CheckerObserver observer = (board,row,col) -> {
            button.setGraphic(new ImageView(getCheckerColor(checker))); // change graphic to be image view
        };

        model.register(observer);
        */
        

        return button;
    }

    /**
     * Making da mooovvvvv (button that makes a move)
     * @param column piece to drop the checker
     * @return a button
     */
    private Button makeMoveButton(int column) {
        Button button = new Button("" + column);
        button.setPrefSize(72, 30);
        
        button.setOnAction( (e) -> {
            try {
                model.move(column);
                //updateImage(column, model.ROWS - model.getCheckersInColumn()[column]);
                turn.setText(String.format(" It is %s's turn.", model.getCurrentPlayer()));
                message.setText("");
            } catch (ConnectFourException cfe) {
                message.setText(cfe.getMessage());
            }
        });

        
        return button;
    }


    /* deprecated method
    public void updateImage(int col, int row) {
        Checker checker = model.getChecker(col, row);
        Image image = getCheckerColor(checker);
    
        ((Button)buttons[col][row]).setGraphic(new ImageView(image));
    }
    */


    @Override
    public void start(Stage stage) throws Exception {
        model = new ConnectFour();
        turn.setText(String.format(" It is %s's turn.", model.getCurrentPlayer()));

        /* Main board */
        VBox main = new VBox();
            
        // Moves buttons
            GridPane moves = new GridPane(); // col, row order
            for(int col = 0; col < model.COLS; col++) {
                Button button = makeMoveButton(col);
                moves.add(button, col, 0);
            }
            
            // Adding images to the board
            board = new GridPane();
            for(int col = 0; col < model.COLS; col++) {
                for(int row = 0; row < model.ROWS; row++) {
                    Button button = makeConnectFourImage(row, col);
                    board.add(button, row, col);

                    final int finalCol = col; // have to add these somehow to be able to use them... 
                    final int finalRow = row; // ... in the lambda expression
                    model.register((cf, c, r) -> { // observers
                        Checker checker = model.getChecker(finalRow, finalCol);
                        button.setGraphic(new ImageView(getCheckerColor(checker)));
                    });
                }
            }

            // Box for printing out the player's current turn & any error messages (and the reset message)
            VBox status = new VBox();
            status.getChildren().addAll(
                turn,
                message
            );

            turn.setFont(new Font("Arial", 20));
            message.setFont(new Font("Arial", 20));
            message.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            message.setAlignment(Pos.CENTER);
            status.setAlignment(Pos.CENTER);


            // Clearing the board
            Button reset = new Button("Clear Board");
            reset.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            reset.setPadding(new Insets(5));
            reset.setOnAction( (e) -> {
                model.reset();

                turn.setText(String.format(" It is %s's turn.", model.getCurrentPlayer()));
                message.setText("Resetted!");
            });

        main.getChildren().addAll(
            reset,    
            board,
            moves,
            new Label(""),
            status,
            new Label("")
        );
        main.setAlignment(Pos.CENTER);

        BorderPane border = new BorderPane();
        border.setCenter(main);


        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Connect Four!");
        stage.show();

        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
