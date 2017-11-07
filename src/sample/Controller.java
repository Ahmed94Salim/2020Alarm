package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Button startAlarm, pauseAlarm, exitAlarm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        startAlarm.setOnAction(e->{
            //start the alarm
        });

        pauseAlarm.setOnAction(e->{
            //pause the alarm
        });

        exitAlarm.setOnAction(e->{
            //exit the alarm
        });

    }
}
