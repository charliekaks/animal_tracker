import java.util.List;
import org.sql2o.*;
public class SafeAnimal extends Animal{

    private static final String DATA_TYPE = "safe";

    public SafeAnimal(String name, String classification){
        this.name=name;
        this.classification = classification;
        type = DATA_TYPE;

}

@Override
public void save(){
    try(Connection con = DB.sql2o.open()){
        String sql = "INSERT INTO animals (name, classification,type) VALUES (:name, :classification,:type);";
           this.id = (int) con.createQuery(sql, true)
                .addParameter("name", this.name)
                .addParameter("classification", this.classification)
                .addParameter("type", this.type)
                .executeUpdate()
                .getKey();
    }
}

@Override
public boolean equals(Object otherAnimal){
    if(!(otherAnimal instanceof Object)){
        return false;
    }
    Animal newAnimal = (Animal) otherAnimal;
        return this.getName().equals(newAnimal.getName())&&
                this.getClassification().equals(newAnimal.getClassification())&&
                this.getId()==newAnimal.getId() ;

}
    public static List<SafeAnimal> all(){
        String sql = "SELECT * FROM animals WHERE type='safe'";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(SafeAnimal.class);
        }
    }

    public static SafeAnimal find(int id){
        String sql = "SELECT * FROM animals WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            SafeAnimal animal = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(SafeAnimal.class);
                    return animal;
        }
    }
}