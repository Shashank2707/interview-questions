package com.test.lld.question.elevatordesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.test.lld.question.elevatordesign.button.dispatcher.ExternalButtonDispatcher;
import com.test.lld.question.elevatordesign.enums.Direction;
import com.test.lld.question.elevatordesign.enums.ElevatorState;

public class ElevatorController {

	//using LOOK algorithm to implement elevator
//    PriorityQueue<Integer> upMinPQ;
//    PriorityQueue<Integer> downMaxPQ;
//	private ElevatorCar elevatorCar;
//    
//    public ElevatorController(ElevatorCar elevatorCar) {
//    	this.elevatorCar = elevatorCar;
//        upMinPQ = new PriorityQueue<>();
//        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);
//
//	}
//    
//    public void submitExternalRequest(int floor, Direction direction){
//
//        if(direction == Direction.DOWN) {
//            downMaxPQ.offer(floor);
//        } else {
//            upMinPQ.offer(floor);
//        }
//     }
//
//    public void submitInternalRequest(int floor){
//
//    }
//
//    public ElevatorCar getElevatorCar() {
//		return elevatorCar;
//	}
//
//	public void setElevatorCar(ElevatorCar elevatorCar) {
//		this.elevatorCar = elevatorCar;
//	}
//
//	public void controlElevator(){
//        while(true) {
//
//            if(elevatorCar.getElevatorDirecton() == Direction.UP){
//
//
//            }
//        }
//    }
	
	
	
    private final ElevatorCar car;
    private final PriorityQueue<Integer> upQueue;
    private final PriorityQueue<Integer> downQueue;
    private final Queue<Integer> pendingJobs;

    public ElevatorController(int id) {
        this.car = new ElevatorCar(id, this);
        this.upQueue = new PriorityQueue<>();
        this.downQueue = new PriorityQueue<>(Collections.reverseOrder());
        ExternalButtonDispatcher.getInstance().registerElevator(this);
        pendingJobs = new LinkedList<Integer>();
    }
    
    // Handles both internal and external requests
    public void acceptNewRequest(int floor, Direction direction) {
        if (direction == Direction.UP) {
            upQueue.offer(floor);
        } else {
            downQueue.offer(floor);
        }
        processRequests();
    }
    
    // Internal requests do not need a direction
    public void acceptInternalRequest(int floor) {
        if (floor > car.getCurrentFloor()) {
            upQueue.offer(floor);
        } else if (floor < car.getCurrentFloor()) {
            downQueue.offer(floor);
        }
        processRequests();
    }

    // Estimate distance (for optimal elevator selection)
    public int estimateDistance(int floor, Direction direction) {
        if (car.getElevatorState() == ElevatorState.IDLE) {
            return Math.abs(car.getCurrentFloor() - floor);
        }
        return Integer.MAX_VALUE; // Moving elevators are less preferred
    }

//    private void processRequests() {
//        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
//            if (car.getDirection() == Direction.UP) {
//                if (!upQueue.isEmpty()) {
//                    car.move(upQueue.poll());
//                } else if (!downQueue.isEmpty()) {
//                    car.setDirection(Direction.DOWN);
//                }
//            } else if (car.getDirection() == Direction.DOWN) {
//                if (!downQueue.isEmpty()) {
//                    car.move(downQueue.poll());
//                } else if (!upQueue.isEmpty()) {
//                    car.setDirection(Direction.UP);
//                }
//            }
//        }
//        car.stop();
//        car.setElevatorState(ElevatorState.IDLE); // Reset direction
//    }
    
    private void processRequests() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty() || !pendingJobs.isEmpty()) {
            if (car.getDirection() == Direction.UP) {
                processUpQueue();
                if (downQueue.isEmpty() && !pendingJobs.isEmpty()) {
                    switchToDownDirection();
                }
            } else if (car.getDirection() == Direction.DOWN) {
                processDownQueue();
                if (upQueue.isEmpty() && !pendingJobs.isEmpty()) {
                    switchToUpDirection();
                }
            }
        }
        car.stop();
        car.setElevatorState(ElevatorState.IDLE);
    }

    public ElevatorCar getCar() {
        return car;
    }
    
    
    private void processUpQueue() {
        while (!upQueue.isEmpty()) {
            int nextFloor = upQueue.poll();
            car.move(nextFloor);
        }
        if (!downQueue.isEmpty()) {
            car.setDirection(Direction.DOWN);
        } else {
            car.setElevatorState(ElevatorState.IDLE);
        }
    }

    private void processDownQueue() {
        while (!downQueue.isEmpty()) {
            int nextFloor = downQueue.poll();
            car.move(nextFloor);
        }
        if (!upQueue.isEmpty()) {
            car.setDirection(Direction.UP);
        } else {
        	car.setElevatorState(ElevatorState.IDLE);
        }
    }

    private void switchToUpDirection() {
        while (!pendingJobs.isEmpty()) {
            upQueue.offer(pendingJobs.poll());
        }
        car.setDirection(Direction.UP);
    }

    private void switchToDownDirection() {
        while (!pendingJobs.isEmpty()) {
            downQueue.offer(pendingJobs.poll());
        }
        car.setDirection(Direction.DOWN);
    }

}
