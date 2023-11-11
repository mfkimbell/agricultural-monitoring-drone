package farm;

public abstract class Item extends FarmObject {
    protected float marketValue;

    public float getMarketValue() {
        return marketValue;
    }
    public void setMarketValue(float marketValue) {
        this.marketValue = marketValue;
    }

}
