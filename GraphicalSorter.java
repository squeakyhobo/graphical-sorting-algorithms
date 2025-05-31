import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GraphicalSorter{


    public static void main(String[] args){
        int barWidth = 10;
        JFrame frame = new JFrame("HEY");
        Sound sound = new Sound();
        Scanner scanner = new Scanner(System.in);

       
        //int[] nums = numGenerator(2560/barWidth);
        int[] nums = numGenerator(1000/barWidth);
        


        Graph panel = new Graph(nums);
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        SelectionSort sort = new SelectionSort(panel);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
        scanner.next();

        
        //panel.paint();
        
        //try{
        //Thread.sleep(3000);
        sort.sort(nums);
        panel.sorted = true;
        System.out.println("sorted");
        for(int i = 0;i<nums.length;i++){
        
            panel.cap =i;
            panel.repaint();
            sleep(20);
        //}
        //catch(Exception e){}
        }
        sleep(400);

        panel.afterSorted = true;
        panel.sorted= false;
        sound.playSound("beep2.wav");
        panel.repaint();


       
        

        

    
    }

    static public int[] numGenerator(int arrSize){
        int[] arr = new int[arrSize];
        for(int i=0;i<arrSize;i++){
            arr[i] = (int)(Math.random()*1440);
        }
        return arr;
    }

    public static void sleep(int millis){
        try{
            Thread.sleep(millis);
        }

        catch(Exception e){}
    }
}
