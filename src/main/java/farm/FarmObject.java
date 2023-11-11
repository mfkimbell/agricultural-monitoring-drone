package farm;

public abstract class FarmObject implements FarmComponent {
    protected String name;
    protected float price;
    protected float locationX;
    protected float locationY;
    protected float length;
    protected float width;
    protected float height;

    @Override
    public void changeName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void changePrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }
    @Override
    public void changeLocationX(float x) {
        this.locationX = x;
    }

    public float getLocationX(){
        return this.locationX;
    }
    @Override
    public void changeLocationY(float y) {
        this.locationY = y;
    }

    public float getLocationY(){
        return this.locationY;
    }
    @Override
    public void changeLength(float length) {
        this.length = length;

    }

    public float getLength(){
        return this.length;
    }
    @Override
    public void changeHeight(float height){
        this.height = height;
    }

    public float getHeight(){
        return this.height;
    }
    @Override
    public void changeWidth(float width){
        this.width = width;
    }
    public float getWidth(){
        return this.width;
    }
    @Override
    public void accept(FarmVisitor visitor){
        visitor.visit(this);
    }
}