import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;


public class ClientTest {

    private Client client2;
    private Client senseLloguer;
    private Client clloguerBasic;
    private Client cLlogLuxe;
    private Client muchosAlquileres;
    private Client cContodo;

    @Before
    public void testInforme() {

        //creo nuevo cliente con alquiler para test

        client2  = new Client("46985471","Eric","698741475");
        Date data2 = GestorLloguersLite.crearData("24/5/2009", "d/M/yyyy");
        Vehicle vehicle2 = new Vehicle("A3", "Audi", Vehicle.GENERAL);
        Lloguer lloguerGeneral = new Lloguer(data2, 4);
        lloguerGeneral.llogar(vehicle2);
        client2.afegeix(lloguerGeneral);

    }

    @Before
    public void testInformeSenseL(){
        senseLloguer = new Client("47852587G","Martina","639588521");

    }

    @Before
    public void testILloguerBasic(){
        clloguerBasic  = new Client("46985471","Alex","698741475");
        Date data2 = GestorLloguersLite.crearData("22/5/2019", "d/M/yyyy");
        Vehicle vehicle2 = new Vehicle("Saxo", "Citroen", Vehicle.BASIC);
        Lloguer lloguerBasic = new Lloguer(data2, 1);
        lloguerBasic.llogar(vehicle2);
        clloguerBasic.afegeix(lloguerBasic);
    }

    @Before
    public void testInformeLuxe() {

        cLlogLuxe = new Client("46985471", "Maite", "698741475");
        Date data2 = GestorLloguersLite.crearData("24/5/2009", "d/M/yyyy");
        Vehicle vehicle2 = new Vehicle("Diablo", "Lamborgini", Vehicle.LUXE);
        Lloguer lloguerLuxe = new Lloguer(data2, 30);
        lloguerLuxe.llogar(vehicle2);
        cLlogLuxe.afegeix(lloguerLuxe);
    }

    @Before
    public void testMuchosAlq() {

        muchosAlquileres = new Client("46985471", "Maite", "698741475");
        Date data2 = GestorLloguersLite.crearData("27/5/2019", "d/M/yyyy");
        Date data3 = GestorLloguersLite.crearData("26/6/2019", "d/M/yyyy");
        Vehicle vehicle2 = new Vehicle("Diablo", "Lamborgini", Vehicle.LUXE);
        Vehicle vehicleGeneral = new Vehicle("A4", "Audi", Vehicle.GENERAL);
        Lloguer lloguerLuxe = new Lloguer(data2, 15);
        Lloguer lloguerGeneral = new Lloguer(data3, 1);
        lloguerLuxe.llogar(vehicle2);
        lloguerGeneral.llogar(vehicleGeneral);
        muchosAlquileres.afegeix(lloguerLuxe);
        muchosAlquileres.afegeix(lloguerGeneral);

    }

    @Before
    public void testConTodo(){
        cContodo = new Client("46967587G","Maite","659874790");

        Date data11 = GestorLloguersLite.crearData("27/5/2019", "d/M/yyyy");
        Vehicle vehicleBasic = new Vehicle("Clio", "Renault", Vehicle.BASIC);
        Lloguer lloguerBasic = new Lloguer(data11, 1);
        lloguerBasic.llogar(vehicleBasic);
        cContodo.afegeix(lloguerBasic);


        Date data22 = GestorLloguersLite.crearData("26/6/2019", "d/M/yyyy");
        Vehicle vehicleGeneral = new Vehicle("A3", "Audi", Vehicle.GENERAL);
        Lloguer lloguerGeneral = new Lloguer(data22, 4);
        lloguerGeneral.llogar(vehicleGeneral);
        cContodo.afegeix(lloguerGeneral);


        Date data33 = GestorLloguersLite.crearData("27/5/2019", "d/M/yyyy");
        Vehicle vehicleLuxe = new Vehicle ("F8 Tributo","Ferrari", Vehicle.LUXE);
        Lloguer lloguerLuxe = new Lloguer(data33, 5);
        lloguerLuxe.llogar(vehicleLuxe);
        cContodo.afegeix(lloguerLuxe);

    }

    @Test
    public void informe () {

        String informe = client2.informe();

        String informeEsperado = "Informe de lloguers del client Eric (46985471)\n" +
                "\tAudi A3: 270.0€\n" +
                "Import a pagar: 270.0€\n" +
                "Punts guanyats: 1\n";

        Assert.assertEquals(informeEsperado, informe);

    }

    @Test
    public void informeLloguerBasic () {

        String informe = clloguerBasic.informe();

        String informeEsperado = "Informe de lloguers del client Alex (46985471)\n" +
                "\tCitroen Saxo: 90.0€\n" +
                "Import a pagar: 90.0€\n" +
                "Punts guanyats: 1\n";

        Assert.assertEquals(informeEsperado, informe);

    }

    @Test
    public void informeSinAlquiler () {

        String informe = senseLloguer.informe();

        String informeEsperado = "Informe de lloguers del client Martina (47852587G)\n" +
                "Import a pagar: 0.0€\n" +
                "Punts guanyats: 0\n";

        Assert.assertEquals(informeEsperado, informe);

    }

    @Test
    public void informeLloguerLuxe () {

        String informe = cLlogLuxe.informe();

        String informeEsperado = "Informe de lloguers del client Maite (46985471)\n" +
                "\tLamborgini Diablo: 5400.0€\n" +
                "Import a pagar: 5400.0€\n" +
                "Punts guanyats: 2\n";

        Assert.assertEquals(informeEsperado, informe);

    }

    @Test
    public void informeMuchosAlqu () {

        String informe = muchosAlquileres.informe();

        String informeEsperado = "Informe de lloguers del client Maite (46985471)\n" +
                "\tLamborgini Diablo: 2700.0€\n" +
                "\tAudi A4: 120.0€\n" +
                "Import a pagar: 2820.0€\n" +
                "Punts guanyats: 3\n";

        Assert.assertEquals(informeEsperado, informe);

    }

    @Test
    public void informeConTodo () {

        String informe = cContodo.informe();

        String informeEsperado = "Informe de lloguers del client Maite (46967587G)\n" +
                "\tRenault Clio: 90.0€\n" +
                "\tAudi A3: 270.0€\n" +
                "\tFerrari F8 Tributo: 900.0€\n" +
                "Import a pagar: 1260.0€\n" +
                "Punts guanyats: 4\n";

        Assert.assertEquals(informeEsperado, informe);

    }
}


