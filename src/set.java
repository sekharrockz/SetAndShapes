import java.util.ArrayList;

/**
 * Created by user on 02/04/16.
 */
public class set {
  private String setName;
  private String description;
  private ArrayList<shape> shapes = new ArrayList<shape>();

  set(String setName,String description) {
    this.setName = setName;
    this.description = description;
  }

  // GETTER
  public String getDescription() {
    return description;
  }

  public String getSetName() {
    return setName;
  }

  public ArrayList<shape> getShapes() {
    return shapes;
  }

  // SETTER
  public void setSetName(String setName) {
    this.setName = setName;
  }

  public void setShapes(ArrayList<shape> shapes) {
    this.shapes = shapes;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // add a shape
  public void addShape(shape myShape) {
    shapes.add(myShape);
  }

  public void removeShape(shape myShape) {
    for (int i = 0; i < shapes.size(); i++) {
      String shapeName = shapes.get(i).getShapeName();
      if (shapeName.equals(myShape.getShapeName())) {
        shapes.remove(i);
      }
    }
  }

  public void removeShape(String myShapeName) {
    for (int i = 0; i < shapes.size(); i++) {
      String shapeName = shapes.get(i).getShapeName();
      if (shapeName.equals(myShapeName)) {
        shapes.remove(i);
      }
    }
  }

  public double getCummulativeArea() {
    ArrayList<shape> shapes = getShapes();
    double sum = 0;
    for(int i=0;i<shapes.size();i++) {
      shape myShape = shapes.get(i);
      sum += myShape.getArea();
    }
    return sum;
  }

  public double getCummulativePerimeter() {
    ArrayList<shape> shapes = getShapes();
    double sum = 0;
    for(int i=0;i<shapes.size();i++) {
      shape myShape = shapes.get(i);
      sum += myShape.getPerimeter();
    }
    return sum;
  }

}
