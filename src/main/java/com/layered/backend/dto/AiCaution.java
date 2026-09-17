package com.layered.backend.dto;

import java.util.List;

public class AiCaution {

    private List<String> pair;
    private String severity;
    private String message;
    private String source;
    private String confidence;

    public List<String> getPair() { return pair; }
    public void setPair(List<String> pair) { this.pair = pair; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getConfidence() { return confidence; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
}