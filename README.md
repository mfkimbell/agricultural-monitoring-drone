# CS 420 Drone Project

___
**Members:** ___Kai Battle, Mitchell Kimbell, McKinley Morris, Jayden Pyles___

### Tools Used:
* `Java` Main logic for program
* `JavaFX` Used for its reusable components to produce an interactive UI
* `Github Issues` For team collaboration and Agile methodology

### Objective
The purpose of this project was to create an application that allows peopel in the agriculture industry to map out areas of land and allow for automated drones to survery the designated land. To do this, we created a UI that allows a user to map out and define areas, and then a drone associated with the application will go and survery the designated areas. 

### Design Patterns
**Singleton Pattern:**
The Singleton design pattern ensures that a class has only one instance, and it provides a global point of access to that instance. This is useful when you want to control the creation of a single, shared instance of a class throughout your application. It is often used for managing resources, configuration settings, or any other situation where you need to ensure that there is only one instance of a class.

In our project, we implemented the singleton pattern for the drone object, so that all references to the drone refer to the same object:
```
public class Drone extends FarmItem{
    
    private ImageView image;
    private String name;
    private float price;
    private float x;
    private float y;
    private float length;
    private float width;
    private float height;
    private Rectangle rectangle;

    private static Drone instance = new Drone("drone",0,0,0,0,0,0, new Rectangle(), new Text(), new ImageView());


    private Drone(String name, float price, float x, float y, float length, float width, float height, Rectangle perimeter, Text label, ImageView image) {
        super(name, price, x, y, length, width, height, perimeter, label);
        this.image = image;

    }

    public static Drone getInstance() {
        return instance;
    }
```

**Composite Pattern:**
Composite Pattern:
The Composite design pattern is a structural pattern used to compose objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly. This pattern is especially useful when you need to work with complex hierarchical structures, such as a directory structure in a file system or a graphic user interface with nested components.
In the Composite pattern, you typically have a common interface or base class that both leaf and composite objects implement. Composite objects can contain other objects, including leaf objects and other composites. Clients interact with this structure without needing to differentiate between leaf and composite objects. In our project, we used our farm objects as composite since we needed a heirarchical structure to store nested containers and items. All the subclasses in the tree share the same type to build off of: "FarmObject".


### Resources
[SceneBuilder](https://gluonhq.com/products/scene-builder/)\
[JavaFX](https://openjfx.io/)
