package com.test.lld.question.carrentaldesign;

import java.util.List;

import com.test.lld.question.carrentaldesign.product.Vehicle;

public class VehicleInventoryManagement {

    private List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        //filtering
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
