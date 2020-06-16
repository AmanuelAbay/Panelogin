package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    @FXML

    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pane1.setStyle("-fx-background-image: url(\"/sample/1.jpeg\")");
        pane2.setStyle("-fx-background-image: url(\"/sample/2.jpeg\")");
        pane3.setStyle("-fx-background-image: url(\"/sample/3.jpeg\")");
        pane4.setStyle("-fx-background-image: url(\"/sample/4.jpeg\")");
        backgroundAnimation();
    }
    private void backgroundAnimation(){
        FadeTransition fadetransition=new FadeTransition(Duration.seconds(3),pane4);
        fadetransition.setFromValue(1);
        fadetransition.setToValue(0);
        fadetransition.play();
        fadetransition.setOnFinished(event -> {
            FadeTransition fadetransition1=new FadeTransition(Duration.seconds(3),pane3);
            fadetransition1.setFromValue(1);
            fadetransition1.setToValue(0);
            fadetransition1.play();
            fadetransition1.setOnFinished(event1 ->{
                FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.play();
                fadeTransition.setOnFinished(event2 ->{
                    FadeTransition Fadetransition=new FadeTransition(Duration.seconds(3),pane1);
                    Fadetransition.setFromValue(1);
                    Fadetransition.setFromValue(0);
                    Fadetransition.play();
                    backgroundAnimation();
                });
            });
        });
    }
}
