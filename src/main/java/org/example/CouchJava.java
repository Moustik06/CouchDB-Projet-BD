package org.example;

import java.net.MalformedURLException;
import java.util.List;

import org.ektorp.CouchDbConnector;

import org.ektorp.CouchDbInstance;

import org.ektorp.DocumentNotFoundException;
import org.ektorp.http.HttpClient;

import org.ektorp.http.StdHttpClient;

import org.ektorp.impl.StdCouchDbConnector;

import org.ektorp.impl.StdCouchDbInstance;

import org.ektorp.support.DesignDocument;
import org.example.enitty.Agence;
import org.example.entityDAO.AgenceDAO;

public class CouchJava {

    public static void main(String[] args) throws MalformedURLException {
        CouchDbConnector db = Connector.connect();

        int id = 1;

        Agence agence = new Agence();
        /*

        // POUR CREATE
        agence.setNom("Agence1");
        agence.setAdresse("Adresse1");
        db.create(String.valueOf(id),agence);
        */

        // POUR LIRE
        try {
            Agence retrievedAgence = db.get(Agence.class, String.valueOf(id));
            System.out.println("Agence lue depuis la base de données : " + retrievedAgence.toString());
        } catch (DocumentNotFoundException e) {
            System.out.println("Le document avec l'ID " + id + " n'a pas été trouvé dans la base de données.");
        }


    }

}