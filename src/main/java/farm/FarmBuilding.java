package farm;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class FarmBuilding extends ItemContainer{
    private Rectangle perimeter;
    private Text label;

    public void setPerimeter(Rectangle perimeter) {
        this.perimeter = perimeter;
    }

    public Rectangle getPerimeter() {
        return perimeter;
    }

    public Text getLabel() {
        return this.label;
    }
    public void setLabel(Text label) {
        this.label = label;
    }

    public FarmBuilding(String name, float price, float x, float y, float length, float width, float height, Rectangle perimeter, Text label) {
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
        this.label = label;
    }
    public FarmBuilding () {};

    @Override
    public String toString() {
        return this.name;
    };
}
