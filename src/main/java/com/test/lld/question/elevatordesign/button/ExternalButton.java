package com.test.lld.question.elevatordesign.button;

import com.test.lld.question.elevatordesign.button.dispatcher.ExternalButtonDispatcher;
import com.test.lld.question.elevatordesign.enums.Direction;

public class ExternalButton {

	private final ExternalButtonDispatcher externalButtonDispatcher;
	
	 public ExternalButton() {
	        this.externalButtonDispatcher = ExternalButtonDispatcher.getInstance();
	    }
	
	 
	 public void submitRequestToGo(int floor, Direction direction) {
		 externalButtonDispatcher.dispatchRequest(floor, direction);
	    }
	 
//	private void submitRequestToGo(int floorNo, Direction dir)
//	{
//		
//	}
}
