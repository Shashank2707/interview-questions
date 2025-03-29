package com.test.lld.decoratorpattern.toppings;

import com.test.lld.decoratorpattern.ToppingDecorator;
import com.test.lld.decoratorpattern.pizza.BasePizza;

public class ExtraCheese extends ToppingDecorator{

	private BasePizza basePizza;
	
	public ExtraCheese(BasePizza _pizza)
	{
		this.basePizza = _pizza;
	}
	
	@Override
	public int cost() {
		return basePizza.cost() + 75;
	}

}
