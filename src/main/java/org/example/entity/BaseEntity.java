package org.example.entity;

import org.json.JSONObject;

public abstract class BaseEntity {

    // Méthode abstraite pour générer un document JSON
    abstract public JSONObject generateDocument();
}