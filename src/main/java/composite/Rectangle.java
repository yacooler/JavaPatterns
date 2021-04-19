package composite;

public class Rectangle {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point pos, int width, int height) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPointInBounds(Point point){
        return point.getX() >= this.getX()
                && point.getY() >= this.getY()
                && point.getX() <= this.getX() + this.getWidth()
                && point.getY() <= this.getY() + this.getHeight();
    }

}
