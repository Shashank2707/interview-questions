package com.test.lld.observerpattern.observable;

import com.test.lld.observerpattern.observer.NotificatrionAlertObserver;

public interface StockObservable {

	public void addObserver(NotificatrionAlertObserver observer);
	public void removeObserver(NotificatrionAlertObserver observer);
	public void notifyAllObserver();
	public void setStockCount(int newData);
	public int getStockCount();
}
