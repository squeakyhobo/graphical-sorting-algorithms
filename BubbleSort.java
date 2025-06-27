public class BubbleSort extends Sort{
    public boolean swapped;

    public BubbleSort(Graph panel){
        super(panel);
    }

    @Override
    public void sort(int[] nums){
        for(int i=0;i<nums.length -1;i++){
            swapped = false;
            for(int j = 0;j<nums.length-i-1;j++){

                panel.currentIndex = j;
                panel.comparedIndex = j+1;
                panel.repaint();
                sleep(10);
                



                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                    panel.repaint();
                    sleep(10);
                }
            }
            panel.minimumSorted = nums.length -i-1;
            panel.repaint();

            soundEffects.playSound("beep3.wav");
            if(!swapped){
                break;

            }
        }
        

    }
}