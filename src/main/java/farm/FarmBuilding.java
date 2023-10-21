package farm;

import java.util.ArrayList;

public class FarmBuilding extends ItemContainer{
    public FarmBuilding(String name, float price, float x, float y, float length, float width, float height) {
        this.name = name;
        this.price = price;
        this.locationX = x;
        this.locationY = y;
        this.items = new ArrayList<Item>();
        this.itemContainers = new ArrayList<ItemContainer>();
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
