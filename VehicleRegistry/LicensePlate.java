
import java.util.Objects;

public class LicensePlate {

    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }
    public boolean equals(Object that){
        if (that == null){
            return false;
        }
        if (this == that){
            return true;
        }
        if (this.getClass() != that.getClass()){
            return false;
        }
        
        LicensePlate thatt = (LicensePlate) that;
        if (this.liNumber.equals(thatt.liNumber) && this.country.equals(thatt.country)){
            return true;
        }
        return false;
    }
    public int hashCode(){
        int result = 17;       
        result = 31 * result + (liNumber != null ? liNumber.hashCode() : 0);
        return result;
    }
}
