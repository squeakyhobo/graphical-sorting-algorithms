import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AudioPlayer {
    

    public static void main(String[] args){
        //AudioGen audioGen = new AudioGen(numGenerator(85));
        //System.out.println(audioGen.line.getBufferSize());
        for(int i=1;i<=100;i++){
            //audioGen.enqueuePreloadedTone(40);
        //System.out.println(Arrays.toString(Arrays.copyOfRange(audioGen.samples, audioGen.samples.length-100, audioGen.samples.length)));
        //System.out.println(Arrays.toString(Arrays.copyOfRange(audioGen.samples, 0, 100)));
        
        }
        //audioGen.PrintTone(audioGen.map.get(40));
       
        


        
    }

    static public int[] numGenerator(int arrSize){
        int[] arr = new int[arrSize];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arrSize;i++){
            //arr[i] = (int)(Math.random()*1440);
            list.add(i+1);
        }
        Collections.shuffle(list);
        for(int i=0;i<arrSize;i++){
            arr[i]=(int)(list.get(i));
        }
        //System.out.println(Arrays.toString(arr));
        return arr;
        
    }
}
