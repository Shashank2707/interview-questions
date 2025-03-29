package com.test.lld.factorypattern;

import com.test.lld.factorypattern.shape.Circle;
import com.test.lld.factorypattern.shape.Rectangle;
import com.test.lld.factorypattern.shape.Shape;

public class ShapeFactory {

	public Shape getShape(String input)
	{
		switch(input) {
			
			case "CIRCLE" :
				return new Circle();
			case "RECTANGLE" :
				return new Rectangle();
			default :
				return null;
		}
	}
}
