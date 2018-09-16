/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import principal.Principal;

/**
 * FXML Controller class
 *
 * @author Laura
 */
public class Tela2Controle implements Initializable {

    enum Sexo{MASCULINO, FEMININO};
    
    @FXML
    JFXComboBox<Sexo> cbSexo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbSexo.getItems().setAll(Sexo.values());
    }    

    @FXML
    private void voltar() throws IOException {
        Parent imc = FXMLLoader.load(getClass().getResource("/visao/IMC.fxml"));
        Scene scene = new Scene(imc);
        Principal.getStagePrincipal().setScene(scene);
    
    }
    
}
