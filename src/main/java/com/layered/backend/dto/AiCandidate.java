package com.layered.backend.dto;

public class AiCandidate {

    private String itemId;
    private String name;
    private String brand;
    private Double score;
    private String note;

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}