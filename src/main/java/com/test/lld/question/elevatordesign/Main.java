package com.test.lld.question.elevatordesign;

import java.util.ArrayList;
import java.util.List;

import com.test.lld.question.elevatordesign.enums.Direction;

public class Main {
	
    public static void main(String[] args) {
    	Building building = new Building(10);

        // Create 3 elevators
        ElevatorController elevator1 = new ElevatorController(1);
        ElevatorController elevator2 = new ElevatorController(2);
        ElevatorController elevator3 = new ElevatorController(3);

        // Simulate external requests (from floors)
        building.requestElevator(3, Direction.UP);
        building.requestElevator(7, Direction.DOWN);
        building.requestElevator(2, Direction.UP);

        // Simulate internal requests (inside elevator)
        elevator1.getCar().getInternalButton().pressButton(5);
        elevator2.getCar().getInternalButton().pressButton(9);
        elevator3.getCar().getInternalButton().pressButton(1);
    }

}
