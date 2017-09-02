import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
public class SightingsTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_animalInstanciatesCorrectly_true(){
        Sightings testSightings = new Sightings("Albert", "North",3);
        assertTrue(testSightings instanceof Sightings);
    }

    @Test
    public void getName_returnsTheName_String(){
        Sightings testSightings = new Sightings("Albert", "North",3);
        assertEquals("Albert", testSightings.getName()); 
    }

    @Test
    public void getId_returnsTheCorrectId_int(){
        Sightings testSightings = new Sightings("Albert", "North",3);
        assertEquals(3, testSightings.getanimalId()); 
    }
    @Test
    public void getLocation_returnTheCorrectLocation_String(){
        Sightings testSightings = new Sightings("Albert", "North",3);
        assertEquals("North", testSightings.getLocation());
    }
}