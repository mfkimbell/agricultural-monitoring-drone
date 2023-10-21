package farm;

import java.util.ArrayList;

public class FarmBuilding extends ItemContainer{
    public FarmBuilding(String name, int x, int y) {
        this.name = name;
        this.locationX = x;
        this.locationY = y;
        this.items = new ArrayList<Item>();
        this.itemContainers = new ArrayList<ItemContainer>();
    }
}
