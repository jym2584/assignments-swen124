package question02;

public abstract class Camera {
    private String manufacturer;
    private String model;
    private LensType lensType;

    protected Camera(String manufacturer, String model, LensType lensType) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.lensType = lensType;

    }

    public abstract boolean takePicture();

    public String getManufacturer(){ return manufacturer; }
    public String getModel() { return model; }
    public String getLensType() { return lensType.toString(); }

    @Override
    public String toString() {
        return "Camera {" + manufacturer + " , " + model + " , " + lensType + "}";
    }
}
