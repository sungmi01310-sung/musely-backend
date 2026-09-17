package com.layered.backend.dto;

public class FragranceRequest {

    private String name;
    private String brand;
    private String noteFamily;
    private String topNotes;
    private String heartNotes;
    private String baseNotes;
    private String description;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getNoteFamily() { return noteFamily; }
    public void setNoteFamily(String noteFamily) { this.noteFamily = noteFamily; }

    public String getTopNotes() { return topNotes; }
    public void setTopNotes(String topNotes) { this.topNotes = topNotes; }

    public String getHeartNotes() { return heartNotes; }
    public void setHeartNotes(String heartNotes) { this.heartNotes = heartNotes; }

    public String getBaseNotes() { return baseNotes; }
    public void setBaseNotes(String baseNotes) { this.baseNotes = baseNotes; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}