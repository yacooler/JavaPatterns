package composite.controls;

import composite.BaseControlObject;
import composite.Point;
import composite.Rectangle;

public class TextControl extends BaseControlObject {

    protected boolean password;

    public TextControl(Rectangle bounds, String text) {
        this.setBounds(bounds);
        this.setText(text);
    }

    public TextControl(Rectangle bounds, String text, boolean password) {
        this.setBounds(bounds);
        this.setText(text);
        this.setPassword(password);
    }

    @Override
    public void draw(Point offset) {
        System.out.printf("Текст %s [%s, %s, %s, %s] password = %s\n",
                this.getText(),
                this.getBounds().getX() + offset.getX(),
                this.getBounds().getY() + offset.getY(),
                this.getBounds().getWidth(),
                this.getBounds().getHeight(),
                password);
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }
}
