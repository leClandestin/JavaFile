public class Recipe {
    private String name;
    private String time;
    
    public Recipe(String name, String time){
        this.name= name;       
        this.time = time;
    }
    public String getName(){
        return name;
    }
    public String getTime(){
        return time;
    }
    public String toString(){
        return name + ", cooking time: " + time; 
    }
}
