package com.test.lld.observerpattern.observer;

import com.test.lld.observerpattern.observable.StockObservable;

public class MobileAlertObserver implements NotificatrionAlertObserver{

	private String name;
	private String phoneNo;
	
	private StockObservable stockObservable;
	
	public MobileAlertObserver(String name, String phoneNo, StockObservable stockObservable) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.stockObservable = stockObservable;
	}

	@Override
	public void update() {
		
		sendAlert(name,phoneNo, "Your iPhone is waiting for you !");
	}

	private void sendAlert(String name, String phoneNo, String string) {
		System.out.println("message sent to : " + name + "successfully!");
	}

}
