package com.test.lld.observerpattern.observer;

import com.test.lld.observerpattern.observable.StockObservable;

public class EmailAlertObserver implements NotificatrionAlertObserver{

	private String name;
	private String email;
	
	
	// for which observable we need to sent Alert will be taken care by below has a relation ship
	private StockObservable stockObservable;
	
	public EmailAlertObserver(String name, String email, StockObservable stockObservable) {
		this.name = name;
		this.email = email;
		this.stockObservable = stockObservable;
	}

	@Override
	public void update() {
		System.out.println(stockObservable);
		sendEmail(name,email,"Your iPhone is waiting for you !");
	}

	private void sendEmail(String name,String email, String string) {
		System.out.println("mail sent to : " + name + "successfully!");
	}

}
