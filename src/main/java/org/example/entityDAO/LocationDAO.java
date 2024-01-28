package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Assurance;
import org.example.entity.Location;
import org.example.entity.Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LocationDAO extends BaseDAO{

    public List<Location> getAllLocations(){
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");
        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            locations.add(location);
        }

        return locations;
    }

    public List<Location> getLocationsByClient(int idClient){
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if(location.getIdClient() == idClient){
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationsByVehicule(int idVehicule){
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if(location.getIdVehicule() == idVehicule){
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationsByAgence(int idAgence){
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if(location.getIdAgence() == idAgence){
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationsByEmploye(int idEmploye){
        ViewQuery query = new ViewQuery().designDocId("_design/Location").viewName("_location");

        ViewResult result = db.queryView(query);

        List<Location> locations = new ArrayList<Location>();

        for (ViewResult.Row row : result.getRows()) {
            Location location = db.get(Location.class, row.getId());
            if(location.getIdEmploye() == idEmploye){
                locations.add(location);
            }
        }

        return locations;

    }

    public List<Location> getLocationSortedByPrice(){
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

    public List<Location> getLocationSortedByDate(){
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
}
