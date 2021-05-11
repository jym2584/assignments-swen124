package activities;

public class Printer extends Thread {
    private String string;

    public Printer(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        for(int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }
    public static void main(String[] args) {
        Thread thread = new Printer("Hello world");
        thread.start();
    }

}