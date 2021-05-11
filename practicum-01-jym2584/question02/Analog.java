package question02;

public class Analog extends Camera {
    private int picturesRemaining;
    private int maxPictures;

    public Analog(String manufacturer, String model, LensType lensType, int picturesRemaining) {
        super(manufacturer, model, lensType);
        this.picturesRemaining = picturesRemaining;
        this.maxPictures = picturesRemaining;
    }

    public void loadFilm() {
        picturesRemaining = maxPictures;

        System.out.println("Loaded the film. Now " + picturesRemaining);
    }

    @Override
    public boolean takePicture() {
        if (picturesRemaining <= 0) {
            System.out.println("Cannot take any more pictures. Please load a new roll");
            return false;
        } else {
            System.out.println("Took a picture");
            picturesRemaining--;
            return true;
        }
    }

    public int getPicturesRemaining() { return picturesRemaining;}

    @Override
    public String toString() {
        return "Analog Camera {" + getManufacturer() + " , " + getModel() + " , " + getLensType() + " , " + picturesRemaining + "}";
    }
    
    public static void main(String[] args) {
        Camera analog = new Analog("Bro", "model bro", LensType.FISHEYE, 3);
        System.out.println(analog);
        ((Analog)analog).takePicture();
        System.out.println(((Analog)analog).getPicturesRemaining());
        System.out.println(analog);
        ((Analog)analog).takePicture();
        ((Analog)analog).takePicture();
        ((Analog)analog).takePicture();
        ((Analog)analog).loadFilm();
        ((Analog)analog).takePicture();
        System.out.println(analog);
    }


}
