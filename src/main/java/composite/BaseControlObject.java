package composite;

public abstract class BaseControlObject implements BaseControl{

    protected Rectangle bounds;
    protected String text;
    protected boolean enabled;

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    @Override
    public boolean checkBounds(Point point) {
        return bounds.isPointInBounds(point);
    }

    @Override
    public void move(Point newPos) {
        this.bounds.setX(newPos.getX());
        this.bounds.setY(newPos.getY());
    }

    @Override
    public void scale(Float scl) {
        this.bounds = new Rectangle(
                Math.round(bounds.getX() * scl),
                Math.round( bounds.getY() * scl),
                Math.round(bounds.width * scl),
                Math.round(bounds.getHeight() * scl));
    }



    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void draw(){
        this.draw(new Point(0,0));
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }


}
