package composite;

public interface BaseControl {
    void setBounds(Rectangle bounds);
    Rectangle getBounds();
    boolean checkBounds(Point point);
    void move(Point newPos);
    void scale(Float scl);
    void setEnabled(boolean enabled);
    void draw(Point offset);
    void draw();
}
