public class Vehicle {
    private String model;
    private String marca;
    private Tipus categoria;

    public static Tipus BASIC = Tipus.BASIC;
    public static Tipus GENERAL = Tipus.GENERAL;
    public static Tipus LUXE = Tipus.LUXE;

    public enum Tipus{ BASIC, GENERAL, LUXE}


    public Vehicle(String model, String marca, Tipus categor){
        this.model = model;
        this.marca = marca;
        this.categoria = categor;
    }

    public String getModel()     { return model;     }
    public String getMarca()     { return marca;     }
    public Tipus getCategoria() { return categoria; }


}