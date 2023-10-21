package farm;

import java.util.ArrayList;

public abstract class ItemContainer {
    /* Vars */
    protected ArrayList<ItemContainer> itemContainers;
    protected ArrayList<Item> items;

    /* Methods */
    public void addItem(Item item){
        this.items.add(item);
    };
    public void deleteItem(Item item){
        int index = items.indexOf(item);
        this.items.remove(index);
    };
    public void addItemContainer(ItemContainer itemContainer){
        this.itemContainers.add(itemContainer);
    };
    public void deleteItemContainer(ItemContainer itemContainer){
        int index = itemContainers.indexOf(itemContainer);
        this.itemContainers.remove(index);
    };
}
