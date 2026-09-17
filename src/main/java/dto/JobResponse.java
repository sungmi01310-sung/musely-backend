package com.layered.backend.dto;

public class JobResponse {

    private Long jobId;
    private String status;

    public JobResponse(Long jobId, String status) {
        this.jobId = jobId;
        this.status = status;
    }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}