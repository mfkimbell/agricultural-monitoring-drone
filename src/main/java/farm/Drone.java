package farm;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Drone extends FarmItem{
    private final ImageView image;
    public Drone(String name, float price, float x, float y, float length, float width, float height, Rectangle perimeter, ImageView image) {
        super(name, price, x, y, length, width, height, perimeter);
        this.image = image;
    }
    public ImageView getImage() {
        return this.image;
    }
}
