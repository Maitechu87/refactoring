import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    private static final int DIAS_INCIALES_MISMO_COSTE_BASIC = 3;
    private static final int DIAS_INCIALES_MISMO_COSTE_GENERAL = 2;
    private static final double PRECIO_BASIC = 1.5;
    private static final double PRECIO_GENERAL = 2.5;
    private static final double PRECIO_LUXE = 6;


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
    public double preu(){
        double preu = 0;
        switch (getVehicle().getCategoria()) {
            case BASIC:
                preu += 3;
                if (getDies() > DIAS_INCIALES_MISMO_COSTE_BASIC) {
                    preu += (getDies() - DIAS_INCIALES_MISMO_COSTE_BASIC) * PRECIO_BASIC;
                }
                break;
            case GENERAL:
                preu += 4;
                if (getDies() > DIAS_INCIALES_MISMO_COSTE_GENERAL) {
                    preu += (getDies() - DIAS_INCIALES_MISMO_COSTE_GENERAL) * PRECIO_GENERAL;
                }
                break;
            case LUXE:
                preu += getDies() * PRECIO_LUXE;
                break;
        }
        return preu;
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