package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Employer;
import org.example.entity.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployerDAO extends BaseDAO {

    // retourne les employés en fonction du critère
    public List<Employer> getEmployerByCriteria(String criteria) {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            if (criteria.equals("id")) {
                if (Integer.parseInt(employer.getId()) == Integer.parseInt(criteria)) {
                    employers.add(employer);
                }
            } else if (criteria.equals("nom")) {
                if (employer.getNom().equals(criteria)) {
                    employers.add(employer);
                }
            } else if (criteria.equals("prenom")) {
                if (employer.getPrenom().equals(criteria)) {
                    employers.add(employer);
                }
            } else if (criteria.equals("job")) {
                if (employer.getJob().equals(criteria)) {
                    employers.add(employer);
                }
            } else if (criteria.equals("idAgence")) {
                if (employer.getIdAgence() == Integer.parseInt(criteria)) {
                    employers.add(employer);
                }
            } else if (criteria.equals("location")) {
                if (employer.getAdresse().equals(criteria)) {
                    employers.add(employer);
                }
            }
        }

        return employers;

    }

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

    public List<Employer> getEmployerByJob(String job) {
        ViewQuery query = new ViewQuery().designDocId("_design/Employer").viewName("_employer");

        ViewResult result = db.queryView(query);

        List<Employer> employers = new ArrayList<Employer>();

        for (ViewResult.Row row : result.getRows()) {
            Employer employer = db.get(Employer.class, row.getId());
            if (employer.getJob().equals(job)) {
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

        employers.sort(Comparator.comparing(Employer::getJob));

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
