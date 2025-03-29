package com.test.lld.question.elevatordesign.button;

import com.test.lld.question.elevatordesign.ElevatorCar;
import com.test.lld.question.elevatordesign.ElevatorController;
import com.test.lld.question.elevatordesign.button.dispatcher.InternalButtonDispatcher;

public class InternalButton {
	
    
//    InternalButtonDispatcher dispatcher = new InternalButtonDispatcher();
//
//    int[] availableButtons = {1,2,3,4,5,6,7,8,9,10};
//    int buttonSelected;
//
//    public void pressButton(int destination, ElevatorCar elevatorCar) {
//
//        //1.check if destination is in the list of available floors
//
//        //2.submit the request to the jobDispatcher
//        dispatcher.submitInternalRequest(destination, elevatorCar);
//    }
	
	 private final ElevatorController controller;

	    public InternalButton(ElevatorController controller) {
	        this.controller = controller;
	    }

	    public void pressButton(int floor) {
	        System.out.println("Internal button pressed for floor: " + floor);
	        controller.acceptInternalRequest(floor);
	    }

}
