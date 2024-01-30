package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Assurance;
import org.example.entity.Location;
import org.example.entity.Parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LocationDAO extends BaseDAO {

    // retourne les locations en fonction du critère
    public List<Location> getLocationByCriteria(String criteria, String value) {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if (criteria.equals("idClient")) {
                if (location.getIdClient() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("idVehicule")) {
                if (location.getIdVehicule() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("idAgence")) {
                if (location.getIdAgence() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("idEmploye")) {
                if (location.getIdEmploye() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("dateDebut")) {
                if (location.getDateDebut().equals(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("dateFin")) {
                if (location.getDateFin().equals(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("prixTTC")) {
                if (location.getPrixTTC() == Double.parseDouble(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("idParkingRecup")) {
                if (location.getIdParkingRecup() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("idParkingRendu")) {
                if (location.getIdParkingRendu() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            } else if (criteria.equals("id")) {
                if (location.get_id() == Integer.parseInt(value)) {
                    locations.add(location);
                }
            }
        }

        return locations;
    }

    public List<Location> getAllLocations() {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");
        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            locations.add(location);
        }

        return locations;
    }

    public List<Location> getLocationsByClient(int idClient) {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if (location.getIdClient() == idClient) {
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationsByVehicule(int idVehicule) {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if (location.getIdVehicule() == idVehicule) {
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationsByAgence(int idAgence) {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if (location.getIdAgence() == idAgence) {
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationsByEmploye(int idEmploye) {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if (location.getIdEmploye() == idEmploye) {
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationSortedByPrice() {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            locations.add(location);
        }

        locations.sort(Comparator.comparingDouble(Location::getPrixTTC).reversed());

        return locations;
    }

    public List<Location> getLocationSortedByDate() {
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            locations.add(location);
        }

        locations.sort((o1, o2) -> Integer.compare(o1.getDateDebut().compareTo(o2.getDateDebut()), 0));

        return locations;
    }

    public List<Location> findLocationsByAgencyWithPriceAbove(int idAgence, double minPrice) {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Location")
                .viewName("byAgencyAndPrice")
                .startKey(Arrays.asList(idAgence, minPrice))
                .endKey(Arrays.asList(idAgence, Double.MAX_VALUE));

        List<Location> filteredLocations = new ArrayList<>();
        ViewResult result = db.queryView(query);

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if (location.getPrixTTC() > minPrice && location.getIdAgence() == idAgence) {
                filteredLocations.add(location);
            }
        }

        return filteredLocations;
    }
}
