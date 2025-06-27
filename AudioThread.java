import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import javax.sound.sampled.SourceDataLine;

public class AudioThread  implements Runnable{

    HashMap<Integer,byte[]> map;
    BlockingQueue<byte[]> audioQueue;
    SourceDataLine line;
    

    public AudioThread(HashMap<Integer,byte[]> map,BlockingQueue<byte[]> audioQueue, SourceDataLine line){
        this.map=map;
        this.audioQueue = audioQueue;
        this.line =line;
        
    }
    @Override
    public void run() {
        try{

            while (true) {
                byte[] tone = audioQueue.take();
                line.write(tone, 0, tone.length);
                line.drain();
                
            }
        }
        catch(Exception e){}
    }


}


