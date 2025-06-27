public abstract class Sort{
    Graph panel;
    Sound soundEffects = new Sound();

    public Sort(Graph panel){
        this.panel = panel;
    }


    public abstract void sort(int[] nums);

    
    public void sleep(int millis){
        try{
            Thread.sleep(millis);
        }

        catch(Exception e){}
    }
}
