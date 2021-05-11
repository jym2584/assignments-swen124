package wednesday;

public class Child extends Parent {
    //private String name;
    private int age;

    public Child(String name, int age) {
        super(name);
        this.age = age;
    }


    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Child { name=" + getName() + ", age=" + age + "}";
    }
}
