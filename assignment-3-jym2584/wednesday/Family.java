package wednesday;

public class Family {
    public static void printParent(Parent parent) {
        System.out.println(parent);
    }

    public static void printChild(Child child){
        System.out.println(child);
    }

    public static void main(String[] args) {
        Parent parent = new Parent("John");
        Child child = new Child("Jane", 4);
        Parent child2 = new Child("Jane", 4);

        printParent(parent);
        printParent(child2); // Polymorphism
        printChild(child);
        
        //printChild((Child)parent);
        //printChild((Child)child2);

        System.out.println(((Child)child2).getAge());
    }
}
