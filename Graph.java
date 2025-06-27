import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graph extends JPanel {
    final int MAX_HEIGHT = 1408;
    int[] nums;
    boolean sorted = false;
    boolean afterSorted = false;
    int currentIndex = 0;
    int comparedIndex =1;
    int cap;
    int minimumSorted;
    int lowBound = 0;
    int upBound;
    int middle;
    int buildingHeapIndex;
    //int pivot;
    
    Color green = new Color(57,255,20);
    Color white = Color.WHITE;
    Color red = Color.red;
    String sortType;

    Sound soundEffects = new Sound();


    double heightMultiplier =15;
    int heightShift=10;
    int width =10;
   
    Color depth0 =  new Color(204, 204, 255);
    Color depth1 =  new Color(190,229,211);
    Color depth2 =  new Color(176,224,230);
    Color depth3 =  new Color(230,230,250);
    Color depth4 =  new Color(253,253,150);
    Color depth5 =  new Color(164,216,216);
    Color depth6 =  new Color(255,218,185);


    Color[] depthColours = {depth0,depth1,depth2,depth3,depth4,depth5,depth6};
    

    public Graph(int[] nums,String sortType){
        super();
        this.nums =nums;
        this.sortType = sortType;
        minimumSorted = nums.length;
        upBound =nums.length-1;
        buildingHeapIndex = (nums.length/2) -1;
        cap = nums.length;
        
    }
    @Override
    protected void paintComponent(Graphics g){
        
        

            super.paintComponent(g);
            
        //g.translate(0,getHeight());
            if(afterSorted){
                
                g.setColor(white);

                for(int i =0;i<nums.length;i++){
                    
                    
                    makeRect(g, i);
                    g.setColor(white);
                    
                    
                }
            }
            else if (sorted){
                
                    for(int j =0; j<nums.length;j++){
                        
                            g.setColor(green);
                        
                    
                        
                        makeRect(g, j);
                    }
                    
                
            }
            else{
            for(int i =0; i<nums.length;i++){

                if(sortType.equals("selection")){
                
                    if(i==currentIndex||i==comparedIndex){
                        g.setColor(red);
                    }
                    else if(i<currentIndex){
                        g.setColor(green);
                    }
                    else{
                        g.setColor(white);
                    }
                }

                else if(sortType.equals("bubble")){
                    if(i==currentIndex||i==comparedIndex){
                        g.setColor(red);
                    }
                    else if(i>=minimumSorted){
                        g.setColor(green);
                    }
                    else{
                        g.setColor(white);
                    }
                }

                else if (sortType.equals("merge")){
                    if(i==currentIndex||i==comparedIndex){
                        g.setColor(red);
                    }
                    
                    else if(i==lowBound||i==upBound){
                        g.setColor(green);
                    }
                    else if(i==middle){
                        g.setColor(Color.blue);
                    }
                   
                    else{
                        g.setColor(white);
                    }
                
                }

                else if(sortType.equals("quick")){
                    if(i==comparedIndex){
                        g.setColor(red);
                    }
        
                    else if(i==lowBound||i==upBound){
                        g.setColor(Color.CYAN);
                    }
                    else{
                        g.setColor(white);
                    }
                }

                else if(sortType.equals("heap")){
                   
                    if(i==comparedIndex||i==currentIndex){
                        g.setColor(red);
                    }
                    else if(i>=buildingHeapIndex&&i< cap){
                        g.setColor(depthColours[nodeDepth(i)]);
                    }
                    else if (i==cap){
                        g.setColor(green);
                    }
                    else if(i>cap){
                        g.setColor(white);
                    }
                    else{

                        g.setColor(white);
                    }
                }
                
               makeRect(g, i);
                
                


            }
            }
    
            
    }

    private void makeRect(Graphics g ,int i ){
        int tranformedNum = (int)(nums[i]*heightMultiplier)+heightShift;

        g.fillRect(i*width, MAX_HEIGHT-tranformedNum, width, tranformedNum); 
        g.setColor(Color.black);
        g.drawRect(i*width, MAX_HEIGHT-tranformedNum, width,tranformedNum);
    }

    public int nodeDepth(int i){
        double log2 = Math.log(i+1)/Math.log(2);
        return (int)log2;
    }



   
    
}
