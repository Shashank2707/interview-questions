package com.test.lld.decoratorpattern.toppings;

import com.test.lld.decoratorpattern.ToppingDecorator;
import com.test.lld.decoratorpattern.pizza.BasePizza;

public class ExtraMushroom extends ToppingDecorator{

	private BasePizza basePizza;
	
	public ExtraMushroom(BasePizza _basPizza)
	{
		this.basePizza = _basPizza;
	}
	
	@Override
	public int cost() {
		return basePizza.cost() + 45;
	}

}
