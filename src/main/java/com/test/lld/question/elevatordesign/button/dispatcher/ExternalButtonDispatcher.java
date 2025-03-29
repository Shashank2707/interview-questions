package com.test.lld.question.elevatordesign.button.dispatcher;

import java.util.ArrayList;
import java.util.List;

import com.test.lld.question.elevatordesign.ElevatorController;
import com.test.lld.question.elevatordesign.enums.Direction;

public class ExternalButtonDispatcher {
	
	private static ExternalButtonDispatcher instance;
    private final List<ElevatorController> elevatorControllerList;
	
    public ExternalButtonDispatcher() {
    	elevatorControllerList = new ArrayList<>();
    }

//	 List<ElevatorController> elevatorCotrollerList = new ArrayList<ElevatorController>();
	
//	List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;
    
    public static synchronized ExternalButtonDispatcher getInstance() {
        if (instance == null) {
            instance = new ExternalButtonDispatcher();
        }
        return instance;
    }
    
    public void registerElevator(ElevatorController controller) {
    	elevatorControllerList.add(controller);
    }
    
    public void dispatchRequest(int floor, Direction direction) {
        ElevatorController bestElevator = findBestElevator(floor, direction);
        if (bestElevator != null) {
            bestElevator.acceptNewRequest(floor, direction);
        }
    }
    
    private ElevatorController findBestElevator(int floor, Direction direction) {
        ElevatorController bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : elevatorControllerList) {
        	 if (controller.getCar().isIdle() || controller.getCar().getDirection() == direction) {
                 int distance = Math.abs(controller.getCar().getCurrentFloor() - floor);
                 if (distance < minDistance) {
                     minDistance = distance;
                     bestElevator = controller;
                 }
             }
        }
        return bestElevator;


//        for (Elevator e : elevators) {
//            if (e.isIdle() || e.getDirection() == direction) {
//                int distance = Math.abs(e.getCurrentFloor() - floor);
//                if (distance < minDistance) {
//                    minDistance = distance;
//                    bestElevator = e;
//                }
//            }
//        }
//        return bestElevator;
    }

//    public void submitExternalRequest(int floor, Direction direction){
//
//
//        //for simplicity, i am following even odd,
//        for(ElevatorController elevatorController : elevatorControllerList) {
//
//           int elevatorID = elevatorController.getElevatorCar().getId();
//           if (elevatorID%2==1 && floor%2==1){
//               elevatorController.submitExternalRequest(floor,direction);
//           } else if(elevatorID%2==0 && floor%2==0){
//               elevatorController.submitExternalRequest(floor,direction);
//
//           }
//        }
//    }

}
