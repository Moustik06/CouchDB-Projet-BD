package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingDAO extends BaseDAO {

    public List<Parking> getAllParking() {
        ViewQuery query = new ViewQuery().designDocId("_design/Parking").viewName("_parking");
        ViewResult result = db.queryView(query);

        List<Parking> parkings = new ArrayList<Parking>();

        for (ViewResult.Row row : result.getRows()) {
            Parking parking = db.get(Parking.class, row.getId());
            parkings.add(parking);
        }

        return parkings;
    }

    public List<Parking> getParkingByAgence(int idAgence) {
        ViewQuery query = new ViewQuery().designDocId("_design/Parking").viewName("_parking");

        ViewResult result = db.queryView(query);

        List<Parking> parkings = new ArrayList<Parking>();

        for (ViewResult.Row row : result.getRows()) {
            Parking parking = db.get(Parking.class, row.getId());
            if (parking.getIdAgence() == idAgence) {
                parkings.add(parking);
            }
        }

        return parkings;

    }

    public List<Parking> getParkingByVehicule(int idVehicule) {
        ViewQuery query = new ViewQuery().designDocId("_design/Parking").viewName("_parking");

        ViewResult result = db.queryView(query);

        List<Parking> parkings = new ArrayList<Parking>();

        for (ViewResult.Row row : result.getRows()) {
            Parking parking = db.get(Parking.class, row.getId());
            if (parking.getIdVehicule() == idVehicule) {
                parkings.add(parking);
            }
        }

        return parkings;

    }

    public List<Parking> getParkingsWithAvailablePlaces() {
        ViewQuery query = new ViewQuery().designDocId("_design/Parking").viewName("_parking");

        ViewResult result = db.queryView(query);

        List<Parking> parkings = new ArrayList<Parking>();

        for (ViewResult.Row row : result.getRows()) {
            Parking parking = db.get(Parking.class, row.getId());
            if (parking.getNombrePlaceDispo() > 0) {
                parkings.add(parking);
            }
        }

        return parkings;

    }

    public List<Parking> getParkingsWithAvailablePlacesByAgence(int idAgence) {
        ViewQuery query = new ViewQuery().designDocId("_design/Parking").viewName("_parking");

        ViewResult result = db.queryView(query);

        List<Parking> parkings = new ArrayList<Parking>();

        for (ViewResult.Row row : result.getRows()) {
            Parking parking = db.get(Parking.class, row.getId());
            if (parking.getNombrePlaceDispo() > 0 && parking.getIdAgence() == idAgence) {
                parkings.add(parking);
            }
        }

        return parkings;

    }
}
