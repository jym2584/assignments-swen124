//Kung Fu Panda Exercise -- 5.1
package kfp;

public class Flowers{
    public final String name;
    public Flowers(){ this("Tulips and Dahlias"); }

    public <T> Flowers(String s){
        name = s;
    }
   @Override
    public String toString(){
        
        return name+"\n\n"+"No damage done, all nearby violence pacified..";
    }
}
