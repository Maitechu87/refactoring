import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;

    public Lloguer(Date data, int dies, Vehicle vehicle){
        this.data = data;
        this.dies = dies;
        this.vehicle = vehicle;
    }

    public Date getData()     { return data;     }
    public void setData(Date data){ this.data = data;}

    public int getDies()     { return dies;     }
    public void setDies(int dies){ this.dies = dies;}

    public Vehicle getVehicle(){ return vehicle;}
    public void setVehicle(Vehicle vehicle){this.vehicle=vehicle;}

    public void llogar(Vehicle vehic){
        setVehicle(vehic);
    }
    public void eliminarLloguer(){setVehicle(null);}

    public boolean estaLlogat() {
        if (vehicle != null) {
            return true;
        } else {
            return false;
        }

    }
}
