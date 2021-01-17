package sample.Interprete;

import javafx.scene.control.TextArea;

import static sample.Interprete.TiposToken.*;

public class Compilador {
    //String texto="";
    private TextArea consola;
    public Compilador(TextArea tx){
        this.consola=tx;
    }
    public boolean compilar(String renglon){
        boolean errores=false;
        if (renglon.contains("Escribir")){
            int i1=renglon.indexOf("de")+2;
            int i2=renglon.length();
            String texto=renglon.substring(i1,i2);
            this.consola.appendText("\n "+"Se a escrito: "+texto);
        }else if (renglon.contains("Colorear")){
            String[] arreglo=renglon.split(" ");
            if (!validar(arreglo[1].trim())){
                String tipoToken="";
                if (arreglo[3].equals("Azul")){
                    tipoToken=AZUL;
                }else {
                    tipoToken=ROJO;
                }
                if (arreglo[3].equals("Amarillo")){
                    tipoToken=AMARILLO;
                }else {
                    tipoToken=VERDE;
                }
                Token token=new Token(tipoToken,arreglo[1].trim());
                arrayToken.add(token);
                System.out.println(arreglo[1]);
                System.out.println(arreglo[3]);
            }else {
                this.consola.appendText("\n "+"El "+arreglo[1]+" ya esta coloreado");
            }

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
