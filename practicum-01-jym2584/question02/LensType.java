package question02;

public enum LensType {
    FISHEYE("Fish eye"),
    WIDE_ANGLE("Wide Angle"),
    STANDARD("Standard"),
    TELEPHOTO("Telephoto"),
    MACRO("Macro");

    private String lensType;

    private LensType(String lensType) {
        this.lensType = lensType;
    }

    @Override
    public String toString() {
        return lensType;
    }
}
