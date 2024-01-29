package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Employer;
import org.example.entity.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployerDAO extends BaseDAO{

    public List<Employer> getAllEmployer() {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            employers.add(employer);
        }

        return employers;

    }

    public List<Employer> getEmployerById(int id) {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            if (Integer.parseInt(employer.getId()) == id) {
                employers.add(employer);
            }
        }

        return employers;

    }
    public List<Employer> getEmployerByJob(String emploi) {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            if (employer.getEmploi().equals(emploi)) {
                employers.add(employer);
            }
        }

        return employers;

    }

    public List<Employer> getEmployerByAgence(int idAgence) {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            if (employer.getIdAgence() == idAgence) {
                employers.add(employer);
            }
        }

        return employers;

    }

        public List<Employer> getEmployersSortedByJob() {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            employers.add(employer);
        }

        employers.sort(Comparator.comparing(Employer::getEmploi));

        return employers;

    }

    public List<Employer> getEmployersSortedByAgence() {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            employers.add(employer);
        }

        employers.sort(Comparator.comparing(Employer::getIdAgence));

        return employers;

    }

    public List<Employer> getEmployersSortedByNom() {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            employers.add(employer);
        }

        employers.sort(Comparator.comparing(Employer::getNom));

        return employers;

    }

    public List<Employer> getEmployersSortedByPrenom() {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            employers.add(employer);
        }

        employers.sort(Comparator.comparing(Employer::getPrenom));

        return employers;

    }



}
