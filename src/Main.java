import java.util.ArrayList;

public class Main {
  public static ArrayList<set> set = new ArrayList<set>();

  public static void main(String[] args) {
    set.add(new set("NoSet",
        "This is default set, which consists of shapes which are not yet assigned"));
    Functions myFuns = new Functions();
    myFuns.create_set("MYSET", "this is a set");
    myFuns.create_circle("MYCIRCLE", 2.0, CONSTANTS.colors.BLACK.toString());
    myFuns.create_rectangle("MYRECTANGLE", 2.0, 3.0, CONSTANTS.colors.BLUE.toString());
    myFuns.create_square("MYSQUARE", 2.0, CONSTANTS.colors.RED.toString());
    myFuns.addShapeToSet("MYSET", "MYCIRCLE");
    myFuns.showSets();
    myFuns.showShapes();
    myFuns.create_set("MYSETNEW", "this is another set");
    myFuns.addShapeToSet("MYSETNEW", "MYRECTANGLE");
    myFuns.showSets();
    myFuns.removeShapeFromSet("MYSETNEW","MYRECTANGLE");
    myFuns.deleteSet("MYSETNEW");
    myFuns.delteShape("MYRECTANGLE");
  }
}