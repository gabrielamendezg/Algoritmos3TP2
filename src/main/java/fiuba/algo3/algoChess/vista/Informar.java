package fiuba.algo3.algoChess.vista;

import javafx.scene.control.Alert;

public class Informar {
    public Informar(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}
