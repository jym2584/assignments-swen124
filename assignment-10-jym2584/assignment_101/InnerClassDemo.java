package assignment_101;
/**
 * Ignore this class. Having trouble with creating inner classes, wanted to get a bit of help for this
 * Taken from: https://www.geeksforgeeks.org/inner-class-java/
 * 
 */
// outer class
class OuterClass
{
    // static member
    static int outer_x = 10;
     
    // instance(non-static) member
    int outer_y = 20;
     
    // private member
    private int outer_private = 30;
     
    // inner class
    class InnerClass
    {
        void display()
        {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);
             
            // can also access non-static member of outer class
            System.out.println("outer_y = " + outer_y);
             
            // can also access a private member of the outer class
            System.out.println("outer_private = " + outer_private);
         
        }
    }
}
 
// Driver class
public class InnerClassDemo
{
    public static void main(String[] args)
    {
        // accessing an inner class
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
         
        innerObject.display();
         
    }
}