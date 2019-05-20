import java.util.Vector;

public class Vehicle {
    private String model;
    private String marca;
    private Tipus categoria;

    public static Tipus BASIC = Tipus.BASIC;
    public static Tipus GENERAL = Tipus.GENERAL;
    public static Tipus LUXE = Tipus.LUXE;

    private enum Tipus{ BASIC, GENERAL, LUXE}


    public Vehicle(String model, String marca, Tipus categor){
        this.model = model;
        this.marca = marca;
        this.categoria = categor;
    }

    public String getModel()     { return model;     }
    public String getMarca()     { return marca;     }
    public Tipus getCategoria() { return categoria; }

    public void setModel(String model) { this.model = model; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setCategoria(Tipus categor) { this.categoria = categor;}


}
