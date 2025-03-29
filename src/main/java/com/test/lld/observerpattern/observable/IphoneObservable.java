package com.test.lld.observerpattern.observable;

import java.util.ArrayList;
import java.util.List;

import com.test.lld.observerpattern.observer.NotificatrionAlertObserver;


public class IphoneObservable implements StockObservable {
	
	private List<NotificatrionAlertObserver> iphoneObserverList = new ArrayList<>();
	int data = 0;
	
	@Override
	public void addObserver(NotificatrionAlertObserver observer) {
		iphoneObserverList.add(observer);
	}

	@Override
	public void removeObserver(NotificatrionAlertObserver observer) {
		iphoneObserverList.remove(observer);
	}

	@Override
	public void notifyAllObserver() {
		
		for(NotificatrionAlertObserver observer : iphoneObserverList)
			observer.update();
	}

	@Override
	public void setStockCount(int newData) {
		
		if(data == 0)
		{
			notifyAllObserver();
		}
		data = data + newData;
	}

	@Override
	public int getStockCount() {
		return data;
	}

}
