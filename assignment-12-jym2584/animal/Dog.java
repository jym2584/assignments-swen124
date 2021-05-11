package animal;

public class Dog extends Animal {

    private int hunger;

    public Dog(String name, int age, String sound, int hunger) {
        super(name, age, sound); // attributes from extending Animal
        this.hunger = hunger; // attribute unique to this class only
    }

    public int getHunger() {
        return hunger;
    }

    public void eatFood(String food) {
        hunger--;
        System.out.println("The dog eats " + food);
        System.out.println("Hunger now: " + hunger);
    }


    public static void main(String[] args) {
        Animal animal = new Animal("Ethan", 10, "I'm ethan Bradberry");

        System.out.println(animal);
        animal.doTheSound();
        // animal.eatFood("Burger");  animal cannot eat food because they don't have this method

        System.out.println("\n\n");

        Dog doggie = new Dog("Doggo", 5, "Bark", 10);
        System.out.println(doggie);
        doggie.doTheSound(); // method from Animal
        
        doggie.eatFood("Burger"); // method that is unique to the Dog
    }
    
}
