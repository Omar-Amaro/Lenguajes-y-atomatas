package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField txtFrase;
    @FXML Label lblResultado;
    @FXML ComboBox combo;
    @FXML protected void initialize (){
        combo.getItems().addAll("CharAt","Ends With","CompareTo","EqualsIgnoreCase","IndexOf","LastIndexOf",
                "Replace","ReplaceFirst","Split","Startswith","Substring");
    }
    public void evento (ActionEvent event){
        String texto=txtFrase.getText();
    switch (combo.getSelectionModel().getSelectedIndex()){

        case 0:{
            char res=texto.charAt(2);
            lblResultado.setText(res +"");
            break;
        }
        case 1:{
            boolean res=texto.endsWith("lolo");
            lblResultado.setText(res+"");
            break;
        }
        case 2:{
            int res=texto.compareTo("hola");
            lblResultado.setText(res+"");
            //No entendi como da los resultados este :(

            break;

        }
        case 3:{
            boolean res=texto.equalsIgnoreCase("hola");
            lblResultado.setText(res+"");
            break;

        }
        case 4:{
            int res=texto.indexOf("H",3);
            lblResultado.setText(res+"");
            break;
            //ESTE SI :)
        }
        case 5:{
            int res=texto.lastIndexOf("Hola a todos");
            lblResultado.setText(res+"");
            break;
            //Tambien :)

        }
        case 6:{
            String res=texto.replace("Hola","¿Como estas?");
            lblResultado.setText(res);
            break;
            //Tambien :)

        }

        case 7:{
            String res=texto.replaceFirst("i","1");
            lblResultado.setText(res);
            break;
            //Tambien pero con nariz :=)

        }
        case 8:{

            String palabras= "Hola, mundo, como, estas";
            String[] res=palabras.split(",",2);
            for (int i=0;i<10;palabras.length(),i++){
                lblResultado.setText(res[i]);
            }
            break;
            //nocomprendidodeltodo:(

        }
        case 9:{
            boolean res=texto.startsWith("Hola",0);
            lblResultado.setText(res+"");
            break;
            //:=)
        }
        case 10:{
            String res=texto.substring(2,8);
            lblResultado.setText(res+"");
            break;
            //:)
        }



    }

    }
}
