package ritclass;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class RITClassTest {
    public static final List<RITClass> classes = new ArrayList<>(); static {
        classes.add(new RITClass("SWEN 344 05"));
        classes.add(new RITClass("SWEN-344 01"));
        classes.add(new RITClass("SWEN 261-02"));
        classes.add(new RITClass("COMM 201 06"));
        classes.add(new RITClass("STSO-120 02"));
        classes.add(new RITClass("PHYS 211-02"));
    }
    
    @Test
    public void sortTest() {
        List<RITClass> sortOne = new ArrayList<>(classes);
        List<RITClass> sortTwo = new ArrayList<>(classes);
        
        sortOne.sort(new RITClass.ClassesSortAll());
        Collections.sort(sortTwo);

        assertEquals("[COMM 201-6, PHYS 211-2, STSO 120-2, SWEN 261-2, SWEN 344-1, SWEN 344-5]", sortOne.toString());
        assertEquals("[COMM 201-6, PHYS 211-2, STSO 120-2, SWEN 344-5, SWEN 344-1, SWEN 261-2]", sortTwo.toString());

    }
    @Test
    public void treeSetTest() {
        TreeSet<RITClass> classesSet = new TreeSet<>();
        classesSet.add(new RITClass("SWEN 344 05"));
        classesSet.add(new RITClass("SWEN-344 01"));
        classesSet.add(new RITClass("SWEN 261-02"));
        classesSet.add(new RITClass("COMM 201 06"));
        classesSet.add(new RITClass("STSO-120 02"));
        classesSet.add(new RITClass("PHYS 211-02"));

        assertEquals("[COMM 201-6, PHYS 211-2, STSO 120-2, SWEN 344-5, SWEN 261-2]", classesSet.toString());

    }

}
