package activities;

public class NameThread2 implements Runnable {
    private final String name;
    private final int index;

    public NameThread2(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(15 * index);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(name.charAt(index));
    }

    public static void main(String[] args) {
        String name = "Bruce";
        Thread[] threads = new Thread[name.length()];
        for(int i =0; i < threads.length; i++) {
            threads[i] = new Thread(new NameThread2(name, i));
            threads[i].start();
        }
    }
}
