import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class GestorLloguersLite {

    public static void dadesClient (Client client){
        String informacio;
        informacio=("Client: "+"\nDNI del client: "+client.getNif()+"\nNom: "+client.getNom()+ "\nTelèfon: "+
                client.getTelefon()+"\nLlogers: "+"\nNum de lloguers del client: "+client.getLloguers().size());//Arraylist

        System.out.println(informacio);

        for(int i = 0; i<client.getLloguers().size(); i++){
            String marca = client.getLloguers().get(i).getVehicle().getMarca();
            String model = client.getLloguers().get(i).getVehicle().getModel();
            String data = dataToString(client.getLloguers().get(i).getData());
            int dies = client.getLloguers().get(i).getDies();

            System.out.println("\nVehicle: \nMarca: " + marca+"\nmodel: "+model+"\n"+data+"\ndies: "+dies);
        }


    }




    public static void main(String[] args) {
        // demostració de construcció d'un vehicle de categoria BASIC
        Client client1 = new Client("46967587G","Maite","659874790");

        Vehicle vehicleBasic = new Vehicle("Clio", "Renault", Vehicle.BASIC);
        Vehicle vehicleGeneral = new Vehicle("A3", "Audi", Vehicle.GENERAL);
        Vehicle vehicleLuxe = new Vehicle ("F8 Tributo","Ferrari", Vehicle.LUXE);

        Date dataLloguer1 = crearData("23/05/2019","d/M/yyyy");
        Date dataLloguer2 = crearData("26/05/2019","d/M/yyyy");
        Date dataLloguer3 = crearData("01/05/2019","d/M/yyyy");

        Lloguer lloguerBasic = new Lloguer(dataLloguer1, 2);
        Lloguer lloguerGeneral = new Lloguer(dataLloguer2, 4);
        Lloguer lloguerLuxe = new Lloguer(dataLloguer3, 5);


        //Al añadirlo así no hace falta enviar la información vehicle al constructor de lloguer
        lloguerBasic.llogar(vehicleBasic);
        lloguerGeneral.llogar(vehicleGeneral);
        lloguerLuxe.llogar(vehicleLuxe);

        client1.afegeix(lloguerBasic);
        client1.afegeix(lloguerGeneral);
        client1.afegeix(lloguerLuxe);

        dadesClient(client1);
    }

    protected static Date crearData(String data, String formatData) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatData);
        Date fecha = null;
        try{
            fecha = dateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

    private static String dataToString(Date data){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String fechaS = null;
        try{
            fechaS = formatter.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fechaS;


    }


}
