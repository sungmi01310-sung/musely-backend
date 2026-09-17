package com.layered.backend.dto;

public class AiCreateJobResponse {

    private String jobId;
    private String status;

    public String getJobId() { return jobId; }
    public void setJobId(String jobId) { this.jobId = jobId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}