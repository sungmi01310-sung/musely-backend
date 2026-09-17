package com.layered.backend.client;

import com.layered.backend.dto.AiCreateJobRequest;
import com.layered.backend.dto.AiCreateJobResponse;
import com.layered.backend.dto.AiJobStatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Component
public class AiCoreClient {

    private final WebClient webClient;

    public AiCoreClient(@Value("${ai-core.base-url}") String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public AiCreateJobResponse createJob(AiCreateJobRequest request) {
        return webClient.post()
                .uri("/jobs")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AiCreateJobResponse.class)
                .timeout(Duration.ofSeconds(30))
                .block();
    }

    public AiJobStatusResponse getJobStatus(String aiJobId) {
        return webClient.get()
                .uri("/jobs/{jobId}", aiJobId)
                .retrieve()
                .bodyToMono(AiJobStatusResponse.class)
                .timeout(Duration.ofSeconds(30))
                .block();
    }
}