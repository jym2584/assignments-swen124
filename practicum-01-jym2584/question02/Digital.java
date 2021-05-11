package question02;

import java.util.Random;

public class Digital extends Camera {
    private int pictureSize;
    private int sizeRemaining;
    private int size;

    public Digital(String manufacturer, String model, LensType lensType) {
        super(manufacturer, model, lensType);
        this.sizeRemaining = 0;
        this.size = sizeRemaining;
    }

    public void insertMemoryCard(int amount) {
        sizeRemaining = amount;
        size = amount;
        System.out.println("Inserted memory card of size MB " + amount);
    }

    @Override
    public boolean takePicture() {
        if (sizeRemaining <= 0) {
            System.out.println("Cannot take any more pictures. Please load a new roll");
            return false;
        } else {
            this.sizeRemaining -= 20;
            System.out.println("Took a picture Size now " + sizeRemaining);
            return true;
        }
    }

    public int getSize() { return size;}
    public int getSizeRemaining() { return sizeRemaining;}
    @Override
    public String toString() {
        return "Digital Camera {" + getManufacturer() + " , " + getModel() + " , " + getLensType() + " , " + size + " , " + sizeRemaining + "}";
    }
    
    public static void main(String[] args) {
        Camera analog = new Digital("Bro", "model bro", LensType.MACRO);
        ((Digital)analog).insertMemoryCard(100);
        System.out.println(analog);
        boolean picture = ((Digital)analog).takePicture();
        System.out.println("Took a picture?: " + picture);
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();
        System.out.println(analog);
        ((Digital)analog).insertMemoryCard(200);
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();
        ((Digital)analog).takePicture();


    }


}
