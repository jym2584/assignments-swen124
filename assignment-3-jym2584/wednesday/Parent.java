package wednesday;

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Parent { name=" + name + "}";
    }

    public static void main(String[] args) {
        Parent parent = new Parent("John");
        System.out.println(parent.getName());
    }
}
