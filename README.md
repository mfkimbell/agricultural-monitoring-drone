# Agricultural Drone Project

___
**Members:** ___Kai Battle, Mitchell Kimbell, McKinley Morris, Jayden Pyles___

Drone starting position:

<img width="250" alt="workflow devops" src="https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/fde68d86-5d7d-46cf-8ff8-733b92957059">


Clips of the drone in action:

ScanFarm()

![ezgif com-gif-maker](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/6a30815c-813b-4cfa-ace1-1598983f2ac9)

VisitItem()

![ezgif com-gif-maker](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/f5af4f40-b4ac-4896-a5f0-09fcab2caf48)



## Tools Used:
* `Java` Main logic for program
* `JavaFX` Used for its reusable components to produce an interactive UI
* `Github Issues` For team collaboration and Agile methodology
* `Tello API` For connecting to the drone and allow for scripting of movments

## Objective
The purpose of this project was to create an application that allows people in the agriculture industry to map out areas of land and allow for automated drones to survey the designated land. To do this, we created a UI that allows a user to map out and define areas, and then a drone associated with the application will go and survey the designated areas. 

## How to run the program
* Install JDK-21
* Install IDE with maven plugin
* Clone the [github repo](https://github.com/mfkimbell/agricultural-monitoring-drone)
* Build and run DroneDashboardApplication in the IDE

## Design Patterns
**Singleton Pattern:**
The Singleton design pattern ensures that a class has only one instance, and it provides a global point of access to that instance. This is useful when you want to control the creation of a single, shared instance of a class throughout your application. It is often used for managing resources, configuration settings, or any other situation where you need to ensure that there is only one instance of a class.

In our project, we implemented the singleton pattern for the drone object, so that all references to the drone refer to the same object:
``` java
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
In the Composite pattern, you typically have a common interface or base class that both leaf and composite objects implement. Composite objects can contain other objects, including leaf objects and other composites. Clients interact with this structure without needing to differentiate between leaf and composite objects. In our project, we used our farm objects as composite since we needed a hierarchical structure to store nested containers and items. All the subclasses in the tree share the same type to build off of: "FarmObject".



## Resources
[SceneBuilder](https://gluonhq.com/products/scene-builder/)\
[JavaFX](https://openjfx.io/)\
[GitHub](https://github.com/mfkimbell/agricultural-monitoring-drone)

## Demo

### Opening Screen:

![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/fdb174ad-2cfc-4c0f-ad7c-7630f94981b4)

### Adding a Container: 
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/9cf5f573-bd1f-4894-b04d-af78786af309)

### Adding an Item:
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/1fb47636-8e1f-47e4-8cf7-aa4ecb43361c)


### Changing existing Item/Container dimensions:
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/391a25c1-d21e-4f7f-9336-92352f2bd188)


### Changing existing Item/Container location:
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/73040a3a-1e16-41d0-8e9a-cd9bc13af250)


### Sending drone to Item/Container Location:
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/3e8e94f8-5cec-402e-97ed-3a3781ab1629)

### Returning drone to command center:
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/8461f35c-ac57-4275-8011-69bcade48871)

### Drone Scanning entire farm area:
![image](https://github.com/mfkimbell/agricultural-monitoring-drone/assets/107063397/afaf80d4-6260-47f4-a63f-ddaaa0e062ca)






