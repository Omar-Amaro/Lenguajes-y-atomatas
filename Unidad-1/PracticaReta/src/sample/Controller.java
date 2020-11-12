package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
    @FXML TextArea txtreceta, txtingredientes, txtpreguntas, txtpreparacion,txtrespuestas;
    @FXML Label lbllineas;
    @FXML
    protected void initialize() {
        //Colocacion de texto en los TextArea
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
        try {
            File ff=new File("./src/sample/archivoing.txt");
            BufferedReader br=new BufferedReader((new FileReader(ff)));
            String texto="";
            while ((texto=br.readLine())!=null){
                txtingredientes.appendText("\n"+texto);
            }

        }catch (Exception e){
            txtingredientes.setText(e.getMessage());
        }
        try {

            File fff=new File("./src/sample/archivoprep.txt");
            BufferedReader br=new BufferedReader((new FileReader(fff)));
            String texto="";
            while ((texto=br.readLine())!=null){
                txtpreparacion.appendText("\n"+texto);
            }

        }catch (Exception e){
            txtpreparacion.setText(e.getMessage());
        }




    }





    public void procesar(ActionEvent event) {
        String[] arreglopreguntas = txtpreguntas.getText().split("\n");
        String[] arregloingredientes= txtingredientes.getText().split("\n");
        String[] arreglopreparacion= txtpreparacion.getText().split("\n");

//primera pregunta
        for (int x=0;x<arreglopreguntas.length;x++){
            if (arreglopreguntas[x].contains("¿Cuántos gramos de chiles en total son utilizados?")){
                arregloingredientes[x].split(" ");
                txtrespuestas.setText(arregloingredientes[3] +"\n" +arregloingredientes[4]+"\n"+arregloingredientes[5]+"\n"+"Total= 970gr");
                System.out.println(arregloingredientes[3] +"\n" +arregloingredientes[4]+"\n"+arregloingredientes[5]+"\n"+"Total= 970gr");

            }

        }
        //segunda pregunta
        for (int x=0;x<arreglopreguntas.length;x++){
            if (arreglopreguntas[x].contains("¿Cuál es el cuarto paso del proceso de preparación?")){
                arregloingredientes[x].split(" ");
                txtrespuestas.setText(arreglopreparacion[9]);
                System.out.println(arreglopreparacion[9]);

            }



        }
//Tercera pregunta
        for (int x=0;x<arreglopreguntas.length;x++) {
            if (arreglopreguntas[x].contains("asadas")|| arreglopreguntas[x].contains("asada")) {
                arregloingredientes[x].split(" ");
                txtrespuestas.setText(arregloingredientes[6]+"\n"+arregloingredientes[7]+"\n"+arregloingredientes[13]);
                System.out.println(arregloingredientes[6]+"\n"+arregloingredientes[7]+"\n"+arregloingredientes[13]);

            }
        }

        //No encontre la manera de terminar la ultima parte de las preguntas

    }
}

