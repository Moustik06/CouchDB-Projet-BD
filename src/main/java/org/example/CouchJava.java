package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.Reader.Reader;
import org.example.entity.*;
import org.example.entityDAO.*;

public class CouchJava {

    public static void main(String[] args) throws IOException {
        VehiculeDAO vehiculeDAO = new VehiculeDAO();
        AgenceDAO angenceDAO = new AgenceDAO();
        // System.err.println(vehiculeDAO.marqueModelePlusLoues());//
        // vehiculesParPrixEtAgence(1000000, "Joséphine"));
        System.err.println(vehiculeDAO.vehiculesParPrixEtAgence(10000.0, "KÃ©vina").get(0).getData());
        /*
         * AgenceDAO agenceDAO = new AgenceDAO();
         * 
         * ArrayList<Integer> arr = new ArrayList<Integer>();
         * arr.add(1);
         * arr.add(2);
         * arr.add(3);
         * Agence agence = new
         * Agence(1,arr,1,"Agence du Soleil","1 rue du soleil","0123456789");
         * Agence agence2 = new
         * Agence(2,arr,1,"Agence du Soleil2222","1 rue du soleil","0123456789");
         * Agence agence3 = new
         * Agence(3,arr,1,"AAAAAAAAAAAAAAAa","rue du aaaaaaaaaaaaaa","0123456789");
         * arr.add(4);
         * arr.add(5);
         * Agence agence4 = new
         * Agence(4,arr,1,"BBBBBBBBBBBBBBBB","rue du bbbbbbbbbbbbb","0123456789");
         * arr.remove(4);
         * Agence agence5 = new
         * Agence(5,arr,1,"CCCCCCCCCCCCCCCC","rue du ccccccccccccc","0123456789");
         * Assurance assurance = new
         * Assurance(2,1,"Assurance","Assurance du Soleil",100.0);
         * 
         * 
         * //agenceDAO.insert(agence);
         * //agenceDAO.insert(agence2);
         * //agenceDAO.insert(agence3);
         * //agenceDAO.insert(agence4);
         * //agenceDAO.insert(agence5);
         * 
         * //creer des clients
         * ClientDAO clientDAO = new ClientDAO();
         * Client client1 = new Client(1,"Jean","Dupont","1 rue du soleil","0123456789",
         * "jean.dupont@gmailcom");
         * Client client2 = new
         * Client(2,"Cou","Beh","2 rue du cul","0123456789","cou.beh@gmailcom");
         * 
         * //inserer clients
         * clientDAO.insert(client1);
         * clientDAO.insert(client2);
         * 
         * LocationDAO locationDAO = new LocationDAO();
         * 
         * // Créer des documents Location associés à l'Agence 1
         * Location location1 = new
         * Location(1,1,1,1,1,"7/16/2023","7/9/2023",1,1,225.0);
         * Location location2 = new
         * Location(2,1,2,1,1,"7/18/2023","7/11/2023",1,1,223.0);
         * 
         * // inserer les locations
         * //locationDAO.insert(location1);
         * //locationDAO.insert(location2);
         * 
         * 
         * BaseDAO.closeConnection();
         * 
         */

        // Reader reader = new Reader();
        // AgenceDAO agenceDAO = new AgenceDAO();
        // AssuranceDAO assuranceDAO = new AssuranceDAO();
        // ClientDAO clientDAO = new ClientDAO();
        // EmployerDAO employerDAO = new EmployerDAO();
        // FactureDAO factureDAO = new FactureDAO();
        // LocationDAO locationDAO = new LocationDAO();
        // ParkingDAO parkingDAO = new ParkingDAO();
        // VehiculeDAO vehiculeDAO = new VehiculeDAO();

        // List<Agence> agences = reader.agencesReader();
        // List<Assurance> assurances = reader.assurancesReader();
        // List<Client> clients = reader.clientsReader();
        // List<Employer> employers = reader.employersReader();
        // List<Facture> factures = reader.facturesReader();
        // List<Location> locations = reader.locationsReader();
        // List<Parking> parkings = reader.parkingsReader();
        // List<Vehicule> vehicules = reader.vehiculesReader();
        /*
         * //creer des clients
         * Client client1 = new Client(6,"Jean","Dupont","1 rue du soleil","0123456789",
         * "jean.dupont@gmailcom");
         * Client client2 = new
         * Client(7,"Cou","Beh","2 rue du cul","0123456789","cou.beh@gmailcom");
         * 
         * //inserer clients
         * //clientDAO.insert(client1);
         * //clientDAO.insert(client2);
         * 
         * 
         * // Créer des documents Location associés à l'Agence 1
         * Location location1 = new
         * Location(8,1,1,1,1,"7/16/2023","7/9/2023",1,1,225.0);
         * Location location2 = new
         * Location(9,1,2,1,1,"7/18/2023","7/11/2023",1,1,223.0);
         * 
         * // inserer les locations
         * //locationDAO.insert(location1);
         * //locationDAO.insert(location2);
         * 
         * // Tester la fonction
         * //ArrayList<Agence> agencesTriees = agenceDAO.sortAgencesByNombreClientDec();
         * 
         * // Afficher le résultat
         * //for (Agence agenceTriee : agencesTriees) {
         * // System.out.println("Agence ID: " + agenceTriee.getId() +
         * ", Nombre de clients: " + agenceTriee.getNombreClients());
         * //}
         */

        // for (Agence agence : agences) {
        // agenceDAO.insert(agence);
        // }
        // for (Assurance assurance : assurances) {
        // assuranceDAO.insert(assurance);
        // }
        // for (Client client : clients) {
        // clientDAO.insert(client);
        // }
        // for (Employer employer : employers) {
        // employerDAO.insert(employer);
        // }
        // for (Facture facture : factures) {
        // factureDAO.insert(facture);
        // }
        // for (Location location : locations) {
        // locationDAO.insert(location);
        // }
        // for (Parking parking : parkings) {
        // parkingDAO.insert(parking);
        // }
        // for (Vehicule vehicule : vehicules) {
        // vehiculeDAO.insert(vehicule);
        // }

        /*
         * List<Employer> employers = employerDAO.getEmployersSortedByJob();
         * for (Employer employer : employers) {
         * System.out.println(employer.getData());
         * }
         */

        /*
         * //getAllAgence
         * List<Agence> _agences = agenceDAO.getAllAgence();
         * for (Agence agence : _agences) {
         * System.out.println(agence.getData());
         * }
         * 
         * //getAllAgenceByAlphabeticalOrder
         * List<Agence> _agences = agenceDAO.getAllAgenceByAlphabeticalOrder();
         * for (Agence agence : _agences) {
         * System.out.println(agence.getData());
         * }
         * 
         * //getAllAgenceByNbEmploye
         * List<Agence> _agences = agenceDAO.getAllAgenceByNbEmploye();
         * for (Agence agence : _agences) {
         * System.out.println(agence.getData());
         * }
         * 
         * //getAllAgenceByNbClient
         * List<Agence> _agences = agenceDAO.getAllAgenceByNbClient();
         * for (Agence agence : _agences) {
         * System.out.println(agence.getData());
         * }
         * 
         * //getAgenceById
         * //teste avec id = 1
         * Agence _test = agenceDAO.getAgenceById(1);
         * System.out.println(_test.getData());
         * 
         * 
         * //getAllAssurance
         * List<Assurance> _assurances = assuranceDAO.getAllAssurance();
         * for (Assurance assurance : _assurances) {
         * System.out.println(assurance.getData());
         * }
         * 
         * //getAllAssuranceAlpha
         * List<Assurance> _assurances = assuranceDAO.getAllAssuranceAlpha();
         * for (Assurance assurance : _assurances) {
         * System.out.println(assurance.getData());
         * }
         * 
         * //getAssuPrixCroissant
         * List<Assurance> _assurances = assuranceDAO.getAssuPrixCroissant();
         * for (Assurance assurance : _assurances) {
         * System.out.println(assurance.getData());
         * }
         * 
         * //getAssuByType
         * List<Assurance> _assurances = assuranceDAO.getAssuByType("full");
         * for (Assurance assurance : _assurances) {
         * System.out.println(assurance.getData());
         * }
         * 
         * //getAssuById
         * //teste avec id = 1
         * Assurance _assu = assuranceDAO.getAssuById(1);
         * System.out.println(_assu.getData());
         * 
         * 
         * 
         * //getAllVehicule
         * List<Vehicule> _vehicules = vehiculeDAO.getAllVehicule();
         * for (Vehicule vehicule : _vehicules) {
         * System.out.println(vehicule.getData());
         * }
         * 
         * 
         * //getVehiculeByModel
         * List<Vehicule> _vehicules = vehiculeDAO.getVehiculeByModel("M5");
         * for (Vehicule vehicule : _vehicules) {
         * System.out.println(vehicule.getData());
         * }
         * 
         * //getVehiculeByMarque
         * List<Vehicule> _vehicules = vehiculeDAO.getVehiculeByMarque("BMW");
         * for (Vehicule vehicule : _vehicules) {
         * System.out.println(vehicule.getData());
         * }
         * 
         * //getVehiculeByAgence
         * List<Vehicule> _vehicules = vehiculeDAO.getVehiculeByAgence(1);
         * for (Vehicule vehicule : _vehicules) {
         * System.out.println(vehicule.getData());
         * }
         * 
         * //getVehiculeByImat
         * Vehicule _vehicule = vehiculeDAO.getVehiculeByImat("JM1NC2EF4A0974457");
         * System.out.println(_vehicule.getData());
         * 
         * //getAllParking
         * List<Parking> _parkings = parkingDAO.getAllParking();
         * for (Parking parking : _parkings) {
         * System.out.println(parking.getData());
         * }
         * 
         * //getParkingByAgence
         * List<Parking> _parkings = parkingDAO.getParkingByAgence(1);
         * for (Parking parking : _parkings) {
         * System.out.println(parking.getData());
         * }
         * 
         * //getParkingByVehicule
         * List<Parking> _parkings = parkingDAO.getParkingByVehicule(1);
         * for (Parking parking : _parkings) {
         * System.out.println(parking.getData());
         * }
         * 
         * //getParkingsWithAvailablePlaces
         * List<Parking> _parkings = parkingDAO.getParkingsWithAvailablePlaces();
         * for (Parking parking : _parkings) {
         * System.out.println(parking.getData());
         * }
         * 
         * //getParkingsWithAvailablePlacesByAgence
         * List<Parking> _parkings =
         * parkingDAO.getParkingsWithAvailablePlacesByAgence(1);
         * for (Parking parking : _parkings) {
         * System.out.println(parking.getData());
         * }
         * 
         * //getAllLocations
         * List<Location> _locations = locationDAO.getAllLocations();
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getLocationsByClient
         * List<Location> _locations = locationDAO.getLocationsByClient(1);
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getLocationsByVehicule
         * List<Location> _locations = locationDAO.getLocationsByVehicule(1);
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getLocationsByAgence
         * List<Location> _locations = locationDAO.getLocationsByAgence(1);
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getLocationsByEmploye
         * List<Location> _locations = locationDAO.getLocationsByEmploye(1);
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getLocationSortedByPrice
         * List<Location> _locations = locationDAO.getLocationSortedByPrice();
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getLocationSortedByDate
         * List<Location> _locations = locationDAO.getLocationSortedByDate();
         * for (Location location : _locations) {
         * System.out.println(location.getData());
         * }
         * 
         * //getAllFactures
         * List<Facture> _factures = factureDAO.getAllFactures();
         * for (Facture facture : _factures) {
         * System.out.println(facture.getData());
         * }
         * 
         * //getFactureByLocation
         * List<Facture> _factures = factureDAO.getFactureByLocation(1);
         * for (Facture facture : _factures) {
         * System.out.println(facture.getData());
         * }
         * 
         * //getFactureById
         * List<Facture> _factures = factureDAO.getFactureById(1);
         * for (Facture facture : _factures) {
         * System.out.println(facture.getData());
         * }
         * 
         * //getFacturesSortedByPrices
         * List<Facture> _factures = factureDAO.getFacturesSortedByPrices();
         * for (Facture facture : _factures) {
         * System.out.println(facture.getData());
         * }
         * 
         * //getFacturesByDate
         * List<Facture> _factures = factureDAO.getFacturesByDate("7/16/2023");
         * for (Facture facture : _factures) {
         * System.out.println(facture.getData());
         * }
         * 
         * //getFacturesByDateAndAgence
         * List<Facture> _factures =
         * factureDAO.getFacturesByDateAndAgence("7/16/2023",1);
         * for (Facture facture : _factures) {
         * System.out.println(facture.getData());
         * }
         * 
         * //getAllEmployer
         * List<Employer> _employers = employerDAO.getAllEmployer();
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployerById
         * List<Employer> _employers = employerDAO.getEmployerById(1);
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployerByJob
         * List<Employer> _employers = employerDAO.getEmployerByJob("chef");
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployersSortedByJob
         * List<Employer> _employers = employerDAO.getEmployersSortedByJob();
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployerByAgence
         * List<Employer> _employers = employerDAO.getEmployerByAgence(1);
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployerByAgenceAndJob
         * List<Employer> _employers = employerDAO.getEmployerByAgenceAndJob(1,"chef");
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployersSortedByAgence
         * List<Employer> _employers = employerDAO.getEmployersSortedByAgence();
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployersSortedByNom
         * List<Employer> _employers = employerDAO.getEmployersSortedByNom();
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getEmployersSortedByPrenom
         * List<Employer> _employers = employerDAO.getEmployersSortedByPrenom();
         * for (Employer employer : _employers) {
         * System.out.println(employer.getData());
         * }
         * 
         * //getAllClient
         * List<Client> _clients = clientDAO.getAllClient();
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         * //getClientById
         * List<Client> _clients = clientDAO.getClientById(1);
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         * //getClientByNom
         * List<Client> _clients = clientDAO.getClientByNom("Jean");
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         * //getClientSortedByEmail
         * List<Client> _clients = clientDAO.getClientSortedByEmail();
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         * //getClientSortedByNom
         * List<Client> _clients = clientDAO.getClientSortedByNom();
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         * //getClientSortedByPrenom
         * List<Client> _clients = clientDAO.getClientSortedByPrenom();
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         * //getClientSortedByAdresse
         * List<Client> _clients = clientDAO.getClientSortedByAdresse();
         * for (Client client : _clients) {
         * System.out.println(client.getData());
         * }
         * 
         */

    }

}