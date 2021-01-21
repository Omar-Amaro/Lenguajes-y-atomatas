package sample;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.Subscription;
import sample.Interprete.Compilador;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sample.Configs.Configs.*;
import static sample.Interprete.TiposToken.arrayToken;

public class Controller {
    @FXML VBox centro;
    @FXML TextArea consola;
    @FXML VBox paneresultado;


    private CodeArea codeArea;
    private ExecutorService executor;
    @FXML protected void initialize(){
        executor = Executors.newSingleThreadExecutor();
        codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        Subscription cleanupWhenDone = codeArea.multiPlainChanges()
                .successionEnds(Duration.ofMillis(500))
                .supplyTask(this::computeHighlightingAsync)
                .awaitLatest(codeArea.multiPlainChanges())
                .filterMap(t -> {
                    if(t.isSuccess()) {
                        return Optional.of(t.get());
                    } else {
                        t.getFailure().printStackTrace();
                        return Optional.empty();
                    }
                })
                .subscribe(this::applyHighlighting);

        // call when no longer need it: `cleanupWhenFinished.unsubscribe();`

        codeArea.replaceText(0, 0, sampleCode);
        StackPane pane=new StackPane(new VirtualizedScrollPane<>(codeArea));
        centro.getChildren().add(pane);
        pane.setPrefSize(600,600);
       //Scene scene = new Scene(new StackPane(new VirtualizedScrollPane<>(codeArea)), 600, 400);
    }
    public void compilar(ActionEvent event){
        String error="";
        long t1=System.currentTimeMillis();
        consola.setText("");
        arrayToken.clear();
        String[] renglones=codeArea.getText().split("\\n");
        for (int x=0;x<renglones.length;x++){
            boolean encontro=false;
            for (int y=0;y<expresiones.length;y++){
                Pattern p=Pattern.compile(expresiones[y]);
                Matcher matcher=p.matcher(renglones[x]);
                if (matcher.matches()){
                    encontro=true;
                    y=expresiones.length+1;
                }
            }
            if (!encontro){
                error+="Error de sintaxis en la linea "+(x+1)+" \n";
            }

        }
        consola.setText(error);
        ///comenzar a compilar
        if (error.equals("")){
            Compilador compilador= new Compilador(consola,paneresultado);
            for (int x=0;x<renglones.length;x++){
                boolean res=compilador.compilar(renglones[x]);
                if (res){
                    consola.appendText("\n Error de sintaxys en la linea"+(x+1));
                }
            }
        }//llave if
        long t2=System.currentTimeMillis();
        consola.appendText("\n Compilado en "+ (t2-t1) + "milisegundos");
    }

    private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
        String text = codeArea.getText();
        Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
            @Override
            protected StyleSpans<Collection<String>> call() throws Exception {
                return computeHighlighting(text);
            }
        };
        executor.execute(task);
        return task;
    }

    private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
        codeArea.setStyleSpans(0, highlighting);
    }

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                            matcher.group("PAREN") != null ? "paren" :
                                    matcher.group("BRACE") != null ? "brace" :
                                            matcher.group("BRACKET") != null ? "bracket" :
                                                    matcher.group("SEMICOLON") != null ? "semicolon" :
                                                            matcher.group("STRING") != null ? "string" :
                                                                    matcher.group("COMMENT") != null ? "comment" :
                                                                            null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }
}
