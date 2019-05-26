import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    private static final int DIAS_INCIALES_MISMO_COSTE_BASIC = 3;
    private static final int DIAS_INCIALES_MISMO_COSTE_GENERAL = 2;

    public Lloguer(Date data, int dies){
        this.data = data;
        this.dies = dies;
    }

    public Date getData()     { return data;     }
    public int getDies()     { return dies;     }
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
                if (getDies() > DIAS_INCIALES_MISMO_COSTE_BASIC) {
                    quantitat += (getDies() - DIAS_INCIALES_MISMO_COSTE_BASIC) * 1.5;
                }
                break;
            case GENERAL:
                quantitat += 4;
                if (getDies() > DIAS_INCIALES_MISMO_COSTE_GENERAL) {
                    quantitat += (getDies() - DIAS_INCIALES_MISMO_COSTE_GENERAL) * 2.5;
                }
                break;
            case LUXE:
                quantitat += getDies() * 6;
                break;
        }
        return quantitat;
    }

    public int bonificacions(){
        if (getVehicle().getCategoria() == Vehicle.LUXE &&
                getDies()>1 ) {
            return 2;
        } else {
            return 1;
        }
    }
}