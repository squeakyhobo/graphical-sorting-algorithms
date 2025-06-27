import java.util.Arrays;

public class HeapSort extends Sort {
    AudioGen audioGen;
    public HeapSort(Graph panel,int[] nums){
        super(panel);
        audioGen = new AudioGen(nums, 30);
    }


    @Override
    public void sort(int[] nums) {
       
       isMaxHeap(nums, nums.length);
       for(int boundray= nums.length-1;boundray>0;boundray--){
        panel.upBound = boundray-1;
        
        panel.repaint();
        
        
        checkParent(nums, 0, boundray);
        audioGen.playTone(nums[0]);
        //panel.cap = boundray-1;
        swap(0, boundray-1, nums);
        panel.cap = boundray-1;
       }
    }

    public void isMaxHeap(int[] nums,int boundray){
        panel.upBound = boundray -1;
        panel.repaint();


        int lastPartentIndex;
        int leftChildIndex;
        
        int rightChildIndex;
        
        lastPartentIndex = (boundray/2) -1;
       //System.out.println(lastPartentIndex);
       
        for(int i=lastPartentIndex;i>=0;i--){
            panel.buildingHeapIndex = i;
            panel.repaint();
            checkParent(nums, i,boundray);
            //sleep(100);
            
            



        }
      
        swap(0, boundray-1, nums);
    }

    private void checkParent(int[] nums ,int i,int boundray){
        int largest = i;
        int leftChildIndex;
        int rightChildIndex;

        audioGen.playTone(nums[i]);

        if(i*2 +1<boundray){
                 leftChildIndex = (i*2)+ 1;
                if(nums[leftChildIndex]>nums[largest]){
                    largest = leftChildIndex;
                    
                }
        }
        if (i*2 +2 <boundray){
                rightChildIndex = (i*2)+2;  
                if(nums[rightChildIndex]>nums[largest]){
                    largest = rightChildIndex;
                }
        }
        if (largest!=i){
            swap(largest, i, nums);
            
            
            checkParent(nums, largest,boundray);
        }

    }

    private void swap(int i, int j,int[] nums){
        panel.currentIndex =i;
        panel.comparedIndex =j;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        panel.repaint();
        //sleep(50);
        //System.out.println("swapped");

    }


    


    


    
}
