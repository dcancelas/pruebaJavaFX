package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        primaryStage.setTitle("Prueba JavaFX");
        Scene escena = new Scene(root, 250, 200);
        primaryStage.setScene(escena);
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            Menu.stageSolTierra.close();
            Menu.stageTestTeclado.close();
        });
    }
}
