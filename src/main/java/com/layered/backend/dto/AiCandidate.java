package com.layered.backend.dto;

public class AiCandidate {

    private String itemId;
    private String name;
    private String brand;
    private String category;
    private Double score;
    private String note;
    private FragranceNotes notes;

    public static class FragranceNotes {
        private String family;
        private java.util.List<String> top;
        private java.util.List<String> heart;
        private java.util.List<String> base;

        public String getFamily() { return family; }
        public void setFamily(String family) { this.family = family; }

        public java.util.List<String> getTop() { return top; }
        public void setTop(java.util.List<String> top) { this.top = top; }

        public java.util.List<String> getHeart() { return heart; }
        public void setHeart(java.util.List<String> heart) { this.heart = heart; }

        public java.util.List<String> getBase() { return base; }
        public void setBase(java.util.List<String> base) { this.base = base; }
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public FragranceNotes getNotes() { return notes; }
    public void setNotes(FragranceNotes notes) { this.notes = notes; }
}