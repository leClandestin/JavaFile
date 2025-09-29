import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> car = new HashMap();

    public VehicleRegistry(){

    }
    public boolean add(LicensePlate licensePlate, String owner){
        if (car.containsKey(licensePlate)){
            return false;
        }
        car.put(licensePlate,owner);       
        return true;
    }
    public String get(LicensePlate licensePlate){
        if(car.containsKey(licensePlate)){
            return car.get(licensePlate);
        }
        return null;
    }
    public boolean remove(LicensePlate licensePlate){
        if (car.containsKey(licensePlate)){
            car.remove(licensePlate);
            return true;
        }
        return false;
    }
    public void printLicensePlates(){
        for (LicensePlate plate : car.keySet()) {
            System.out.println(plate);
        }
    }
    public void printOwners(){
        ArrayList<String> name = new ArrayList<>();
        for (String ownerName : car.values()){
            if (!name.contains(ownerName)){
                System.out.println(ownerName);
                name.add(ownerName);
            }
        }
    }
}
