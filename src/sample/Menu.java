package sample;

import javafx.stage.Stage;

public class Menu {

    static Stage stageSolTierra = new Stage();
    static Stage stageTestTeclado = new Stage();

    public void boton1() {
        SolTierra.start(stageSolTierra).show();
    }
    public void boton2() {
        TestTeclado.start(stageTestTeclado).show();
    }
}
