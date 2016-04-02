import java.util.ArrayList;

/**
 * Created by user on 02/04/16.
 */
public class Functions {

  public void create_set(String setName, String description) {
    if (chkSetConditions(setName)) {
      Main.set.add(new set(setName, description));
    }
  }

  public set getNoset() {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    for (int i = 0; i < mySet.size(); i++) {
      set mSet = mySet.get(i);
      if (mSet.getSetName().equals("NoSet")) {
        return mSet;
      }
    }
    return null;
  }

  public void addShapeToSet(String setName, String shapeName) {
    if (doesSetExists(setName)) {
      if (doesShapeAlreadyExists(shapeName)) {
        if (!isShapeExistsinSet(getSet(setName), getShape(shapeName))) {
          set mSet = getSet(setName);
          mSet.addShape(getShape(shapeName));
          getNoset().removeShape(getShape(shapeName));
        } else {
          System.out.println("Shape " + shapeName + " is already in set " + setName);
        }
      } else {
        System.out.println("Shape " + shapeName + " does not exist");
      }
    } else {
      System.out.println("Set " + setName + " does not exist");
    }
  }

  public void removeShapeFromNoSet(String shapeName) {
    ArrayList<shape> myShapes = getNoset().getShapes();
    for (int i = 0; i < myShapes.size(); i++) {
      shape mShape = myShapes.get(i);
      String mShapeName = mShape.getShapeName();
      if (shapeName.equals(mShapeName)) {
        getNoset().removeShape(mShapeName);
      }
    }
  }

  public void removeShapeFromSet(String setName, String shapeName) {
    if (doesSetExists(setName)) {
      if (doesShapeAlreadyExists(shapeName)) {
        if (isShapeExistsinSet(getSet(setName), getShape(shapeName))) {
          ArrayList<set> mySet = Main.set;
          for (int i = 0; i < mySet.size(); i++) {
            ArrayList<shape> shapes = mySet.get(i).getShapes();
            for (int j = 0; j < shapes.size(); j++) {
              String myShapeName = shapes.get(j).getShapeName();
              if (shapeName.equals(myShapeName)) {
                shapes.remove(j);
              }
            }
          }
        } else {
          System.out.println("Shape " + shapeName + " removed from set " + setName);
        }
      } else {
        System.out.println("Shape " + shapeName + " does not exist");
      }
    } else {
      System.out.println("Set " + setName + " does not exist");
    }
  }

  public void create_rectangle(String shapeName, double length, double width, String color) {
    if (chkShapeConditions(shapeName)) {
      shape myShape = new shape(shapeName);
      myShape.setLength(length);
      myShape.setWidth(width);
      myShape.setColor(color);
      myShape.setType(CONSTANTS.shapeTypes.RECTANGLE.toString());
      addToNoSet(myShape);
    }
  }

  public void create_circle(String shapeName, double radius, String color) {
    if (chkShapeConditions(shapeName)) {
      shape myShape = new shape(shapeName);
      myShape.setRadius(radius);
      myShape.setColor(color);
      myShape.setType(CONSTANTS.shapeTypes.CIRCLE.toString());
      addToNoSet(myShape);
    }
  }

  public void create_square(String shapeName, double side, String color) {
    if (chkShapeConditions(shapeName)) {
      shape myShape = new shape(shapeName);
      myShape.setSide(side);
      myShape.setColor(color);
      myShape.setType(CONSTANTS.shapeTypes.SQUARE.toString());
      addToNoSet(myShape);
    }
  }

  public void addToNoSet(shape myShape) {
    if (!doesShapeAlreadyExists(myShape.getShapeName())) {
      getNoset().addShape(myShape);
    }
  }

  public String getSetNameForTheShape(String myShapeName) {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    for (int i = 0; i < mySet.size(); i++) {
      ArrayList<shape> shapes = mySet.get(i).getShapes();
      for (int j = 0; j < shapes.size(); j++) {
        String shapeName = shapes.get(i).getShapeName();
        if (shapeName.equals(myShapeName)) {
          return mySet.get(j).getSetName();
        }
      }
    }
    return null;
  }

