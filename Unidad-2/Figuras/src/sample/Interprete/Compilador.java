package sample.Interprete;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import static sample.Interprete.TiposToken.*;

public class Compilador {
    //String texto="";
    private TextArea consola;
    private VBox pane;
    public Compilador(TextArea tx,VBox pane){
        this.consola=tx;
        this.pane=pane;
    }
    public boolean compilar(String renglon){
        boolean errores=false;
        if (renglon.contains("Escribir")){
            int i1=renglon.indexOf("de")+2;
            int i2=renglon.length();
            String texto=renglon.substring(i1,i2);
            this.consola.appendText("\n "+"Se a escrito: "+texto);
        }else if (renglon.contains("Borrar nombre")){
            this.consola.appendText("\n "+"Se a borrado la palabra");
        }
        if (renglon.contains("Crear un Cuadrado")){
            this.consola.appendText("Se a creado un Cuadrado");
            Image cuadrado= new Image("sample/Imagenes/Cuadrado.png");
            Label label=new Label("Hola");
            label.setGraphic(new ImageView(cuadrado));
            ImageView imagen1=new ImageView(cuadrado);
            imagen1.setFitHeight(100);
            imagen1.setFitWidth(100);
            pane.getChildren().add(imagen1);
        }
        if (renglon.contains("Crear un Triangulo")){
            Image triangulo= new Image("sample/Imagenes/Triangulo.png");
            Label label=new Label("Hola");
            label.setGraphic(new ImageView(triangulo));
            ImageView imagen2=new ImageView(triangulo);
            imagen2.setFitHeight(100);
            imagen2.setFitWidth(100);
            pane.getChildren().add(imagen2);
        }
        if (renglon.contains("Crear un Circulo")){
            Image circulo= new Image("sample/Imagenes/Circulo.png");
            Label label=new Label("Hola");
            label.setGraphic(new ImageView(circulo));
            ImageView imagen3=new ImageView(circulo);
            imagen3.setFitHeight(100);
            imagen3.setFitWidth(100);
            pane.getChildren().add(imagen3);
        }
        if (renglon.contains("Crear un Rectangulo")){
            Image rectangulo= new Image("sample/Imagenes/Rectangulo.png");
            Label label=new Label("Hola");
            label.setGraphic(new ImageView(rectangulo));
            ImageView imagen4=new ImageView(rectangulo);
            imagen4.setFitHeight(100);
            imagen4.setFitWidth(100);
            pane.getChildren().add(imagen4);
        }
        if (renglon.contains("Borrar Figuras")){
            pane.getChildren().clear();
        }


        return errores;
    }
    public boolean validar(String nombre){
        boolean existe=false;
        for(int x=0; x<arrayToken.size();x++){
            if (arrayToken.get(x).getNombre().equals(nombre)){
                existe=true;

            }
        }
        return existe;
    }
}
