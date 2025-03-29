package com.test.lld.decoratorpattern;

import com.test.lld.decoratorpattern.pizza.BasePizza;
import com.test.lld.decoratorpattern.pizza.Margherita;
import com.test.lld.decoratorpattern.toppings.ExtraCheese;
import com.test.lld.decoratorpattern.toppings.ExtraMushroom;

public class Pizza {

	public static void main(String[] args) {
		
		//BasePizza pizza = new Margherita();
		//BasePizza pizza = new ExtraCheese(new Margherita());
		
		BasePizza pizza = new ExtraMushroom(new ExtraCheese(new Margherita()));
		
		System.out.println("Please pay : " + pizza.cost());
		
	}
}
