public class Sedan extends Car{
    private int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        if(length>20)
        {
            return 0.95 * super.getSalePrice();
        }
        return 0.9 * super.getSalePrice();
    }
}
