public class Sightings{
    private String rangerName;
    private String location;
    private int animalId;
    private int id;

    public Sightings(String rangerName, String location, int animalId){
        this.rangerName = rangerName;
        this.location = location;
        this.animalId = animalId;
    }

    public String getName(){
        return rangerName;
    }

    public String getLocation(){
        return location;
    }

    public int getId() {
        return id;
    }

    public int getanimalId(){
        return animalId;
    }
}