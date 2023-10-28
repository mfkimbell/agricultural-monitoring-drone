package farm;

import javafx.scene.shape.Rectangle;

public class FarmItem extends Item {
    private Rectangle perimeter;

    public Rectangle getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Rectangle perimeter) {
        this.perimeter = perimeter;
    }

    public FarmItem(String name, float price, float x, float y, float length, float width, float height, Rectangle perimeter) {
        this.name = name;
        this.price = price;
        this.locationX = x;
        this.locationY = y;
        this.length = length;
        this.width = width;
        this.height = height;
        this.perimeter = perimeter;
    }

    public FarmItem() {

    }

    @Override
    public String toString() {
        return this.name;
    }
}
