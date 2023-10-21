package farm;
public class FarmItem extends Item {
    public FarmItem(String name, float price, float x, float y, float length, float width, float height) {
        this.name = name;
        this.price = price;
        this.locationX = x;
        this.locationY = y;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
