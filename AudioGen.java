import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;





public class AudioGen{
    int sampleRate =48000;
     
    int durationMS;
    // speed it up after sorted sounds bette
    int sampleCount;
    int totalSamples;
    int fadeSamples;

    public HashMap<Integer,byte[]> map;
    public BlockingQueue<byte[]> audioQueue ;
    //Thread audioThread;
    //AudioThread obj;
    
    


    //int bits =8; // puts a cap on ampltiude? or volumne
    //int volume = Byte.MAX_VALUE;

    int bits =16;
    int volume = (int)(Short.MAX_VALUE);
     

    double max_freq = 1500;
    double min_freq = 200;


    double freqMultiplier;
    // y =mx+c
    double freqShift;
     

    AudioFormat format;
    SourceDataLine line;


    float filterPreviousInput =0f;

    float filterPreviousOutput =0f;
    

    

    AudioGen(int[] nums,int duration){
      durationMS = duration;
      sampleCount =(sampleRate*durationMS)/1000;
      totalSamples = sampleCount*2;
      fadeSamples = (int)(0.25*sampleCount);
        freqMultiplier =(max_freq-min_freq)/(nums.length - 1);
        freqShift = min_freq-freqMultiplier ;
        //System.out.println("frequency multpiler:" + freqMultiplier+"freq shift:" + freqShift);
      try{

      
        setUp();
        generateSamples(nums.length);
        //audioQueue =new LinkedBlockingQueue<>();
        //obj = new AudioThread(map, audioQueue, line);
        //audioThread = new Thread(obj);
        //audioThread.start();
        
        

        
      }
      catch(Exception e){}
    }

    private void generateSamples(int maxNUm){
      map = new HashMap<>();

      for(int i = 1;i<=maxNUm;i++){
        double freq = frequencyConverter(i);
        
      
        byte[] sample = gernerateWaveform(freq);
        map.put(i,sample);

      }
      
      
    }


    

    public  void setUp()throws Exception {
        

          format = new AudioFormat(sampleRate, bits, 1, true, false);
          DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
          line = (SourceDataLine)(AudioSystem.getLine(info));
          line.open(format);
          line.start();
          


          
    
        }
        
          
     

    public  byte[] gernerateWaveform(double freq){
      
      filterPreviousInput =0f;

      filterPreviousOutput =0f;

      byte[] samples = new byte[totalSamples];


      for(int i = 0;i<sampleCount;i++){

        double angle = (2*Math.PI*(i)*freq)/(sampleRate);
        
        double ampltiude =Math.sin(angle);
        ampltiude =fadeSample(ampltiude, i);

        
       
        short sample = (short)(ampltiude * volume);

        //sample = highPassFilter(sample);
        byte low = (byte)(sample & 0xFF);
        byte high = (byte)((sample >> 8)& 0xFF);
        
        samples[i*2] = low;
        samples[(i*2)+1] = high;

        //samples[i] = (byte)(ampltiude *volume);

        //System.out.println("angle: "+angle+" amp:"+ampltiude+" sample:" +samples[i]);
        
        
      }

      return(samples);
      //System.err.println("waveCycles: " +waveCycles);
      //System.out.println(samples[samples.length-1]);
      
      
      //sleep(10);
      //line.flush();
      
      

      //System.err.println("total samples: "+totalSamples);
    }

   
    

    public void enqueuePreloadedTone(int i){
      byte[] tone = map.get(i);
      audioQueue.add(tone);
    }

    public void playTone(int i){
      //System.out.println(i);
      byte[] tone = map.get(i);
      line.write(tone, 0, tone.length);
      line.drain();
    }

    public void PrintTone(byte[] tone){
      Short[] arr = new Short[tone.length/2];
      for(int i = 0;i<tone.length/2;i++){
        byte low = tone[i*2];
        byte high = tone[i*2+1];
        
        arr[i] = (short)(((high & 0xFF)<<8)|(low&0xFF));
      
      }
      System.out.println(Arrays.toString(arr));
      
    }



   

    private void sleep(int millis){
      try{
        Thread.sleep(millis);
      }
      catch(Exception e){}
    }


    private double fadeSample(double ampltiude,int i){
      double cosineFade;
      if(i<fadeSamples){
            
            //ampltiude *= i/(double)fadeSamples;
            cosineFade = 0.5*(1-Math.cos((Math.PI*i)/fadeSamples));
            ampltiude *= cosineFade;
           
        }

        else if (i>= sampleCount-fadeSamples){
            //ampltiude*=((sampleCount-i-1)/(double)fadeSamples);
            int fadeOutIndex = i-(sampleCount -fadeSamples);

            cosineFade = 0.5*(1+Math.cos((Math.PI*(fadeOutIndex))/fadeSamples));
            ampltiude*= cosineFade;
            
            
            
        //System.out.println(sampleCount-i-1);
            
        }

        return ampltiude;
    }

    private double frequencyConverter(int arrNum){
      double freq = ((double)arrNum *freqMultiplier) +freqShift;
      // need to check if this frequency makes full wave cycles

      double waveCycles = freq*((double)durationMS/1000);
      double newfreq = ((waveCycles -waveCycles%1)/((double)durationMS/1000));
        
      //System.out.println("freq: "+ freq +"waveCycles: "+ waveCycles + " modulo wavecyles:"+ (waveCycles -waveCycles%1));
      System.out.println("old freq: "+freq+" new freq: "+newfreq);


      //return newfreq;
      return freq;
    }

   private short highPassFilter(short sample){
      float currentInput = sample;

      float filterOutput = currentInput - filterPreviousInput +0.995f*filterPreviousOutput;

      filterPreviousInput = currentInput;
      filterPreviousOutput = filterOutput;

      return (short)filterOutput;
    
    
    }

    
}