import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Collections.*;

public class GraphicalSorter{


    public static void main(String[] args){
        int barWidth = 10;
        JFrame frame = new JFrame("HEY");
        Sound sound = new Sound();
        Scanner scanner = new Scanner(System.in);
        

       
        //int[] nums = numGenerator(2560/barWidth);
        int[] nums = numGenerator(800/barWidth);
        AudioGen audioGen = new AudioGen(nums,30);
        AudioGen audioGen2 = new AudioGen(nums,15);
        


        Graph panel = new Graph(nums,"heap");
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        //SelectionSort sort = new SelectionSort(panel);
        //BubbleSort sort = new BubbleSort(panel);
        //Merge sort = new Merge(panel, nums);
        //QuickSort sort = new QuickSort(panel);
        HeapSort sort = new HeapSort(panel,nums);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
        scanner.next();

        
        //panel.paint();
        
        //try{
        //Thread.sleep(3000);
        sort.sort(nums);
        panel.sorted = true;
        System.out.println("sorted");
        sleep(500);
        //for(int i = 0;i<nums.length;i++){
        
            //panel.cap =i;
            
            panel.repaint();
            sound.playSound("beep2.wav");

            //audioGen.enqueuePreloadedTone(nums[i]);
            //audioGen2.playTone(nums[i]);
            
           
        //}
        //catch(Exception e){}
       // }
        sleep(100);

        //panel.afterSorted = true;
        panel.sorted= false;
        
        panel.repaint();
        


       
        

        

    
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

    public static void sleep(int millis){
        try{
            Thread.sleep(millis);
        }

        catch(Exception e){}
    }
}
