package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientDAO extends BaseDAO {

    // retourne les clients en fonction du critère
    public List<Client> getClientByCriteria(String criteria, String value) {
        ViewQuery query = new ViewQuery().designDocId("_design/Client").viewName("_client");

        ViewResult result = db.queryView(query);

        List<Client> clients = new ArrayList<Client>();

        for (ViewResult.Row row : result.getRows()) {
            Client client = db.get(Client.class, row.getId());
            if (criteria.equals("id")) {
                if (Integer.parseInt(client.getId()) == Integer.parseInt(value)) {
                    clients.add(client);
                }
            } else if (criteria.equals("nom")) {
                if (client.getNom().equals(value)) {
                    clients.add(client);
                }
            } else if (criteria.equals("prenom")) {
                if (client.getPrenom().equals(value)) {
                    clients.add(client);
                }
            } else if (criteria.equals("email")) {
                if (client.getEmail().equals(value)) {
                    clients.add(client);
                }
            } else if (criteria.equals("adresse")) {
                if (client.getAdresse().equals(value)) {
                    clients.add(client);
                }
            } else if (criteria.equals("telephone")) {
                if (client.getTelephone().equals(value)) {
                    clients.add(client);
                }
            }
        }

        return clients;

    }

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

    public List<Client> getClientSortedByEmail() {
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

    public List<Client> getClientSortedByNom() {
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

    public List<Client> getClientSortedByPrenom() {
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

    public List<Client> getClientSortedByAdresse() {
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
