package com.test.lld.question.elevatordesign;

import com.test.lld.question.elevatordesign.button.InternalButton;
import com.test.lld.question.elevatordesign.enums.Direction;
import com.test.lld.question.elevatordesign.enums.ElevatorState;

public class ElevatorCar {
	
//	private int id;
//	
//	private ElevatorDisplay elevatorDisplay;
//	
//	private int currentFloor;
//	
//	private Direction elevatorDirection;
//	
//	private ElevatorState elevatorState;
//	
//	private InternalButton internalButton;
//	
//	public ElevatorCar()
//	{
//		elevatorDisplay = new ElevatorDisplay();
//		internalButton = new InternalButton();
//        setElevatorState(ElevatorState.IDLE);
//        setCurrentFloor(0);
//        setElevatorDirection(elevatorDirection.UP);
////        elevatorDoor = new ElevatorDoor();
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getCurrentFloor() {
//		return currentFloor;
//	}
//
//	public void setCurrentFloor(int currentFloor) {
//		this.currentFloor = currentFloor;
//	}
//
//	public Direction getElevatorDirecton() {
//		return elevatorDirection;
//	}
//
//	public void setElevatorDirection(Direction elevatorDirection) {
//		this.elevatorDirection = elevatorDirection;
//	}
//
//	public ElevatorState getElevatorState() {
//		return elevatorState;
//	}
//
//	public void setElevatorState(ElevatorState elevatorState) {
//		this.elevatorState = elevatorState;
//	}
//	
//	public void showElevatorDisplay()
//	{
//		elevatorDisplay.showDisplay();
//	}
//	
//	public void pressButton(int destination)
//	{
//		internalButton.pressButton(destination, this);
//	}
//	
//	public void setElevatorDisplay()
//	{
//		this.elevatorDisplay.setDirection(elevatorDirection);
//		this.elevatorDisplay.setFloorNo(currentFloor);
////		this.elevatorDisplay.setDisplay(currentFloor, elevatorDirection);
//	}
//	
//	public boolean moveElevator(int destinationFloor, Direction dir)
//	{
//		int startFloor = currentFloor;
//		
//		if(dir == Direction.UP)
//		{
//			for(int i = startFloor; i<=destinationFloor; i++) {
//
//                this.currentFloor = startFloor;
//                setElevatorDisplay();
//                showElevatorDisplay();
//                if(i == destinationFloor) {
//                    return true;
//                }
//            }
//
//		}
//		
//		if(dir == Direction.DOWN)
//		{
//			 for(int i = startFloor; i>=destinationFloor; i--) {
//
//	                this.currentFloor = startFloor;
//	                setElevatorDisplay();
//	                showElevatorDisplay();
//	                if(i == destinationFloor) {
//	                    return true;
//	                }
//	            }
//
//		}
//		return false;
//	}
	
	
	private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private final InternalButton internalButton;

    public ElevatorCar(int id, ElevatorController controller) {
        this.id = id;
        this.currentFloor = 1;
        this.direction = Direction.UP;
        this.elevatorState = ElevatorState.IDLE;
        this.internalButton = new InternalButton(controller);
    }
    
    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
         this.direction = dir;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }
    
    public void setElevatorState(ElevatorState state) {
        this.elevatorState = state;
    }

    public void move(int targetFloor) {
        System.out.println("Elevator " + id + " moving from " + currentFloor + " to " + targetFloor);
        this.currentFloor = targetFloor;
        this.elevatorState = ElevatorState.MOVING;
    }

    public void stop() {
        this.elevatorState = ElevatorState.IDLE;
        System.out.println("Elevator " + id + " is now IDLE at floor " + currentFloor);
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }
    
    public boolean isIdle()
    {
    	return this.elevatorState == ElevatorState.IDLE;
    }
    
    
}
