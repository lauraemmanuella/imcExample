package util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

/**
 *
 * @author Laura
 */
public class Util {

    public static void gerarDialogo(String title, String content, StackPane stack) {
        Text titulo = new Text();
        titulo.setText(title);
        titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

        JFXDialogLayout dialogContent = new JFXDialogLayout();
        dialogContent.setHeading(titulo);
        dialogContent.setBody(new Text(content));

        JFXButton close = new JFXButton("Fechar");
        close.setButtonType(JFXButton.ButtonType.FLAT);
        close.setStyle("-fx-background-color:  #4059a9; -fx-text-fill: white;");

        dialogContent.setActions(close);
        JFXDialog dialog = new JFXDialog(stack, dialogContent, JFXDialog.DialogTransition.CENTER);
        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent __) {
                dialog.close();
            }
        });
        dialog.show();
    }

    public static StringConverter<LocalDate> converterData() {
        String pattern = "dd/MM/yyyy";
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        return converter;
    }
}
