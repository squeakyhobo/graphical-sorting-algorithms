import java.util.Arrays;

public class Merge extends Sort{
    int[] mainArr;
     public Merge(Graph panel,int[] nums){
        super(panel);
        this.mainArr =nums;
    }
    @Override
    public void sort(int[] nums){
        int[] arr = divide(nums);
        for(int i=0;i<arr.length;i++){
            nums[i] = arr[i];
        }
        
        panel.repaint();
    }

   // public static void main(String[] args){
        //int[] arr={3,1,2,4,2};

        //System.err.println(Arrays.toString(divide(arr)));
        
        
    //}

   public  int[] divide(int[] nums){
        if(nums.length>1){
            
            int[][] arrs = splitArr(nums, nums.length/2);
            int[] arr1 = divide(arrs[0]);
            int[] arr2 = divide(arrs[1]);
            
            int[] arr = (merge(arr1,arr2));

            int num = arr1[0];
            int index = getIndex(num);
            for(int i =0;i<arr.length;i++){
                mainArr[index+i] = arr[i];
                panel.currentIndex =index +i;
                panel.comparedIndex =index+ i;
                panel.middle = index+i;
                panel.lowBound = index+i;
                panel.upBound = index +i;


                panel.repaint();
                sleep(10);
                
            }
            soundEffects.playSound("beep3.wav");
            
            panel.repaint();
            sleep(100);
            return arr;

        }
        else{
            return nums;
        }
       

        
    }

    public   int[] merge(int[] arr1,int[] arr2){
        int arr1Index =0;
        int arr2Index =0;
        int arrIndex =0;
        
        int[] arr =new int[arr1.length + arr2.length];
        int num = arr1[0];
        int index = getIndex(num);

        panel.lowBound = index;
        panel.upBound = index+arr.length -1;
        panel.middle = index +arr1.length;

        while(arrIndex<arr.length){
            
            if(arr1Index<arr1.length &&!(arr2Index<arr2.length)){
                while (arrIndex<arr.length) {
                    arr[arrIndex] = arr1[arr1Index];
                    arr1Index++;
                    arrIndex++;
                }
            }
            else if(!(arr1Index<arr1.length) &&(arr2Index<arr2.length)){
                while (arrIndex<arr.length) {
                    arr[arrIndex] = arr2[arr2Index];
                    arr2Index++;
                    arrIndex++;
                }
            }
            else{
                if(arr1[arr1Index]<arr2[arr2Index]){
                    arr[arrIndex] = arr1[arr1Index];
                    arr1Index++;
                }
                else{
                    arr[arrIndex] = arr2[arr2Index];
                    arr2Index++;
                }
                arrIndex ++;
            }
            panel.currentIndex = index+arr1Index;
            panel.comparedIndex = index + arr1.length-1+arr2Index;
            
            
            //panel.middle = arr1.length;
            panel.repaint();
            sleep(10);
        }
        
        return(arr);
        

    }

    private  int[][] splitArr(int[] arr,int i){
        int[] arr1 =new int[i];
        int[] arr2 = new int[arr.length-i];
        for(int j =0; j<arr1.length;j++){
            arr1[j] = arr[j];

        }
        for(int j =0; j<arr2.length;j++){
            arr2[j] = arr[i+j];
            
        }

        int[][] newArr = {arr1,arr2};
        
        return(newArr);
    }
    

    public void swap(int num1,int num2){
        

    }
    public int getIndex(int num){
        for(int i=0; i<mainArr.length;i++){
            if(mainArr[i]==num)
             return i;

            
        }
        return -1;
    }
}