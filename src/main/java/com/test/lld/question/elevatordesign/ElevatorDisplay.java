package com.test.lld.question.elevatordesign;

import com.test.lld.question.elevatordesign.enums.Direction;

public class ElevatorDisplay {

	private int floorNo;
	
	private Direction dir;
	
	public int getFloorNo() {
		return floorNo;
	}
	
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}
	
    public void showDisplay(){
        System.out.println(floorNo);
        System.out.println(dir);
    }
	
}
