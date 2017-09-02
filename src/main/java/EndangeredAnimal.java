import java.util.List;
import org.sql2o.*;
public class EndangeredAnimal extends Animal{

    
    private static final String DATA_TYPE = "endangered";

    public EndangeredAnimal(String name, String classification, String health, int age){
            this.name=name;
            this.classification = classification;
            this.age = age;
            this.health = health;
            type = DATA_TYPE;

    }

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM animals WHERE type='endangered';";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id){
        String sql = "SELECT * FROM Endangereds WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            EndangeredAnimal animal = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(EndangeredAnimal.class);
                    return animal;
        }
    }
    
}