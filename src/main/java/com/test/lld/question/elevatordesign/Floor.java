package com.test.lld.question.elevatordesign;

import com.test.lld.question.elevatordesign.button.ExternalButton;
import com.test.lld.question.elevatordesign.button.dispatcher.ExternalButtonDispatcher;

public class Floor {

	private final int floorId; // or floorNo
	
	private final ExternalButtonDispatcher externalButtonDispatcher;
	
	private final ExternalButton externalButton;
	
	 public Floor(int floorId) {
	        this.floorId = floorId;
			this.externalButtonDispatcher = new ExternalButtonDispatcher();
	        this.externalButton = new ExternalButton();
	    }


//	public Floor(int floorNumber){
//	   this.floorId = floorNumber;
//	   externalButtonDispatcher = new ExternalButtonDispatcher();
//	}
	 
	 public int getFloorId() {
	        return floorId;
	    }

	    public ExternalButton getExternalButton() {
	        return externalButton;
	    }
	    
	    
//	    public void pressButton(Direction direction) {
//
//	    	externalButtonDispatcher.submitExternalRequest(floorId, direction);
//	    }

}
