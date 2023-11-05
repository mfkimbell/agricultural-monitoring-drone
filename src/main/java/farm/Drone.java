package farm;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
    public ImageView getImage() {
        return this.image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
