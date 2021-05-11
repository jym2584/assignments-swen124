package activities;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent> {
    private final TextField textField;
    private final Label label;

    public Updater(TextField text, Label labe) {
        textField = text;
        label = labe;
    }

    @Override
    public void handle(ActionEvent event) {
        String text = textField.getText();
        label.setText(text);
    }


}
