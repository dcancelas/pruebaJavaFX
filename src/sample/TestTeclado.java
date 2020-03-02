package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TestTeclado {
    
    public static Stage start(Stage primaryStage) {
        primaryStage.setTitle("Prueba JavaFX");

        Group root = new Group();
        Scene escena = new Scene(root);
        primaryStage.setScene(escena);

        Canvas canvas = new Canvas(512 - 64, 256);
        root.getChildren().add(canvas);

        ArrayList<String> input = new ArrayList<>();

        escena.setOnKeyPressed(
                event -> {
                    String code = event.getCode().toString();
                    if (!input.contains(code))
                        input.add(code);
                });

        escena.setOnKeyReleased(
                event -> {
                    String code = event.getCode().toString();
                    input.remove(code);
                });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image left = new Image("file:images/teclado/left.png");
        Image leftG = new Image("file:images/teclado/leftG.png");
        Image right = new Image("file:images/teclado/right.png");
        Image rightG = new Image("file:images/teclado/rightG.png");


        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, 512, 512);

                if (input.contains("LEFT"))
                    gc.drawImage(leftG, 64, 64);
                else
                    gc.drawImage(left, 64, 64);
                if (input.contains("RIGHT"))
                    gc.drawImage(rightG, 256, 64);
                else
                    gc.drawImage(right, 256, 64);
            }
        }.start();
        
        return primaryStage;
    }
}
