package service;

import model.ServiceRequest;

public class ServiceFactory {
    public static ServiceRequest createService(String type) {
        return new ServiceRequest(type);
    }
}