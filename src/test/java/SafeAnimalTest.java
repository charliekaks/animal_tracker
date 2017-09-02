import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SafeAnimalTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void SafeAnimal_animalInstanciatesCorrectly_true(){
       SafeAnimal testAnimal = new SafeAnimal("elephant", "herbivorous");
        assertTrue(testAnimal instanceof SafeAnimal);
    }

    @Test
    public void getName_returnsTheName_String(){
      SafeAnimal testAnimal = new SafeAnimal("elephant", "herbivorous");
       assertEquals("elephant", testAnimal.getName());
    }

    @Test
    public void getClassification_returnsTheCorrectClassification_String(){
       SafeAnimal testAnimal = new SafeAnimal("elephant", "herbivorous");
        assertEquals("herbivorous", testAnimal.getClassification());
    }

    @Test 
    public void equals_returnsTrueIfTheClassificationAndTheNameareTheSame_true(){
       SafeAnimal testAnimal = new SafeAnimal("elephant", "herbivorous");
       SafeAnimal anotherAnimal = new SafeAnimal("elephant", "herbivorous");
        assertTrue(testAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Animal(){
       SafeAnimal testAnimal = new SafeAnimal("elephant", "herbivorous");
        testAnimal.save();
        assertTrue(SafeAnimal.all().get(0).equals(testAnimal)); 
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
     SafeAnimal firstAnimal = new SafeAnimal("elephant", "herbivor");
      firstAnimal.save();
     SafeAnimal secondAnimal = new SafeAnimal("tiger", "canivore");
      secondAnimal.save();
      assertEquals(true,SafeAnimal.all().get(0).equals(firstAnimal));
      assertEquals(true,SafeAnimal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void save_savesAndAssignanIdToObject(){
       SafeAnimal testAnimal = new SafeAnimal("elephant", "herbivorous");
        testAnimal.save();
       SafeAnimal newAnimal =SafeAnimal.all().get(0);
        assertEquals(newAnimal.getId(), testAnimal.getId());

    }

    public void find_findsAndReturnsAnimalWithSameId_true(){
       SafeAnimal firstAnimal = new SafeAnimal("elephant", "herbivor");
        firstAnimal.save();
       SafeAnimal secondAnimal = new SafeAnimal("tiger", "canivore");
        secondAnimal.save();
        assertEquals(SafeAnimal.find(secondAnimal.getId()), secondAnimal);
    }
}