package sample.Configs;

import java.util.regex.Pattern;

public class Configs {
    public static final String[] KEYWORDS = new String[] {
            "Cuadrado" ,"Rectángulo" ,"Circulo" ,"Triangulo", "Romboide",
            "Trapecio", "Trapezoide", "Pentágono", "Hexágono", "Heptágono",
            "Octágono", "Eneágono", "Decágono", "Rojo", "Naranja", "Amarillo",
            "Azul", "Morado", "Rosa", "Blanco", "Negro", "Verde", "0", "1", "2",
            "3", "4", "5", "6", "7", "8", "9", "10", "Crear","Cuadrados" ,"Rectángulos" ,"Circulos" ,"Triangulos", "Romboides",
            "Trapecios", "Trapezoides", "Pentágonos", "Hexágonos", "Heptágonos",
            "Octágonos", "Eneágonos", "Decágonos", "Rojos", "Naranjas", "Amarillos",
            "Azules", "Morados", "Rosas", "Blancos", "Negros", "Verdes"
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
            "Crear un Cuadrado Rojo de 4 lados",
            "Crear Triangulo Rojo de 3 lados",
            "Crear un Pentágono Rojo",
            "Crear Circulo Rojo de 0 lados",
            "Crear 8 Octágonos Rojos",
            "Crear un Trapezoide"

    });
    public static String [] expresiones={
            "Crear un (Cuadrado|Rectangulo|Circulo|Triangulo|Romboide|Trapecio|Trapezoide|Pentágono|Hexágono|Heptágono|Octágono|Eneágono|Decágono){1} (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){1}",
            "Crear (Cuadrado|Rectangulo|Circulo|Triangulo|Romboide|Trapecio|Trapezoide|Pentágono|Hexágono|Heptágono|Octágono|Eneágono|Decágono){1} (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){1}",
            "Crear un Cuadrado (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear un Rectangulo (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear un Circulo (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 0 lados",
            "Crear un Triangulo (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 3 lados",
            "Crear un Romboide (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear un Trapecio (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear un Trapezoide (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear un Pentágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 5 lados",
            "Crear un Hexágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 6 lados",
            "Crear un Heptágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 7 lados",
            "Crear un Octágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 8 lados",
            "Crear un Eneágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 9 lados",
            "Crear un Decágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 10 lados",
            "Crear Cuadrado (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear Rectangulo (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear Circulo (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 0 lados",
            "Crear Triangulo (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 3 lados",
            "Crear Romboide (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear Trapecio (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear Trapezoide (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 4 lados",
            "Crear Pentágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 5 lados",
            "Crear Hexágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 6 lados",
            "Crear Heptágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 7 lados",
            "Crear Octágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 8 lados",
            "Crear Eneágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 9 lados",
            "Crear Decágono (Rojo|Naranja|Amarillo|Azul|Morado|Rosa|Blanco|Negro|Verde){0,1} de 10 lados",
            "Crear un Cuadrado de 4 lados",
            "Crear un Rectangulo de 4 lados",
            "Crear un Circulo de 0 lados",
            "Crear un Triangulo de 3 lados",
            "Crear un Romboide de 4 lados",
            "Crear un Trapecio de 4 lados",
            "Crear un Trapezoide de 4 lados",
            "Crear un Pentágono de 5 lados",
            "Crear un Hexágono de 6 lados",
            "Crear un Heptágono de 7 lados",
            "Crear un Octágono de 8 lados",
            "Crear un Eneágono de 9 lados",
            "Crear un Decágono de 10 lados",
            "Crear Cuadrado de 4 lados",
            "Crear Rectangulo de 4 lados",
            "Crear Circulo de 0 lados",
            "Crear Triangulo de 3 lados",
            "Crear Romboide de 4 lados",
            "Crear Trapecio de 4 lados",
            "Crear Trapezoide de 4 lados",
            "Crear Pentágono de 5 lados",
            "Crear Hexágono de 6 lados",
            "Crear Heptágono de 7 lados",
            "Crear Octágono de 8 lados",
            "Crear Eneágono de 9 lados",
            "Crear Decágono de 10 lados",
            "Crear [2-9]{1} (Cuadrados|Rectangulos|Circulos|Triangulos|Romboides|Trapecios|Trapezoides|Pentágonos|Hexágonos|Heptágonos|Octágonos|Eneágonos|Decágonos){1}",
            "Crear [2-9]{1} (Cuadrados|Rectangulos|Circulos|Triangulos|Romboides|Trapecios|Trapezoides|Pentágonos|Hexágonos|Heptágonos|Octágonos|Eneágonos|Decágonos){1} (Rojos|Naranjas|Amarillos|Azules|Morados|Rosas|Blancos|Negros|Verdes){0,1}",
            "Crear (Cuadrado|Rectangulo|Circulo|Triangulo|Romboide|Trapecio|Trapezoide|Pentágono|Hexágono|Heptágono|Octágono|Eneágono|Decágono){1}",
            "Crear un (Cuadrado|Rectangulo|Circulo|Triangulo|Romboide|Trapecio|Trapezoide|Pentágono|Hexágono|Heptágono|Octágono|Eneágono|Decágono){1}"
    };
}
