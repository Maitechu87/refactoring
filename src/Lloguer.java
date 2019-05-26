import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;

    public Lloguer(Date data, int dies){
        this.data = data;
        this.dies = dies;
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
    public double quantitat(){
        double quantitat = 0;
        switch (getVehicle().getCategoria()) {
            case BASIC:
                quantitat += 3;
                if (getDies() > 3) {
                    quantitat += (getDies() - 3) * 1.5;
                }
                break;
            case GENERAL:
                quantitat += 4;
                if (getDies() > 2) {
                    quantitat += (getDies() - 2) * 2.5;
                }
                break;
            case LUXE:
                quantitat += getDies() * 6;
                break;
        }
        return quantitat;
    }
}