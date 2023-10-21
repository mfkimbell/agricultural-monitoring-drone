package farm;

import java.util.ArrayList;
import java.util.Objects;

public abstract class ItemContainer extends FarmObject {
    /* Vars */
    protected ArrayList<ItemContainer> itemContainers;
    protected ArrayList<Item> items;

    /* Methods */
    public ArrayList<ItemContainer> getItemContainers() {
        return this.itemContainers;
    }
    public ArrayList<Item> getItems() {
        return this.items;
    }
    public void addItem(Item item){
        System.out.println("We addin!");
        this.items.add(item);
        System.out.println("We added!");
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

    public Item getItemFromContainer(String name, int x, int y){
        for (Item item: this.items){
            if (Objects.equals(item.getName(), name) && item.getLocationX() == x && item.getLocationY() == y){
                return item;
            }
        }
        return null;
    };

    public ItemContainer getItemContainerFromContainer(String name, int x, int y){
        for (ItemContainer container: this.itemContainers){
            if (Objects.equals(container.getName(), name) && container.getLocationX() == x && container.getLocationY() == y){
                return container;
            }
        }
        return null;
    };
}
