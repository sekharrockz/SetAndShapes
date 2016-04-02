/**
 * Created by user on 02/04/16.
 */
public class shape {
  private double radius;
  private String color = CONSTANTS.colors.BLACK.toString();
  private double length;
  private double width;
  private String shapeName;
  private double side;
  private String type;

  shape(String shapeName) {
    this.shapeName = shapeName;
  }

  // GETTERS
  public double getRadius() {
    return radius;
  }

  public String getColor() {
    return color;
  }

  public String getShapeName() {
    return shapeName;
  }

  public double getLength() {
    return length;
  }

  public double getWidth() {
    return width;
  }

  public double getSide() {
    return side;
  }

  public String getType() {
    return type;
  }

  // SETTERS
  public void setRadius(double radius) {
    this.radius = radius;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public void setShapeName(String shapeName) {
    this.shapeName = shapeName;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setSide(double side) {
    this.side = side;
  }

  // GET AREA
  public double getArea() {
    if (type.equals(CONSTANTS.shapeTypes.CIRCLE.toString())) {
      return CONSTANTS.PI * radius * radius;
    }
    if (type.equals(CONSTANTS.shapeTypes.RECTANGLE.toString())) {
      return length * width;
    }
    if (type.equals(CONSTANTS.shapeTypes.SQUARE.toString())) {
      return side * side;
    }
    return 0;
  }

  public double getPerimeter() {
    if (type.equals(CONSTANTS.shapeTypes.CIRCLE.toString())) {
      return 2 * CONSTANTS.PI * radius;
    }
    if (type.equals(CONSTANTS.shapeTypes.RECTANGLE.toString())) {
      return 2 * (length + width);
    }
    if (type.equals(CONSTANTS.shapeTypes.SQUARE.toString())) {
      return 4 * side;
    }
    return 0;
  }

}
