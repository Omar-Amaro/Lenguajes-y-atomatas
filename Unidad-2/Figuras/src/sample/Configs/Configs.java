package sample.Configs;

import java.util.regex.Pattern;

public class Configs {
    public static final String[] KEYWORDS = new String[] {
            "Cuadrado" ,"Rectangulo" ,"Circulo" ,"Triangulo","Rojo", "Amarillo",
            "Azul", "Verde","Crear","Colorear","Escribir","Borrar","Figuras","Figura"
    };

    public static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    public static final String PAREN_PATTERN = "\\(|\\)";
    public static final String BRACE_PATTERN = "\\{|\\}";
    public static final String BRACKET_PATTERN = "\\[|\\]";
    public static final String SEMICOLON_PATTERN = "\\;";
    public static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    public static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    public static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    public static final String sampleCode = String.join("\n", new String[] {
            "Crear un Cuadrado",
            "Crear un Triangulo",
            "Crear un Circulo",
            "Crear un Rectangulo",
            "Borrar Imagenes",
            "Escribir nombre de Rectangulo",
            "Borrar nombre de Figura"

    });
    public static String [] expresiones={
            "Crear un Cuadrado",
            "Crear un Rectangulo",
            "Crear un Circulo",
            "Crear un Triangulo",
            "Crear un (Cuadrado|Rectangulo|Circulo|Triangulo){1}",
            "Borrar Figuras",
            "Escribir nombre de (Cuadrado|Rectangulo|Circulo|Triangulo){1}",
            "Borrar nombre de (Cuadrado|Rectangulo|Circulo|Triangulo){1}",
            "Borrar Imagenes"

    };
}
