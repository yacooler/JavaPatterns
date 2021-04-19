package composite.controls;

import composite.BaseControl;
import composite.Point;
import composite.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class CompositeControl implements BaseControl {

    Rectangle bounds = new Rectangle(0,0,0,0);

    List<BaseControl> baseControlList = new ArrayList<>();

    public CompositeControl() {
    }

    public CompositeControl(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void addControl(BaseControl control) {
        baseControlList.add(control);
    }

    public boolean removeControl(BaseControl control) {
        return baseControlList.remove(control);
    }

    @Override
    public void setBounds(Rectangle bounds) {

    }

    @Override
    public boolean checkBounds(Point point) {
        return getBounds().isPointInBounds(point);
    }

    @Override
    public void move(Point newPos) {
        baseControlList.forEach(control -> control.move(newPos));
    }

    @Override
    public void scale(Float scl) {
        baseControlList.forEach(control -> control.scale(scl));
    }


    @Override
    public void setEnabled(boolean enabled) {
        baseControlList.forEach(control -> control.setEnabled(enabled));
    }

    @Override
    public Rectangle getBounds() {
        int width = 0;
        int height = 0;

        for (BaseControl control : baseControlList) {
            if (control.getBounds().getWidth() > width) width = control.getBounds().getWidth();
            if (control.getBounds().getHeight() > height) height = control.getBounds().getHeight();
        }

        return new Rectangle(bounds.getX(), bounds.getY(), width, height);

    }

    @Override
    public void draw(Point offset) {
        Point containerOffset = new Point(bounds.getX() + offset.getX(), bounds.getY() + offset.getY());
        baseControlList.forEach(control -> control.draw(containerOffset));
    }

    @Override
    public void draw(){
        this.draw(new Point(0,0));
    }
}
