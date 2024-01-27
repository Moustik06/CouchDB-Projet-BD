package org.example;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ektorp.CouchDbConnector;

import org.ektorp.CouchDbInstance;

import org.ektorp.DocumentNotFoundException;
import org.ektorp.http.HttpClient;

import org.ektorp.http.StdHttpClient;

import org.ektorp.impl.StdCouchDbConnector;

import org.ektorp.impl.StdCouchDbInstance;

import org.ektorp.impl.StdObjectMapperFactory;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.DesignDocument;
import org.example.entity.Agence;
import org.example.entity.Assurance;
import org.example.entityDAO.AgenceDAO;
import org.example.entityDAO.BaseDAO;
import org.json.JSONObject;

public class CouchJava {

    public static void main(String[] args) throws MalformedURLException, JsonProcessingException {

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


        // getAgenceById
        //agenceDAO.getAgenceById(1).getData().forEach(System.out::println);

        // sortAgencesByNombreEmploye
        ArrayList<Agence> agences = agenceDAO.sortAgencesByNombreEmployeDec();
        for (Agence agence1 : agences) {
            agence1.getData().forEach(System.out::println);
        }
        BaseDAO.closeConnection();




    }

}