package composite.controls;

import composite.BaseControlObject;
import composite.Point;

public class Label extends BaseControlObject {
    @Override
    public void draw(Point offset) {
        System.out.printf("Надпись %s [%s, %s, %s, %s]\n",
                this.getText(),
                this.getBounds().getX() + offset.getX(),
                this.getBounds().getY() + offset.getY(),
                this.getBounds().getWidth(),
                this.getBounds().getHeight());
    }
}
