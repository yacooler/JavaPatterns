package composite.controls;

import composite.BaseControlObject;
import composite.Point;
import composite.Rectangle;

public class ButtonControl extends BaseControlObject {

    public ButtonControl() {
    }

    public ButtonControl(Rectangle bounds, String text) {
        setBounds(bounds);
        setText(text);
    }

    @Override
    public void draw(Point offset) {
        System.out.printf("Кнопка %s [%s, %s, %s, %s]\n",
                this.getText(),
                this.getBounds().getX() + offset.getX(),
                this.getBounds().getY() + offset.getY(),
                this.getBounds().getWidth(),
                this.getBounds().getHeight());
    }
}
