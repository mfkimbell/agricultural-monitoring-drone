package farm;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class FarmBuilding extends ItemContainer{
    private Rectangle perimeter;

    public void setPerimeter(Rectangle perimeter) {
        this.perimeter = perimeter;
    }

    public Rectangle getPerimeter() {
        return perimeter;
    }

    public FarmBuilding(String name, float price, float x, float y, float length, float width, float height, Rectangle perimeter) {
        this.name = name;
        this.price = price;
        this.locationX = x;
        this.locationY = y;
        this.items = new ArrayList<Item>();
        this.itemContainers = new ArrayList<ItemContainer>();
        this.length = length;
        this.width = width;
        this.height = height;
        this.perimeter = perimeter;

    }
    public FarmBuilding () {};

    @Override
    public String toString() {
        return this.name;
    };
}
