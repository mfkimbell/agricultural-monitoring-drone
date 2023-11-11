package farm;

public class MarketPriceCalculator implements FarmVisitor{
    float price;
    float marketValue;
    public float getPrice() {
        return this.price;
    }
    public float getMarketValue() {
        return this.marketValue;
    }

    public float deepGetPrice(ItemContainer ic){
        float price = ic.getPrice();
        System.out.println(price);
        for(ItemContainer container: ic.getItemContainers()){
            price += deepGetPrice(container);
        }
        for(Item item: ic.getItems()){
            price += item.getPrice();
        }
        return price;
    }

    public float deepGetMarketValue(ItemContainer ic){
        float price = ic.getMarketValue();
        for(ItemContainer container: ic.getItemContainers()){
            price += deepGetMarketValue(container);
        }
        for(Item item: ic.getItems()){
            price += item.getMarketValue();
        }
        return price;
    }

    @Override
    public void visit(FarmObject obj) {
        if(obj instanceof FarmItem) {
            FarmItem item = (FarmItem) obj;
            this.price = item.getPrice();
            this.marketValue = item.getMarketValue();
        }

        if(obj instanceof FarmBuilding){
            FarmBuilding building = (FarmBuilding) obj;
            this.price = deepGetPrice((ItemContainer) building);
            this.marketValue = deepGetMarketValue((ItemContainer) building);
        }
    }
}
