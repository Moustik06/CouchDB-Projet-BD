package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientDAO extends BaseDAO{

    public List<Client> getAllClient() {
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            clients.add(client);
        }

        return clients;

    }

    public List<Client> getClientById(int id) {
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            if (Integer.parseInt(client.getId()) == id) {
                clients.add(client);
            }
        }

        return clients;

    }

    public List<Client> getClientByNom(String nom) {
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            if (client.getNom().equals(nom)) {
                clients.add(client);
            }
        }

        return clients;

    }

    public List<Client> getClientSortedByEmail(){
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            clients.add(client);
        }

        clients.sort(Comparator.comparing(Client::getEmail).reversed());

        return clients;
    }

    public List<Client> getClientSortedByNom(){
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            clients.add(client);
        }

        clients.sort(Comparator.comparing(Client::getNom).reversed());

        return clients;
    }

    public List<Client> getClientSortedByPrenom(){
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            clients.add(client);
        }

        clients.sort(Comparator.comparing(Client::getPrenom).reversed());

        return clients;
    }

    public List<Client> getClientSortedByAdresse(){
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            clients.add(client);
        }

        clients.sort(Comparator.comparing(Client::getAdresse).reversed());

        return clients;
    }
}
