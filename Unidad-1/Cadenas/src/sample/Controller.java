package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
    @FXML Label lbllineas;
    @FXML TextArea txtreceta;
    @FXML protected void initialize(){
 try {
     File f =new File("./src/sample/archivo.txt");
     BufferedReader br=new BufferedReader((new FileReader(f)));
     String texto="";
     while ((texto=br.readLine())!=null){
        txtreceta.appendText("\n"+texto);
     }

 }catch (Exception e){
     txtreceta.setText(e.getMessage());
 }
    }
    public void procesar(ActionEvent event){
        String[] arreglolineas= txtreceta.getText().split("\n");
        lbllineas.setText("Lineas= "+arreglolineas.length);
        boolean encontro=false;
        for (int x=0;x<arreglolineas.length;x++){
            if (arreglolineas[x].contains("queso")){
                String[] arre2=arreglolineas[x].split(" ");
                System.out.println(arre2[0]);

            }
            if (arreglolineas[x].contains("manzanas")){
                String[] arre2=arreglolineas[x].split(" ");
                System.out.println("unidad: "+arre2[1]);
            }
            if (encontro){

                System.out.println(arreglolineas[x]);

            }
            if (arreglolineas[x].contains("***")){
                encontro=true;
            }
        }
    }
}
