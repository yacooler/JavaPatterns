package composite.controls;

import composite.BaseControlObject;
import composite.Point;
import composite.Rectangle;

public class CheckBox extends BaseControlObject {
    protected boolean checked;

    public CheckBox() {

    }

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

    @Override
    public String serializeObject() {
        return super.baseSerialize() + ",checked:" + this.checked;
    }

    @Override
    public void deserializeObject(String serialized) {
        String remains = super.baseDeserialize(serialized);
        String[] param = new String[2];
        if (!remains.isBlank()) {
            param[0] = remains.substring(0, remains.indexOf(":"));
            param[1] = remains.substring(remains.indexOf(":") + 1);
            if (param[0].equalsIgnoreCase("checked")) {
                this.checked = param[1].equalsIgnoreCase("true");
            }
        }
    }
}
