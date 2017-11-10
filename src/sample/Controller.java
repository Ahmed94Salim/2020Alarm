package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable{

    @FXML
    Button startAlarm, pauseAlarm, exitAlarm;

    private File soundFile;
    private AudioInputStream stream = null;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip soundClip = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        soundFile = new File("123.wav");

        startAlarm.setOnAction(e->{
            //start the alarm

            try {
                stream = AudioSystem.getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException | IOException e1) {
                e1.printStackTrace();
            }
            assert stream != null;
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            try {
                soundClip = (Clip) AudioSystem.getLine(info);
                soundClip.open(stream);
            } catch (LineUnavailableException e1) {
                e1.printStackTrace();
            }catch (IOException ignored){

            }
            assert soundClip != null;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //soundClip.stop();
                    System.out.println("Hi!");
                    Toolkit.getDefaultToolkit().beep();
                    soundClip.start();
                }

            },23000,60000); // 20 minutes = 1200000 ms


        });

        pauseAlarm.setOnAction(e->{
            //pause the alarm
        });

        exitAlarm.setOnAction(e->{
            //exit the alarm
        });

    }
}
