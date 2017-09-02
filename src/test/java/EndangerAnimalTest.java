import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class EndangerAnimalTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_animalInstanciatesCorrectly_true(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
        assertTrue(testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void getName_returnsTheName_String(){
       EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
       assertEquals("elephant", testEndangeredAnimal.getName());
    }

    @Test
    public void getClassification_returnsTheCorrectClassification_String(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
        assertEquals("herbivorous",testEndangeredAnimal.getClassification());
    }

    @Test 
    public void equals_returnsTrueIfTheClassificationAndTheNameareTheSame_true(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
        assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
    }

    @Test
    public void save_insertsObjectIntoDatabase_EndangeredAnimal(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
        testEndangeredAnimal.save();
        assertTrue(testEndangeredAnimal.all().get(0).equals(testEndangeredAnimal)); 
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
      EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("elephant", "herbivor", "well", 5);
      firstEndangeredAnimal.save();
      EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("tiger", "canivore", "ill", 10);
      secondEndangeredAnimal.save();
      assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
      assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void save_savesAndAssignanIdToObject(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("elephant", "herbivorous", "well",10);
        testEndangeredAnimal.save();
        EndangeredAnimal newEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(newEndangeredAnimal.getId(), testEndangeredAnimal.getId());

    }

    public void find_findsAndReturnsEndangeredAnimalWithSameId_true(){
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("elephant", "herbivor","well", 9);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("tiger", "canivore", "ill", 10);
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
}