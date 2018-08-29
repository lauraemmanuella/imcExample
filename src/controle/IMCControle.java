package controle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import modelo.IMC;
import util.Util;
import principal.Principal;

/**
 *
 * @author Laura
 */
public class IMCControle implements Initializable {

    @FXML
    private StackPane stack;
    
    @FXML
    private JFXDatePicker data;

    @FXML
    private JFXTextField peso, altura;

    @FXML
    private Label label;

    private IMC imc;

    //Todos os eventos que tiverem que ocorrer quando a tela for aberta, devem ser colocados nesse método
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.setConverter(Util.converterData());
    }

    @FXML
    private void calcularIMC() {
        if(!peso.getText().isEmpty() && !altura.getText().isEmpty() && data.getValue()!=null){
            double p = Double.parseDouble(peso.getText());
            double a = Double.parseDouble(altura.getText());
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String d = dateFormatter.format(data.getValue());
           
            imc = new IMC(p, a);
            DecimalFormat df = new DecimalFormat("0.##");
            label.setText(df.format(imc.getImc()));
            String conteudo = "Analise no dia " + d + "\nIMC = " + df.format(imc.getImc()) + "\nSituacao = " + imc.verificarSituacao();
            Util.gerarDialogo("Índice de Massa Corporal", conteudo, stack);
        }
    }
    
    @FXML
    private void limpar() {
        peso.setText("");
        altura.setText("");
        label.setText("");
        data.setValue(null);
    }

    @FXML
    private void mudarTela() throws IOException {
        Parent tela2 = FXMLLoader.load(getClass().getResource("/visao/Tela2.fxml"));
        Scene scene = new Scene(tela2);
        Principal.getStagePrincipal().setScene(scene);
    }

}
