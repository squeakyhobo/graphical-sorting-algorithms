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
    int cap =0;
    
    Color green = new Color(57,255,20);
    Color white = Color.WHITE;
    Color red = Color.red;
    

    public Graph(int[] nums){
        super();
        this.nums =nums;
        
    }
    @Override
    protected void paintComponent(Graphics g){
        
        

            super.paintComponent(g);
            
        //g.translate(0,getHeight());
            if(afterSorted){
                
                g.setColor(white);

                for(int i =0;i<nums.length;i++){
                    
                    
                    g.fillRect(i*10, MAX_HEIGHT-nums[i], 10, nums[i]);
                    g.setColor(Color.black);
                    g.drawRect(i*10, MAX_HEIGHT-nums[i], 10, nums[i]);
                    g.setColor(white);
                    
                }
            }
            else if (sorted){
                
                    for(int j =0; j<nums.length;j++){
                        if (j<=cap){
                            g.setColor(green);
                        }
                       
                        else{
                            g.setColor(white);
                        }
                        
                        g.fillRect(j*10, MAX_HEIGHT-nums[j], 10, nums[j]); 
                        g.setColor(Color.black);
                        g.drawRect(j*10, MAX_HEIGHT-nums[j], 10, nums[j]);

                    }
                    
                
            }
            else{
            for(int i =0; i<nums.length;i++){
                
                if(i==currentIndex||i==comparedIndex){
                    g.setColor(red);
                }
                else if(i<currentIndex){
                    g.setColor(green);
                }
                else{
                    g.setColor(white);
                }
                
                g.fillRect(i*10, MAX_HEIGHT-nums[i], 10, nums[i]); 
                g.setColor(Color.black);
                g.drawRect(i*10, MAX_HEIGHT-nums[i], 10, nums[i]);
                
                


            }
            }
    
            
    }



   
    
}
