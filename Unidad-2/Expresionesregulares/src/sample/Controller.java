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
    listaEjer.getItems().addAll("Ejercicio 1","Ejercicio 2","No comienza con db-","Palabra termina con Count","Dos nombres","Validar una MAC address"
    ,"Empieza y termina con mayúscula","Validar numero binario","Validar un número Hexadecimal","Validar una operación de un digito","Número de control del ITSNCG"
    ,"Validar CURP");
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
            expresion="(^[^db-])([A-Za-z]+)";
            break; }
        case 3:{
            expresion="([a-zA-Z]+)(count)$";
            break;
        }
        case 4:{
            expresion="([A-Z]{4,8})\\s([a-zA-Z]{4,8})";
            break;
        }
        case 5:{
            expresion="^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
            break;
        }
        case 6:{
            expresion="^[A-Z]\\w{1,10}\\w[A-Z]$";
            break;
        }
        case 7:{
            expresion="^[0|1]{8}$";
            break;
        }
        case 8:{
            expresion="^[0-9A-F]{6}$";
            break;
        }
        case 9:{
            expresion="^(\\d{1})([-+/*]{1})(\\d{1})$";
            break;
        }
        case 10:{
            expresion="^(\\d{2})(CG|cg)(\\d{4})$";
            break;
        }
        case 11:{
            expresion="^([A-Z]{1})([AEIOU]{1})([A-Z]{2})([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([HM]{1})(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)([B-DF-HJ-NP-TV-Z]{3})([0-9A-Z]{1})([0-9]{1})$";
            break;
        }


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
