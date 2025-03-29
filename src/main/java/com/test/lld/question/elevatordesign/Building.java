package com.test.lld.question.elevatordesign;

import java.util.ArrayList;
import java.util.List;

import com.test.lld.question.elevatordesign.enums.Direction;

public class Building {

	private final List<Floor> floorList;

    public Building(int numberOfFloors){
        floorList = new ArrayList<>();
       
        for (int i = 1; i <= numberOfFloors; i++) {
        	floorList.add(new Floor(i));
        }
    }
    
    public List<Floor> getFloor()
    {
    	return this.floorList;
    }
    
    public void requestElevator(int floor, Direction direction) {
        floorList.get(floor - 1).getExternalButton().submitRequestToGo(floor, direction);
    }

    public void addFloors(Floor newFloor){
        floorList.add(newFloor);
    }

    public void removeFloors(Floor removeFloor){
        floorList.remove(removeFloor);
    }

    List<Floor> getAllFloorList(){
        return floorList;
    }

	
}
