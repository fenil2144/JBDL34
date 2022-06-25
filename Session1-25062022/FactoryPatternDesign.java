interface Shape{
	void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Inside Circle Class");		
	}
}

class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Inside Square Class");		
	}
	
}

class ShapeFactory{
	public Shape getShape(String shapeType) {
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}

public class FactoryPatternDesign {
	
	public static void main(String args[]) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape2.draw();
		
	}

}
