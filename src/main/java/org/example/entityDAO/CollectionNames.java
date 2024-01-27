package org.example.entityDAO;

public enum CollectionNames {
    AGENCE("agences"),
    ASSURANCE("assurances"),
    CLIENT("clients"),
    EMPLOYE("employes"),
    FACTURE("factures"),
    LOCATION("locations"),
    PARKING("parkings"),
    VEHICULE("vehicules");

    private final String collectionName;

    CollectionNames(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return collectionName;
    }
}
