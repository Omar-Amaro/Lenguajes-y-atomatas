package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML TextField txttexto;
    @FXML ListView listaEjer;
    @FXML Label lblresultado;
    @FXML protected void initialize(){
    listaEjer.getItems().addAll("Ejercicio 1","Ejercicio 2","Validar Password");
    }
    public void  procesar (ActionEvent event){
    int seleccion= listaEjer.getSelectionModel().getSelectedIndex();
        String texto= txttexto.getText();
        String expresion="";

    switch (seleccion){
        case 0:{
            expresion="^[^_][^p]([a-zA-Z0-9]{3,})[q|w]$";

            break;}
        case 1:{
            expresion="\\+([a-zA-Z ]+)";
            break; }
        case 2:{
            expresion="^Esta es la contraseña$|^Esta es la otra contraseña$";
            //NO SUPE EXPRESARLO DE OTRA MANERA NO PUDE USAR LOS []

            break; }
    }
        Pattern patron= Pattern.compile(expresion);
        Matcher matcher= patron.matcher(texto);
        if (matcher.matches()){
            lblresultado.setText("Si Cumple");
        }else {
            lblresultado.setText("No Cumple");
        }
    }
}
