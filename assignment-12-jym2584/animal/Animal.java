package animal;

public class Animal {
    private String name;
    private int age;
    private String sound;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public void doTheSound() {
        System.out.println("The " + name + " says '" + sound +"'.");
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public String toString() {
        return "Animal {" + name + ", " + age + ", " + sound +"}";
    }
    public static void main(String[] args) {
        Animal animal = new Animal("Ethan", 10, "I'm ethan Bradberry");

        System.out.println(animal);
        animal.doTheSound();
    }

}
