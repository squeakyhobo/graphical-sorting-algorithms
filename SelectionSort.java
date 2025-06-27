
import java.util.Arrays;



public class SelectionSort extends Sort {

    

    
    
    public SelectionSort(Graph panel){
        super(panel);
    }

    @Override
    public void sort(int[] nums){
        System.out.println(Arrays.toString(nums));
        for(int i = 0;i <nums.length;i++){
            panel.currentIndex = i;
            
            
            int smallestIndex =i;
            for(int j =i+1;j<nums.length;j++){
                panel.comparedIndex = j;
                if(nums[j]<nums[smallestIndex]){
                    
                    smallestIndex =j;
                }
                panel .repaint();
                sleep(10);
                
            
            
               

            }
            int placement = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = placement;
            panel.repaint();
            soundEffects.playSound("beep3.wav");

            sleep(10);
                
                

        }
        
        

    }

   
}
