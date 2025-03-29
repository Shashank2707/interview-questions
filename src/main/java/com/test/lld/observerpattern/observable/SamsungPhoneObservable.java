package com.test.lld.observerpattern.observable;

import java.util.ArrayList;
import java.util.List;

import com.test.lld.observerpattern.observer.NotificatrionAlertObserver;

public class SamsungPhoneObservable implements StockObservable{
	
	private List<NotificatrionAlertObserver> samsungObserverList = new ArrayList<>();
	int data = 0;

	@Override
	public void addObserver(NotificatrionAlertObserver observer) {
		samsungObserverList.add(observer);
	}

	@Override
	public void removeObserver(NotificatrionAlertObserver observer) {
		samsungObserverList.remove(observer);
	}

	@Override
	public void notifyAllObserver() {
		for(NotificatrionAlertObserver observer : samsungObserverList)
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
		// TODO Auto-generated method stub
		return data;
	}

}
