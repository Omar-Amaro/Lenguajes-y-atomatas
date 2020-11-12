package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML TextField txtmensaje;
    @FXML VBox vbox;

    public void Enter (KeyEvent event){
        if (event.getCode()== KeyCode.ENTER){
            Label label=new Label("Usuario dice> "+ txtmensaje.getText());
            vbox.getChildren().add(label);
            String respuesta= chatbot(txtmensaje.getText());
            Label label2=new Label(respuesta);
            vbox.getChildren().add(label2);
            txtmensaje.setText("");


        }

    }
    boolean pediralgo=false;
    public String chatbot(String mensaje){
       String respuesta="El refo dice> "+"¿Podrias repetir la pregunta?";
       if (mensaje.contains("hola")){
           respuesta="El refo dice> "+ "Hola, ¿En que puedo ayudarte?";
        }else if (mensaje.contains("pieza")){
           respuesta="El refo dice> "+" Escriba la marca, modelo y cual pieza necesita";
           pediralgo=true;
       }else if (pediralgo){

           String[] dato= mensaje.split(" ");
           String modelo= dato[1];
           int indice1= mensaje.indexOf(modelo) +modelo.length();

           int indice2=mensaje.length();
            String pieza=mensaje.substring(indice1, indice2);
           respuesta="El refo dice>" +" El producto "+ pieza+" del auto "+dato[0]+" "+dato[1]+" si esta en existencia";
           pediralgo=false;
       }
       return respuesta;
    }
}
