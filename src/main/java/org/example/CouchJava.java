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
        Assurance assurance = new Assurance(2,1,"Assurance","Assurance du Soleil",100.0);

        agenceDAO.insert(assurance);



        BaseDAO.closeConnection();




    }

}