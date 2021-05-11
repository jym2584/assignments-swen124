package connectfour.model;

public interface CheckerObserver {
    void checkerChanged(ConnectFour board, int col, int row);

}