  public boolean doesShapeAlreadyExists(String myShapeName) {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    for (int i = 0; i < mySet.size(); i++) {
      ArrayList<shape> shapes = mySet.get(i).getShapes();
      for (int j = 0; j < shapes.size(); j++) {
        String shapeName = shapes.get(j).getShapeName();
        if (shapeName.equals(myShapeName)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean doesSetExists(String setName) {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    for (int i = 0; i < mySet.size(); i++) {
      set mSet = mySet.get(i);
      if (mSet.getSetName().equals(setName)) {
        return true;
      }
    }
    return false;
  }

  public boolean chkShapeConditions(String myShapeName) {
    if (!doesShapeAlreadyExists(myShapeName)) {
      if (myShapeName.length() <= CONSTANTS.FIXED_SIZE_OF_SET) {
        if (Utils.isAlpha(myShapeName)) {
          return true;
        } else {
          System.out.println("Invalid shape name");
        }
      } else {
        System.out.println("Invalid shape name");
      }
    } else {
      System.out.println(
          "Shape " + myShapeName + " is already in set " + getSetNameForTheShape(myShapeName));
    }
    return false;
  }

  public boolean chkSetConditions(String mySetName) {
    if (!doesSetExists(mySetName)) {
      if (mySetName.length() <= CONSTANTS.FIXED_SIZE_OF_SET) {
        if (Utils.isAlpha(mySetName)) {
          return true;
        } else {
          System.out.println("Invalid shape name");
        }
      } else {
        System.out.println("Invalid shape name");
      }
    } else {
      System.out.println("Set " + mySetName + " Already Exists");
    }
    return false;
  }

  public void showSets() {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    if (mySet.size() == 0 || mySet.isEmpty()) {
      System.out.println("There are no sets in the system");
      return;
    }
    for (int i = 0; i < mySet.size(); i++) {
      set mSet = mySet.get(i);
      int countOfShapesAvailable = mSet.getShapes().size();
      if (countOfShapesAvailable > 0) {
        System.out.println(
            "[ " + mSet.getSetName() + " ] " + Integer.toString(countOfShapesAvailable) + " Items");
      }
    }
  }

  public void showShapes() {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    if (mySet.size() == 0 || mySet.isEmpty()) {
      System.out.println("There are no shapes in the system");
      return;
    }
    System.out.println("Listing all shapes in the system:");
    for (int i = 0; i < mySet.size(); i++) {
      ArrayList<shape> shapes = mySet.get(i).getShapes();
      for (int j = 0; j < shapes.size(); j++) {
        shape myShape = shapes.get(j);
        if (myShape.getType().equals(CONSTANTS.shapeTypes.CIRCLE.toString())) {
          System.out.println(
              "[" + myShape.getShapeName() + "] " + "This is a " + myShape.getColor() + " "
                  + myShape.getType() + " of " + "radius " + Double.toString(myShape.getRadius()));
        }
        if (myShape.getType().equals(CONSTANTS.shapeTypes.SQUARE.toString())) {
          System.out.println(
              "[" + myShape.getShapeName() + "] " + "This is a " + myShape.getColor() + " "
                  + myShape.getType() + " of " + "side " + Double.toString(myShape.getSide()));
        }
        if (myShape.getType().equals(CONSTANTS.shapeTypes.RECTANGLE.toString())) {
          System.out.println(
              "[" + myShape.getShapeName() + "] " + "This is a " + myShape.getColor() + " "
                  + myShape.getType() + " of " + " length " + Double.toString(myShape.getLength())
                  + " and width " + Double.toString(myShape.getWidth()));
        }
      }
    }
  }

  public void showSetInfo(String setName) {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    if (mySet.size() == 0 || mySet.isEmpty()) {
      System.out.println("Set " + setName + " is Empty");
      return;
    }
    for (int i = 0; i < mySet.size(); i++) {
      ArrayList<shape> shapes = mySet.get(i).getShapes();
      System.out.println("Set " + setName + " has the following items: ");
      for (int j = 0; j < shapes.size(); j++) {
        shape myShape = shapes.get(j);
        if (myShape.getType().equals(CONSTANTS.shapeTypes.CIRCLE.toString())) {
          System.out.println(
              "[" + myShape.getShapeName() + "] " + "This is a " + myShape.getColor() + " "
                  + myShape.getType() + " of" + "radius " + Double.toString(myShape.getRadius()));
          return;
        }
        if (myShape.getType().equals(CONSTANTS.shapeTypes.SQUARE.toString())) {
          System.out.println(
              "[" + myShape.getShapeName() + "] " + "This is a " + myShape.getColor() + " "
                  + myShape.getType() + " of" + "side " + Double.toString(myShape.getSide()));
          return;
        }
        if (myShape.getType().equals(CONSTANTS.shapeTypes.RECTANGLE.toString())) {
          System.out.println(
              "[" + myShape.getShapeName() + "] " + "This is a " + myShape.getColor() + " "
                  + myShape.getType() + " of" + " length " + Double.toString(myShape.getLength())
                  + " and width " + Double.toString(myShape.getWidth()));
          return;
        }
      }
      System.out.println("Set " + setName + " does not exist");
    }
  }

  public set getSet(String setName) {
    ArrayList<set> mySet = Main.set;
    for (int i = 0; i < mySet.size(); i++) {
      String mSetName = mySet.get(i).getSetName();
      if (setName.equals(mSetName)) {
        return mySet.get(i);
      }
    }
    return null;
  }

  public shape getShape(String shapeName) {
    ArrayList<set> mySet = new ArrayList<set>(Main.set);
    for (int i = 0; i < mySet.size(); i++) {
      ArrayList<shape> shapes = mySet.get(i).getShapes();
      for (int j = 0; j < shapes.size(); j++) {
        String mShapeName = shapes.get(j).getShapeName();
        if (shapeName.equals(mShapeName)) {
          return shapes.get(j);
        }
      }
    }
    return null;
  }

  public boolean isShapeExistsinSet(set mySet, shape myshape) {
    for (int i = 0; i < mySet.getShapes().size(); i++) {
      ArrayList<shape> shapes = mySet.getShapes();
      for (int j = 0; j < shapes.size(); j++) {
        String shapeName = shapes.get(i).getShapeName();
        if (shapeName.equals(myshape.getShapeName())) {
          return true;
        }
      }
    }
    return false;
  }

  public void deleteSet(String setName) {
    if (doesSetExists(setName)) {
      ArrayList<set> mySet = Main.set;
      for (int i = 0; i < mySet.size(); i++) {
        String mSetName = mySet.get(i).getSetName();
        if (setName.equals(mSetName)) {
          System.out.println("Set " + setName + " has been deleted");
          ArrayList<shape> allShapes = mySet.get(i).getShapes();
          mySet.remove(i);
          for (int j = 0; j < allShapes.size(); j++) {
            addToNoSet(allShapes.get(j));
          }
        }
      }
    } else {
      System.out.println("Set " + setName + " does not exist");
    }
  }

  public void delteShape(String shapeName) {
    if (doesShapeAlreadyExists(shapeName)) {
      ArrayList<set> mySet = Main.set;
      for (int i = 0; i < mySet.size(); i++) {
        ArrayList<shape> shapes = mySet.get(i).getShapes();
        for (int j = 0; j < shapes.size(); j++) {
          String myShapeName = shapes.get(j).getShapeName();
          if (shapeName.equals(myShapeName)) {
            shapes.remove(j);
            System.out.println("Shape " + shapeName + " has been deleted");
          }
        }
      }
    } else {
      System.out.println("Shape " + shapeName + " does not exist");
    }
  }

  public void compareSet(String setName1, String setName2, String compareType) {
    if (doesSetExists(setName1)) {
      if (doesSetExists(setName2)) {
        set set1 = getSet(setName1);
        set set2 = getSet(setName2);
        if (compareType.equals(CONSTANTS.compareTypes.AREA.toString())) {
          if (set1.getCummulativeArea() > set2.getCummulativeArea()) {
            double diff = set1.getCummulativeArea() - set2.getCummulativeArea();
            System.out.println("The Area of " + set1.getSetName() + " is " + diff + " larger than "
                + set2.getSetName());
          } else {
            double diff = set2.getCummulativeArea() - set1.getCummulativeArea();
            System.out.println("The Area of " + set2.getSetName() + " is " + diff + " larger than "
                + set1.getSetName());
          }
        }
        if (compareType.equals(CONSTANTS.compareTypes.PERIMETER.toString())) {
          if (set1.getCummulativePerimeter() > set2.getCummulativePerimeter()) {
            double diff = set1.getCummulativePerimeter() - set2.getCummulativePerimeter();
            System.out.println("The Area of " + set1.getSetName() + " is " + diff + " larger than "
                + set2.getSetName());
          } else {
            double diff = set2.getCummulativeArea() - set1.getCummulativeArea();
            System.out.println("The Area of " + set2.getSetName() + " is " + diff + " larger than "
                + set1.getSetName());
          }
        }
      } else {
        System.out.println("Set " + setName2 + " does not exist");
      }
    } else {
      System.out.println("Set " + setName1 + " does not exist");
    }
  }

  public void compareShape(String shapeName1, String shapeName2, String compareType) {
    if (doesShapeAlreadyExists(shapeName1)) {
      if (doesShapeAlreadyExists(shapeName2)) {
        if (compareType.equals(CONSTANTS.compareTypes.AREA.toString())) {
          shape shape1 = getShape(shapeName1);
          shape shape2 = getShape(shapeName2);
          if (shape1.getArea() > shape2.getArea()) {
            double diff = shape1.getArea() - shape2.getArea();
            System.out.println(
                "The Area of " + shape1.getShapeName() + " is " + diff + " larger than "
                    + shape2.getShapeName());
          } else {
            double diff = shape2.getArea() - shape1.getArea();
            System.out.println(
                "The Area of " + shape2.getShapeName() + " is " + diff + " larger than "
                    + shape1.getShapeName());
          }
        }
        if (compareType.equals(CONSTANTS.compareTypes.PERIMETER.toString())) {
          shape shape1 = getShape(shapeName1);
          shape shape2 = getShape(shapeName2);
          if (shape1.getPerimeter() > shape2.getPerimeter()) {
            double diff = shape1.getPerimeter() - shape2.getPerimeter();
            System.out.println(
                "The Area of " + shape1.getShapeName() + " is " + diff + " larger than "
                    + shape2.getShapeName());
          } else {
            double diff = shape2.getPerimeter() - shape1.getPerimeter();
            System.out.println(
                "The Area of " + shape2.getShapeName() + " is " + diff + " larger than "
                    + shape1.getShapeName());
          }
        }
      } else {
        System.out.println("Shape " + shapeName2 + " does not exist");
      }
    } else {
      System.out.println("Shape " + shapeName1 + " does not exist");
    }
  }
}
