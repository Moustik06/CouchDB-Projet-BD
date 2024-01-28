package org.example;

import java.io.IOException;
import java.util.List;

import org.example.Reader.Reader;
import org.example.entity.*;
import org.example.entityDAO.*;

public class CouchJava {

    public static void main(String[] args) throws IOException {
        /*
        AgenceDAO agenceDAO = new AgenceDAO();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Agence agence = new Agence(1,arr,1,"Agence du Soleil","1 rue du soleil","0123456789");
        Agence agence2 = new Agence(2,arr,1,"Agence du Soleil2222","1 rue du soleil","0123456789");
        Agence agence3 = new Agence(3,arr,1,"AAAAAAAAAAAAAAAa","rue du aaaaaaaaaaaaaa","0123456789");
        arr.add(4);
        arr.add(5);
        Agence agence4 = new Agence(4,arr,1,"BBBBBBBBBBBBBBBB","rue du bbbbbbbbbbbbb","0123456789");
        arr.remove(4);
        Agence agence5 = new Agence(5,arr,1,"CCCCCCCCCCCCCCCC","rue du ccccccccccccc","0123456789");
        Assurance assurance = new Assurance(2,1,"Assurance","Assurance du Soleil",100.0);


        //agenceDAO.insert(agence);
        //agenceDAO.insert(agence2);
        //agenceDAO.insert(agence3);
        //agenceDAO.insert(agence4);
        //agenceDAO.insert(agence5);

        //creer des clients
        ClientDAO clientDAO = new ClientDAO();
        Client client1 = new Client(1,"Jean","Dupont","1 rue du soleil","0123456789","jean.dupont@gmailcom");
        Client client2 = new Client(2,"Cou","Beh","2 rue du cul","0123456789","cou.beh@gmailcom");

        //inserer clients
        clientDAO.insert(client1);
        clientDAO.insert(client2);

        LocationDAO locationDAO = new LocationDAO();

        // Créer des documents Location associés à l'Agence 1
        Location location1 = new Location(1,1,1,1,1,"7/16/2023","7/9/2023",1,1,225.0);
        Location location2 = new Location(2,1,2,1,1,"7/18/2023","7/11/2023",1,1,223.0);

        // inserer les locations
        //locationDAO.insert(location1);
        //locationDAO.insert(location2);

        // Tester la fonction
        ArrayList<Agence> agencesTriees = agenceDAO.sortAgencesByNombreClientDec();

        // Afficher le résultat
        for (Agence agenceTriee : agencesTriees) {
            System.out.println("Agence ID: " + agenceTriee.getId() + ", Nombre de clients: " + agenceTriee.getNombreClients());
        }

        BaseDAO.closeConnection();



    */

        Reader reader = new Reader();
        AgenceDAO agenceDAO = new AgenceDAO();
        AssuranceDAO assuranceDAO = new AssuranceDAO();
        ClientDAO clientDAO = new ClientDAO();
        EmployerDAO employerDAO = new EmployerDAO();
        FactureDAO factureDAO = new FactureDAO();
        LocationDAO locationDAO = new LocationDAO();
        ParkingDAO parkingDAO = new ParkingDAO();
        VehiculeDAO vehiculeDAO = new VehiculeDAO();

        List<Agence> agences = reader.agencesReader();
        List<Assurance> assurances = reader.assurancesReader();
        List<Client> clients = reader.clientsReader();
        List<Employer> employers = reader.employersReader();
        List<Facture> factures = reader.facturesReader();
        List<Location> locations = reader.locationsReader();
        List<Parking> parkings = reader.parkingsReader();
        List<Vehicule> vehicules = reader.vehiculesReader();


        /*
         POUR INSERER
        for (Agence agence : agences) {
            agenceDAO.insert(agence);
         */

    }

}