package com.layered.backend.dto;

public class CompleteJobRequest {

    private String summary;
    private String itemsJson;
    private String cautionsJson;

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getItemsJson() { return itemsJson; }
    public void setItemsJson(String itemsJson) { this.itemsJson = itemsJson; }

    public String getCautionsJson() { return cautionsJson; }
    public void setCautionsJson(String cautionsJson) { this.cautionsJson = cautionsJson; }
}