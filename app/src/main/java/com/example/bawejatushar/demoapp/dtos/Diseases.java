package com.example.bawejatushar.demoapp.dtos;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class Diseases {
    private int id;
    private String disease;
    private String cure;
    private String history;
    private String symptoms;
    private String causes;

    public Diseases() {
    }

    public Diseases(int id, String disease, String cure, String history, String symptoms, String causes) {
        this.id = id;
        this.disease = disease;
        this.cure = cure;
        this.history = history;
        this.symptoms = symptoms;
        this.causes = causes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getCure() {
        return cure;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }
}
