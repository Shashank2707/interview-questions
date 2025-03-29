package com.test.lld.factorypattern;

import com.test.lld.factorypattern.shape.Shape;

/*Factory Pattern is used when we need objects on some conditions
 * It helps in decoupling the code and improves readiability
 * */
public class FactoryMain {

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape circleObj = shapeFactory.getShape("CIRCLE");
		
		Shape rectangleObj = shapeFactory.getShape("RECTANGLE");
		
		circleObj.draw();
		rectangleObj.draw();
	}
}
