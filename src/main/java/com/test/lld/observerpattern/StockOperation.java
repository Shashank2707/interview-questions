package com.test.lld.observerpattern;

import com.test.lld.observerpattern.observable.IphoneObservable;
import com.test.lld.observerpattern.observable.SamsungPhoneObservable;
import com.test.lld.observerpattern.observable.StockObservable;
import com.test.lld.observerpattern.observer.EmailAlertObserver;
import com.test.lld.observerpattern.observer.MobileAlertObserver;
import com.test.lld.observerpattern.observer.NotificatrionAlertObserver;

public class StockOperation {

	public static void main(String[] args) {
		
		StockObservable iphoneObservable = new IphoneObservable();
		
		StockObservable samsungObservable = new SamsungPhoneObservable();
		
		NotificatrionAlertObserver observer1 = new EmailAlertObserver("shashank", "shashankp2707@gmail.com", iphoneObservable);
		
		NotificatrionAlertObserver observer2 = new MobileAlertObserver("Manisha", "manishaP2707@gmail.com", iphoneObservable);
		
		NotificatrionAlertObserver observer3 = new EmailAlertObserver("shashank", "shashankp2707@gmail.com", samsungObservable);
		
		iphoneObservable.addObserver(observer1);
		iphoneObservable.addObserver(observer2);
		
		samsungObservable.addObserver(observer3);
		
		iphoneObservable.setStockCount(10);
		samsungObservable.setStockCount(10);
		
	}
}
