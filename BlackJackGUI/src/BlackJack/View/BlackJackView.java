package BlackJack.View;

import BlackJack.Model.BlackJackModel;
import BlackJack.controller.BJController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BlackJackView {

    public void start (BlackJackModel Model) throws Exception {
        //Stage aus Modell auslesen
        Stage stage = Model.getStage();
        //Oberflächeninhalte in den FXML Loader laden
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BlackJack/View/BlackJack.fxml"));
        //Oberflächeninhalte in einem Pane platzieren
        Pane root = loader.load();
        //Der TTT Controller ist in TicTacToe.fxml definiert, hier wird er abgefragt
        BJController Controller = loader.getController();
        //Dem Controller wird das TTT Model zugewiesen. Auf diesem Weg sind dem Controller und der View das Modell bekannt
        Controller.setModel(Model);
        Controller.GameStateHandler();
        Scene scene = new Scene(root);
        stage.setTitle("BlackJack");
        stage.setScene(scene);
        stage.setResizable(false);
        //Aufruf Gamestatehandler um das Soiel zu initialisieren
        stage.show();
    }
}