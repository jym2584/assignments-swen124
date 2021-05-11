/**
 * File header JavaDoc should describe the purpose of the class. This class is
 * a style example provided to students. Be sure to include an author tag with
 * your real name (this helps graders tell who you are).
 * 
 * @author GCCIS Faculty
 */
public class StyleExample {
    /**
     * Constants may or may not be public depending on whether they are used
     * outside of the class or not.
     */
    public static final int DAYS_IN_YEAR = 365;

    /**
     * All instance fields should be private by default. The JavaDoc comment
     * should explain the purpose of the field.
     * 
     * This holds a person's name.
     */
    private String name;

    /**
     * All instance fields should be private by default. The JavaDoc comment
     * should explain the purpose of the field.
     * 
     * This holds a person's age.
     */
    private int age;

    /**
     * A JavaDoc comment should be provided for each constructor, including
     * an explanation of the purpose of each parameter.
     * 
     * @param name The name of a person.
     * @param age The age of a person.
     */
    public StyleExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * A JavaDoc comment should be provided for each constructor, including
     * an explanation of the purpose of each parameter. This constructor sets
     * the age to a default value of 0.
     * 
     * @param name The name of a person.
     */
    public StyleExample(String name) {
        this(name, 0);
    }

    /**
     * Accessors should be provided only for those fields that are used outside
     * of the class. A JavaDoc comment is optional unless the method does
     * something other than return the value.
     * 
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /**
     * Mutators should be provided only for those fields that need to be 
     * modified from outside of the class. A JavaDoc comment is optional unless
     * the method does something other than modify the value.
     * 
     * @param age The new age.
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Returns a string in the format StyleExample{name=name, age=age}.
     * 
     * Override annotation should be used when overriding an inherited method.
     * 
     * @return A string representation of an instance of this class.
     */
    @Override
    public String toString() {
        return "StyleExample{name=" + name 
            + ", age=" + age + "}";
    }
}