package model;

public class ServiceBuilder {
    private String type;
    private String status;

    public ServiceBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ServiceBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public ServiceRequest build() {
        ServiceRequest req = new ServiceRequest(type);
        req.setStatus(status);
        return req;
    }
}