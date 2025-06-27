import java.io.File;
import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioPlayer;
import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.PitchShifter;
import be.tarsos.dsp.GainProcessor;


 
import javax.sound.sampled.*;

public class Sound {
    public static void main(String[] args){

    }
    public void playSound(String file){
        try{
            AudioInputStream aduio = AudioSystem.getAudioInputStream(new File(file));
            Clip clip = AudioSystem.getClip();
            clip.open(aduio);
            clip.start();
        }
        catch(Exception e){}
    }


    

    
}
