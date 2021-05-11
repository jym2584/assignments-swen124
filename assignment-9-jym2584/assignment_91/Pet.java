package assignment_91;

import java.util.*;

public abstract class Pet {
    private String species;
    
    protected Pet(String species) {
        this.species = species;
    }

    public abstract String speak();

    @Override
    public String toString() { return "Pet {" + species + "}"; }
    public String getSpecies() { return species; }

    public static void main(String[] args) {
        Pet dog = new Pet("Dog"){

            @Override
            public String speak() {
                return "Woof";
            }

        };

        Pet human = new Pet("Human") {

            @Override
            public String speak() {
                return "Hi";
            }
    
        };

        Pet phone = new Pet("Phone") {

            @Override
            public String speak() {
                return "Ring ring";
            }
            
        };

        List<Pet> pets = Arrays.asList(dog, human, phone);

        for(Pet pet:pets) {
            System.out.println("The " + pet.getSpecies() + " says '" + pet.speak() + "'");
        }


    }

}
