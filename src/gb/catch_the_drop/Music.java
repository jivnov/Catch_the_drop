package gb.catch_the_drop;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Music {
    public static void PlaySound () {
try {
    File Sound = new File(StartGame.currentDir +"/src/gb/catch_the_drop/Water_Drop_Sound.wav");

    Clip sound = AudioSystem.getClip();
    sound.open(AudioSystem.getAudioInputStream(Sound));
    sound.start();

}catch (Exception ignored) {

        }
    }

    public static void PlayClickSound () {
        try {
            File Click = new File(StartGame.currentDir+"/src/gb/catch_the_drop/Mouse_Click_Fast.wav");

            Clip click = AudioSystem.getClip();
            click.open(AudioSystem.getAudioInputStream(Click));
            click.start();

        }catch (Exception ignored) {

        }
    }

    public static void PlayEndSound () {
        try {
            File End = new File(StartGame.currentDir+"/src/gb/catch_the_drop/Sad_Trombone.wav");
            Clip end = AudioSystem.getClip();
            end.open(AudioSystem.getAudioInputStream(End));
            end.start();

        }catch (Exception ignored) {

        }
    }

}