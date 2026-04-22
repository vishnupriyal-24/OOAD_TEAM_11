package model;

public class ServicePrototype extends ServiceRequest implements Cloneable {

    public ServicePrototype(String type) {
        super(type);
    }

    public ServicePrototype clone() {
        return new ServicePrototype(this.getServiceType());
    }
}