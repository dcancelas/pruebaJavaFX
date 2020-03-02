package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Prueba JavaFX");

        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image tierra = new Image("file:images/earth.png");
        Image espacio = new Image("file:images/space.png");
        Image sol = new Image("file:images/sun.png");

        AnimatedImage ovni = new AnimatedImage();
        Image[] imageArray = new Image[6];
        for (int i = 0; i < imageArray.length; i++)
            imageArray[i] = new Image("file:images/ufo/ufo_"+i+".png");
        ovni.frames = imageArray;
        ovni.duration = 0.1;

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 180 * Math.cos(t);
                double y = 232 + 180 * Math.sin(t);
                double xOvni = x + 50 * Math.sin(t);
                double yOvni = y + 50 * Math.cos(t);

                gc.drawImage(espacio, 0 , 0);
                gc.drawImage(sol, 196, 196);
                gc.drawImage(tierra, x, y);
                gc.drawImage(ovni.getFrame(t), xOvni, yOvni);
            }
        }.start();

        primaryStage.show();
    }
}
