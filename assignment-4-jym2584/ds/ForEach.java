package ds;

public class ForEach {

    public static void forArray(String[] sarray) {
    for(String str : sarray) {
        System.out.println(str);
        }
    }
    
    public static void forList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void forArrayList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }



public static void main (String[] args) {
    String [] sArray = {"a", "b", "c", "d"};
    forArray(sArray);

    List<String> alist = new ArrayList<> ();
    alist.append("k");
    alist.append("l");
    alist.append("m");
    alist.append("n");
    alist.append("o");
    forArrayList(alist);

    List<String> llist = new LinkedList<> ();
    llist.append("f");
    llist.append("g");
    llist.append("h");
    llist.append("i");
    llist.append("j");
    forList(llist);
    System.out.println(llist.get(2));

}

}