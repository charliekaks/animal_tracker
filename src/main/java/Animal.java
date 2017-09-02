import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
public abstract class Animal{

    public String name;
    public String classification;
    public int id;
    public String type;
    public int age;
    public String health;

    public String getName(){
        return name;
    }

    public String getClassification(){
        return classification;
    }

    public int getId(){
        return id;
    }

    public int getAge(){
        return age;
    }

    public String getHealth(){
        return health;
    }



    @Override

    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Object)){
            return false;
        }
        Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName())&&
                    this.getClassification().equals(newAnimal.getClassification())&&
                    this.getId()==newAnimal.getId()&&
                    this.getAge()==newAnimal.getAge()&&
                    this.getHealth().equals(newAnimal.getHealth());

    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, classification,type,age,health) VALUES (:name, :classification,:type,:age,:health);";
               this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("classification", this.classification)
                    .addParameter("type", this.type)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .executeUpdate()
                    .getKey();
        }
    }

    


}