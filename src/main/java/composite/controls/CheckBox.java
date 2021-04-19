package composite.controls;

import composite.BaseControlObject;
import composite.Point;
import composite.Rectangle;

public class CheckBox extends BaseControlObject {
    protected boolean checked;

    public CheckBox(Rectangle bounds, String text, boolean checked) {
        this.setBounds(bounds);
        this.setText(text);
        this.checked = checked;
    }

    @Override
    public void draw(Point offset){
        System.out.printf("Чекбокс %s [%s, %s, %s, %s] checked = %s\n",
                this.getText(),
                this.getBounds().getX() + offset.getX(),
                this.getBounds().getY() + offset.getY(),
                this.getBounds().getWidth(),
                this.getBounds().getHeight(),
                checked);
    }

    public boolean isChecked(){
        return checked;
    }
}
