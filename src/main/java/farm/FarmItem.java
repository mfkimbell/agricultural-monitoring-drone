package farm;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class FarmItem extends Item {
    private Rectangle perimeter;
    private Text label;
    private float marketValue;

    public Rectangle getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Rectangle perimeter) {
        this.perimeter = perimeter;
    }

    public Text getLabel() {
        return this.label;
    }
    public void setLabel(Text label) {
        this.label = label;
    }

    public FarmItem(String name, float price, float marketValue, float x, float y, float length, float width, float height, Rectangle perimeter, Text label) {
        this.name = name;
        this.price = price;
        this.marketValue = marketValue;
        this.locationX = x;
        this.locationY = y;
        this.length = length;
        this.width = width;
        this.height = height;
        this.perimeter = perimeter;
        this.label = label;
    }

    public FarmItem() {

    }

    @Override
    public String toString() {
        return this.name;
    }
}
