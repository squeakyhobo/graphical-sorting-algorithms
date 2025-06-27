import java.util.Arrays;

public class QuickSort extends Sort{
    public static int[] nums;
    AudioGen audioGen;
    

    public QuickSort(Graph panel){
        super(panel);
        
        
        
    }

    @Override
    public void sort(int[] nums){
        audioGen= new AudioGen(nums,30);
        pivot(nums.length-1, 0, nums);
    }

    public  static void main(String[] args){
        
        //int[] nums = {3,4,1,6,5,2,2};
        //System.out.println(Arrays.toString(nums));
        //pivot(6,0,nums);
        //shift(5, 0, nums);

        //System.out.println(Arrays.toString(nums));

    }

    public  void pivot(int upperBound,int lowerBound,int[]nums){
        
    
        panel.lowBound = lowerBound;
        panel.upBound = upperBound;
        //System.out.println(upperBound);
        panel.repaint();

        if(lowerBound>=upperBound){
            return;
        }


            int j =lowerBound;
            for(int i = lowerBound;i<upperBound;i++){

                panel.comparedIndex=i;
                //audioGen.enqueuePreloadedTone(nums[i]);
                audioGen.playTone(nums[i]);
                
                // wait till this is played to do anything
                panel.repaint();
                //sleep(40);


                if(nums[i]<nums[upperBound]){
                    //audioGen.playTone(nums[j]);
                    swap(nums,j,i);
                    j++;

                    panel.repaint();

                   
                    //audioGen.enqueuePreloadedTone(j);
                    
                    
                }
               
            }
            swap(nums, upperBound, j);
            //System.out.println("pivot done");
          
            panel.repaint();

            
            pivot(j-1,lowerBound,nums);

            pivot(upperBound,j+1,nums);
            
            

        

        

    }

   

    public void swap(int[] nums,int i,int j){
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }





}