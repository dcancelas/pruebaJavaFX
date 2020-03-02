package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Prueba JavaFX");

        Group root = new Group();
        Scene escena = new Scene(root);
        primaryStage.setScene(escena);

        Canvas canvas = new Canvas(220, 200);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image boton1 = new Image("file:images/ui/blue_button00.png");

        Font fuente = Font.font( "Times New Roman", FontWeight.BOLD, 15 );
        gc.setFont(fuente);
        gc.fillText("Selecciona una opción", 15, 50 );

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gc.drawImage(boton1, 15, 75);
                gc.drawImage(boton1, 15, 135);
            }
        }.start();

        primaryStage.show();
        //Espacio.start(new Stage()).show();
        //TestTeclado.start(new Stage()).show();
    }
}
