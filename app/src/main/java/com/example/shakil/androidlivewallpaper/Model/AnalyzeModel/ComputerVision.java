package com.example.shakil.androidlivewallpaper.Model.AnalyzeModel;

/**
 * Created by Shakil on 3/21/2018.
 */

public class ComputerVision {
    private Adult adult;
    private String requestId;
    private Metadata metadata;

    public ComputerVision() {
    }

    public ComputerVision(Adult adult, String requestId, Metadata metadata) {
        this.adult = adult;
        this.requestId = requestId;
        this.metadata = metadata;
    }

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
