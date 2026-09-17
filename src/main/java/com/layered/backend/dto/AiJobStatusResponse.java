package com.layered.backend.dto;

import java.util.List;

public class AiJobStatusResponse {

    private String jobId;
    private String status;
    private List<Object> steps;
    private AiResult result;
    private AiError error;
    private Long elapsedMs;

    public static class AiResult {
        private String summary;
        private List<AiCandidate> cosmetic;
        private List<AiCandidate> fragrance;
        private List<AiCaution> cautions;
        private Integer relaxationLevel;
        private List<String> blockedBy;

        public String getSummary() { return summary; }
        public void setSummary(String summary) { this.summary = summary; }

        public List<AiCandidate> getCosmetic() { return cosmetic; }
        public void setCosmetic(List<AiCandidate> cosmetic) { this.cosmetic = cosmetic; }

        public List<AiCandidate> getFragrance() { return fragrance; }
        public void setFragrance(List<AiCandidate> fragrance) { this.fragrance = fragrance; }

        public List<AiCaution> getCautions() { return cautions; }
        public void setCautions(List<AiCaution> cautions) { this.cautions = cautions; }

        public Integer getRelaxationLevel() { return relaxationLevel; }
        public void setRelaxationLevel(Integer relaxationLevel) { this.relaxationLevel = relaxationLevel; }

        public List<String> getBlockedBy() { return blockedBy; }
        public void setBlockedBy(List<String> blockedBy) { this.blockedBy = blockedBy; }
    }

    public static class AiError {
        private String code;
        private String message;

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    public String getJobId() { return jobId; }
    public void setJobId(String jobId) { this.jobId = jobId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Object> getSteps() { return steps; }
    public void setSteps(List<Object> steps) { this.steps = steps; }

    public AiResult getResult() { return result; }
    public void setResult(AiResult result) { this.result = result; }

    public AiError getError() { return error; }
    public void setError(AiError error) { this.error = error; }

    public Long getElapsedMs() { return elapsedMs; }
    public void setElapsedMs(Long elapsedMs) { this.elapsedMs = elapsedMs; }
}