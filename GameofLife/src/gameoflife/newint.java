
package gameoflife;


public class newint {
    private int value;
    private int treshold;
    public newint(int val)
    {
        this.set(val);
    }
    public void setTreshold(int treshold){
        this.treshold = treshold;
    }
    public void set(int val)
    {
        if (val >= treshold)
        {
            value = val - treshold;
        }
        else if (val < 0)
        {
            value = treshold + val;
        }
        else 
            value = val;
                
    }
    
    public int get()
    {
        return value;
           
    }
}
