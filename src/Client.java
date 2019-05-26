import java.util.ArrayList;


public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private ArrayList<Lloguer> lloguers;
    private static final double EUROS_PER_UNITAT_DE_COST = 30;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new ArrayList<>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public ArrayList<Lloguer> getLloguers(){ return lloguers;}


    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }


    public String informe() {
        return composaCapsalera() +
                composaDetall() +
                composaPeu();
    }

    public String informeHTML(){
        return capseleraHtml()+
                detallHtml()+
                peuHtml();
    }

    public String composaCapsalera(){
        String capselera = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
        return capselera;
    }

    public String capseleraHtml(){
        String capselera = "<h1>Informe de lloguers</h1>\n<p>Informe de lloguers del client<em> " +
                getNom() +"</em>(<strong>" + getNif() + "</strong>)</p>\n";
        return capselera;
    }

    public String composaDetall(){
        String detall = "";
        for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            detall += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    (lloguer.preu() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }
        return detall;
    }

    public String detallHtml(){
        String detall = "<table>\n<tr><td><strong>Marca</strong></td><td><strong>"+
                "Model</strong></td><td><strong>Import</strong></td></tr>\n";
        for (Lloguer lloguer: lloguers) {
            detall += "\t<tr><td>" +
                    lloguer.getVehicle().getMarca() +
                    "</td><td> " +
                    lloguer.getVehicle().getModel() + "</td><td>" +
                    (lloguer.preu() * EUROS_PER_UNITAT_DE_COST) + "€ </td></tr>\n";
        }
        detall +="</table>\n";
        return detall;
    }

    public String composaPeu(){
        String resultat = "Import a pagar: ";
        resultat += importTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotals() + "\n";
        return resultat;
    }

    public String peuHtml(){
        String resultat = "<p>Import a pagar: <em>";
        resultat += importTotal() + "€</em></p>\n" +
                "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>\n";
        return resultat;
    }

    public double importTotal() {
        double total= 0;
        for(Lloguer lloguer: lloguers){
            double quantitat = lloguer.preu();
            total += quantitat* EUROS_PER_UNITAT_DE_COST;
        }
        return total;
    }

    public int bonificacionsTotals(){
        int bonificacions = 0;
        for(Lloguer lloguer: lloguers){
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }


}