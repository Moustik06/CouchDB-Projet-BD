package org.example.Reader;

import org.example.entity.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    protected static int id = 1;

    public List<Agence> agencesReader() throws IOException {
        String file = "src/main/resources/AgenceData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Agence> agenceList = new ArrayList<>();

        // Iterate through the array and extract Agence objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonAgence = jsonArray.getJSONObject(i);

            //{"_id":1,"_id_employer":"[1,2,5,7,4,9]","_id_parking":1,"nom":"Marie-noël","adresse":"Apt 919","telephone":"9524496346"}

            String id_employer = jsonAgence.getString("_id_employer");
            int id_parking = jsonAgence.getInt("_id_parking");
            String nom = jsonAgence.getString("nom");
            String adresse = jsonAgence.getString("adresse");
            String telephone = jsonAgence.getString("telephone");

            //convert id_employer to ArrayList<Integer>
            id_employer = id_employer.substring(1, id_employer.length()-1);
            String[] id_employerArray = id_employer.split(",");
            ArrayList<Integer> id_employerList = new ArrayList<>();
            for (String s : id_employerArray) {
                id_employerList.add(Integer.parseInt(s.trim()));
            }


            // Create Agence object and add to the list
            Agence agence = new Agence(id, id_employerList, id_parking, nom, adresse, telephone);
            id++;
            agenceList.add(agence);
        }

        return agenceList;
    }

    public List<Assurance> assurancesReader() throws IOException {
        String file = "src/main/resources/AssuranceData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Assurance> assuranceList = new ArrayList<>();

        // Iterate through the array and extract Assurance objects

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonAssurance = jsonArray.getJSONObject(i);

            //[{"_id":1,"_id_vehicule":1,"type":"tier","nom_assurance":"Waelchi Inc","prix_assurance":155.7},
            int id_vehicule = jsonAssurance.getInt("_id_vehicule");
            String type = jsonAssurance.getString("type");
            String nom_assurance = jsonAssurance.getString("nom_assurance");
            double prix_assurance = jsonAssurance.getDouble("prix_assurance");

            // Create Assurance object and add to the list
            Assurance assurance = new Assurance(id,id_vehicule,type,nom_assurance,prix_assurance);
            id++;
            assuranceList.add(assurance);

         }
        return assuranceList;

    }

    public List<Client> clientsReader() throws IOException {
        String file = "src/main/resources/ClientData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Client> clientList = new ArrayList<>();

        // Iterate through the array and extract Client objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonClient = jsonArray.getJSONObject(i);

            //{"_id":1,"nom":"De Zuani","prenom":"Josée","adresse":"12th Floor","telephone":"3662217370","email":"edezuani0@flavors.me"},
            String nom = jsonClient.getString("nom");
            String prenom = jsonClient.getString("prenom");
            String adresse = jsonClient.getString("adresse");
            String telephone = jsonClient.getString("telephone");
            String email = jsonClient.getString("email");

            // Create Client object and add to the list
            Client client = new Client(id,nom,prenom,adresse,telephone,email);
            id++;
            clientList.add(client);

        }

        return clientList;
    }

    public List<Employer> employersReader() throws IOException{
        String file = "src/main/resources/EmployerData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Employer> employerList = new ArrayList<>();

        // Iterate through the array and extract Employer objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonEmployer = jsonArray.getJSONObject(i);

            //[{"_id":1,"_id_agence":1,"nom":"Ovenden","prenom":"Måns","adresse":"Apt 1229","telephone":"5492994392","emploi":"chef"},
            int id_agence = jsonEmployer.getInt("_id_agence");
            String nom = jsonEmployer.getString("nom");
            String prenom = jsonEmployer.getString("prenom");
            String adresse = jsonEmployer.getString("adresse");
            String telephone = jsonEmployer.getString("telephone");
            String emploi = jsonEmployer.getString("emploi");

            // Create Employer object and add to the list
            Employer employer = new Employer(id,id_agence,nom,prenom,adresse,telephone,emploi);
            id++;
            employerList.add(employer);

    }
        return employerList;
    }

    public List<Facture> facturesReader() throws IOException{
        String file = "src/main/resources/FactureData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Facture> factureList = new ArrayList<>();

        // Iterate through the array and extract Facture objects
        for (int i =0; i < jsonArray.length(); i++){
            JSONObject jsonFacture = jsonArray.getJSONObject(i);

            //[{"_id":1,"_idLocation":1,"date":"5/24/2023","totalTTC":427.4,"acquitte":true},
            int idLocation = jsonFacture.getInt("_idLocation");
            String date = jsonFacture.getString("date");
            double totalTTC = jsonFacture.getDouble("totalTTC");
            boolean acquitte = jsonFacture.getBoolean("acquitte");

            // Create Facture object and add to the list
            Facture facture = new Facture(id,idLocation,date,totalTTC,acquitte);
            id++;
            factureList.add(facture);
        }

        return factureList;
    }

    public List<Location> locationsReader() throws IOException{
        String file = "src/main/resources/LocationData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Location> locationList = new ArrayList<>();

        // Iterate through the array and extract Location objects
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonLocation = jsonArray.getJSONObject(i);

            //[{"_id":1,"_id_client":1,"_id_vehicule":1,"_id_agence":1,"id_employer":1,"id_parkingRecup":1,"_id_parkingRendu":1,"date_debut":"7/16/2023","date_fin":"7/9/2023","prix_ttc":225.0},
            int id_client = jsonLocation.getInt("_id_client");
            int id_vehicule = jsonLocation.getInt("_id_vehicule");
            int id_agence = jsonLocation.getInt("_id_agence");
            int id_employer = jsonLocation.getInt("id_employer");
            int id_parkingRecup = jsonLocation.getInt("id_parkingRecup");
            int id_parkingRendu = jsonLocation.getInt("_id_parkingRendu");
            String date_debut = jsonLocation.getString("date_debut");
            String date_fin = jsonLocation.getString("date_fin");
            double prix_ttc = jsonLocation.getDouble("prix_ttc");

            // Create Location object and add to the list
            Location location = new Location(id,id_client,id_vehicule,id_agence,id_employer,date_debut,date_fin,id_parkingRecup,id_parkingRendu,prix_ttc);
            id++;
            locationList.add(location);
        }

        return locationList;
    }

    public List<Parking> parkingsReader() throws IOException{
        String file = "src/main/resources/ParkingData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Parking> parkingList = new ArrayList<>();

        // Iterate through the array and extract Parking objects
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonParking = jsonArray.getJSONObject(i);

            //[{"_id":1,"_idVehicule":1,"_idAgence":1,"nbPlace":1,"nbDispo":1},
            int idVehicule = jsonParking.getInt("_idVehicule");
            int idAgence = jsonParking.getInt("_idAgence");
            int nbPlace = jsonParking.getInt("nbPlace");
            int nbDispo = jsonParking.getInt("nbDispo");

            // Create Parking object and add to the list
            Parking parking = new Parking(id,idVehicule,idAgence,nbPlace,nbDispo);
            id++;
            parkingList.add(parking);
        }

        return parkingList;
    }

    public List<Vehicule> vehiculesReader() throws IOException{
        String file = "src/main/resources/VehiculeData.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        // Create a JSONArray from the JSON string
        JSONArray jsonArray = new JSONArray(json);

        List<Vehicule> vehiculeList = new ArrayList<>();

        // Iterate through the array and extract Vehicule objects
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonVehicule = jsonArray.getJSONObject(i);

            //[{"_id":1,"_id_agence":1,"marque":"Suzuki","modele":"Grand Vitara","prix":174.43,"caution":459.19,"plaque_imat":"WAUJFAFH7BN867243"},

            int id_agence = jsonVehicule.getInt("_id_agence");
            String marque = jsonVehicule.getString("marque");
            String modele = jsonVehicule.getString("modele");
            double prix = jsonVehicule.getDouble("prix");
            double caution = jsonVehicule.getDouble("caution");
            String plaque_imat = jsonVehicule.getString("plaque_imat");

            // Create Vehicule object and add to the list
            Vehicule vehicule = new Vehicule(id,id_agence,marque,modele,prix,caution,plaque_imat);
            id++;
            vehiculeList.add(vehicule);

        }

        return vehiculeList;
    }
}
